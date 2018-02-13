package gui.scenarioEditor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import enamel.ScenarioParser;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utility.Language;
/**
 * Scenario menu controller.
 * @author Jinho Hwang
 *
 */

public class ScenarioEditorController {
	
	// List of file loaded.
	List<File> fileList;
	
	// List of FXML components
	// List
	@FXML
	ListView<String> scenarioList;
	
	// Main panel
	@FXML
	AnchorPane root;
	
	// OberservableList for List items.
	ObservableList<String> obsFileList;
	
	// Initialize the fileList.
	// TODO : make a model for scenario Editor to keep track of.
	public ScenarioEditorController(){
		fileList = new ArrayList<File>();
		
	}
	
	
	/**
	 * Loads up scenario files into the fileList and set view of names of file in the fileList.
	 * This method uses FileChooser to pickup multiple scenario files.
	 * @author Jinho Hwang
	 * @throws IOException
	 */
	public void loadScenario() throws IOException {
		Stage window = new Stage();
		
		// Create fileChooser and set its title
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(Language.scenarioEditorLoadFileChooserTitle);
		
		// Set starting directory ( the directory you start to select from )
		fileChooser.setInitialDirectory(new File("./FactoryScenarios").getCanonicalFile());
		
		// Create a dummy variable for list of file chosen 
		//( selectedFile can be null if user decides to not get a file )
		List<File> selectedFile = fileChooser.showOpenMultipleDialog(window);
		
		// If user got a file
		if(selectedFile != null) {
			// Add the list of file chosen into fileList
			fileList.addAll(selectedFile);
			
			// Initialize observable file lists
			obsFileList = FXCollections.observableArrayList();
			
			// Transfer all the file names into observable file lists
			for(File file : fileList) {
				obsFileList.add(file.getName());
			}
			
			// Set the view of List to the list of File names.
			scenarioList.setItems(obsFileList);
		}
	
	}
	
	/**
	 * This method runs selected scenario from the list.
	 * If nothing was selected or list is empty, nothing happens when button is clicked.
	 * @author Jinho Hwang
	 */
	public void runScenario() {
		
		// If the list is empty or not elected then
		if(!scenarioList.getSelectionModel().isEmpty()){
			
			// Get the selected item index from the list
			int index = scenarioList.getSelectionModel().getSelectedIndex();
					
			// debug
/*			System.out.println("running : " + fileList.get(index));
			System.out.println("index : " + scenarioList.getSelectionModel().getSelectedIndex());*/
			
			// Start a Thread to start enamel program. Thread is needed to run without an error.
			Thread starterCodeThread = new Thread("Starter Code Thread") {
			    public void run(){    
			    	//Open Scenario simulator, allow visual
			        ScenarioParser s = new ScenarioParser(true);
			        
			        //Set Scenario simulator to run the file from the fileList. (not from GUI list)
					s.setScenarioFile(fileList.get(index).getPath());
			    }
			};
			starterCodeThread.start();
				
			
		}
	}
	
	/**
	 * This method is for user to save a list-selected scenario from
	 * scenario list on the scenario editor.
	 * @author Jinho Hwang
	 */
	public void saveScenario() {
		// TODO : add saving feature using FileChooser.
		
		// If the list is empty or not elected then
		if(!scenarioList.getSelectionModel().isEmpty()) {
			
			try {
				
				// New window other then scenario Editor
				Stage window = new Stage();
				
				// Get the selected item index from the list
				int index = scenarioList.getSelectionModel().getSelectedIndex();
				
				// Create fileChooser and set its title
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle(Language.scenarioEditorSaveFileChooserTitle);
				
				// Set starting directory ( the directory you start to select from )
				fileChooser.setInitialDirectory(new File("./FactoryScenarios").getCanonicalFile());
				
				// Create a dummy variable for customized file.
				//( selectedFile can be null if user decides to not to make a file )
				File writtenFile = fileChooser.showSaveDialog(window);
				
				// If user pressed save after write its name,
				if(writtenFile != null ) {
					
					// Create fileWriter and scanner to read selected file from the fileList.
					Writer fileWriter = new FileWriter(writtenFile);
					Scanner scenarioFileString = new Scanner(fileList.get(index));
					
					// Create a String to write.
					String scenarioScript = "";
					
					// Copy all the contents from the selected file to scenarioScript.
					while(scenarioFileString.hasNextLine()) {
						scenarioScript += scenarioFileString.nextLine() + "\n";
					}
					
					// Writes file with user written property with list-selected scenario
					fileWriter.write(scenarioScript);
					
					// Closes IOStream.
					scenarioFileString.close();
					fileWriter.close();
				}
					
			} catch (IOException e) {
				e.printStackTrace(); // Happens when factory Scenarios folder do not exit.
			}
			
			
		}
	}
	
	/**
	 * This method is used for Exiting ( hiding ) editor.
	 * May change it later by closing it completely.
	 * @Author Jinho Hwang
	 */
	public void hideScenarioEditor() {
		root.getScene().getWindow().hide();
	}
	
	
	

	
	
}

/**
 * 
 */
package utility;

import java.io.File;
import java.security.CodeSource;
import java.time.Instant;
import java.util.Date;

import javafx.scene.input.KeyCode;
import startProgram.AuthoringApp;

/**
 * This class contains all the possible strings used by classes and fxml.
 * @author Jinho Hwang
 *
 */
public final class Language {
	
	public static final String emptyString = "";
	public static final String nullString = null;
	public static final String scenarioFileFormat = ".txt";
	public static final String logFileFormat = ".txt";
	public static final String audioFileFormat = ".wav";
	
	public static final CodeSource codeSource = AuthoringApp.class.getProtectionDomain().getCodeSource();
	public static final File jarFile = new File(codeSource.getLocation().getPath());
	public static final String rootPath = jarFile.getParentFile().getPath();
	
	//public static final String viewPath = "." + File.separator + "gui" + File.separator + "resources" + File.separator + "view" + File.separator;
	public static final String viewPath = "/gui/resources/view/";
	public static final String scenarioPath = rootPath + File.separator + "FactoryScenarios" + File.separator;
	public static final String audioPath = scenarioPath + "AudioFiles" + File.separator;
	public static final String errorPath = rootPath + File.separator + "errors" + File.separator;
	public static final String userLogPath = rootPath + File.separator + "logs" + File.separator;
	
	public static final Date startDate = Date.from(Instant.now());
	
	public static final File userLog = new File(Language.userLogPath + Language.startDate.toString().replaceAll(" ", "_").replaceAll(":", "-") + Language.logFileFormat);
	public static final File userCountLog = new File(Language.userLogPath + "FeatureAccessed"+ Language.logFileFormat);
	
	
	
	public static final KeyCode openKey = KeyCode.ENTER;
	
	public static final KeyCode key_MainMenuScenarioEditor = KeyCode.S;
	public static final KeyCode key_MainMenuVoiceRecorder = KeyCode.V;
	public static final KeyCode key_MainMenuExit = KeyCode.ESCAPE;
	
	public static final KeyCode key_ScenarioEditorNewScneario = KeyCode.C;
	public static final KeyCode key_ScenarioEditorEditScenario = KeyCode.E;
	public static final KeyCode key_ScenarioEditorSaveScneario = KeyCode.S;
	public static final KeyCode key_ScenarioEditorLoadScneario = KeyCode.L;
	public static final KeyCode key_ScenarioEditorRunScneario = KeyCode.R;
	public static final KeyCode key_ScenarioEditorRemoveScneario = KeyCode.M;
	public static final KeyCode key_ScenarioEditorExitScneario = KeyCode.ESCAPE;
	
	public static final KeyCode key_VoiceRecorderRecord = KeyCode.R;
	public static final KeyCode key_VoiceRecorderDelete = KeyCode.D;
	public static final KeyCode key_VoiceRecorderPlay = KeyCode.P;
	public static final KeyCode key_VoiceRecorderLoad = KeyCode.L;
	public static final KeyCode key_VoiceRecorderExit = KeyCode.ESCAPE;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static final String commandPrefix = "/~";
	
	final static String[] typeList = { 
			"/~sound:", 
			"/~skip:", 
			"/~pause:", 
			"/~repeat-button:", 
			"/~repeat",
			"/~endrepeat", 
			"/~reset-buttons", 
			"/~skip-button:", 
			"/~disp-clearAll", 
			"/~disp-cell-pins:",
			"/~disp-string:", 
			"/~disp-cell-char:", 
			"/~disp-cell-raise:", 
			"/~disp-cell-lower:", 
			"/~disp-cell-clear:",
			"/~user-input" 
			};
	
	final static String[] typeListOneArgument = {
			"/~pause:",
			"/~disp-string:", 
			"/~repeat-button:",
			"/~sound:", 
			"/~skip:", 
			"/~disp-cell-clear:"
	};
	
	final static String[] typeListTwoArguments = {
			"/~skip-button:", 
			"/~disp-cell-pins:",
			"/~disp-cell-char:",
			"/~disp-cell-raise:", 
			"/~disp-cell-lower:", 
	};
	
	final static String[] typeListFirstArgNumber = {
			"/~pause:", 
			"/~repeat-button:",
			"/~skip-button:", 
			"/~disp-cell-clear:",
			"/~disp-cell-pins:",
			"/~disp-cell-char:", 
			"/~disp-cell-raise:", 
			"/~disp-cell-lower:"
	};
	
	final static String[] typeListFirstArgString = {
			"/~disp-string:", 
			"/~sound:", 
			"/~skip:"
	};
	
	final static String[] typeListSecondArgNumber = {
			"/~disp-cell-pins:",
			"/~disp-cell-raise:", 
			"/~disp-cell-lower:"
	};
	
	final static String[] typeListSecondArgString = {
			"/~skip-button:", 
			"/~disp-cell-char:"
	};
	
	
	//public static final KeyCode sayCurrentWindowKey = KeyCode.BACK_QUOTE;
	
	// Fxml directory
	private static final String mainMenuFxml = viewPath + "MainMenu.fxml";
	private static final String scenarioEditorFxml = viewPath + "ScenarioEditor.fxml";
	private static final String scenarioMakerFxml = viewPath + "ScenarioMaker.fxml";
	private static final String errorListReportPopUpBoxFxml = viewPath + "ErrorListReportPopUpBox.fxml";
	private static final String createCommandPopUpBoxFxml = viewPath + "CreateCommandPopUpBox.fxml";
	private static final String voiceRecorderFxml = viewPath + "VoiceRecorder.fxml";
	private static final String textAnswerBoxFxml = viewPath + "TextAnswerBox.fxml";
	private static final String twoChoiceBoxFxml = viewPath + "TwoChoiceBox.fxml";
	
	public static String fxmlPath(String className) {
		switch(className) {
		
		case "MainMenu" : return mainMenuFxml; 
		case "ScenarioEditor" : return scenarioEditorFxml;
		case "ScenarioMaker" : return scenarioMakerFxml;
		case "ErrorListReportPopUpBox" : return errorListReportPopUpBoxFxml;
		case "CreateCommandPopUpBox" : return createCommandPopUpBoxFxml;
		case "VoiceRecorder" : return voiceRecorderFxml;
		case "TextAnswerBox" : return textAnswerBoxFxml;
		case "TwoChoiceBox" : return twoChoiceBoxFxml;
		
		default : throw new IllegalArgumentException("Class with the given class name does not have a fxml!");
		}
	}
	
	public static String titleName(String className) {
		switch(className){
		
		case "MainMenu" : return mainMenuTitle; 
		case "ScenarioEditor" : return scenarioEditorTitle;
		case "ScenarioMaker" : return scenarioMakerTitle;
		case "ErrorListReportPopUpBox" : return emptyString;
		case "CreateCommandPopUpBox" : return createCommandPopUpBoxTitle;
		case "VoiceRecorder" : return voiceRecorderTitle;
		case "TextAnswerBox" : return emptyString;
		case "TwoChoiceBox" : return emptyString;
		
		default : throw new IllegalArgumentException("Class with the given class name does not have a title!");
		}
	}
	
	// CSS directory
	public static final String mainMenuCss = "/gui/resources/css/MainMenu.css";
	 
	// Main menu Strings
	public static final String mainMenuTitle = "Authoring App";
	
	// Scenario editor Strings
	public static final String scenarioEditorTitle = "Scenario Editor";
	public static final String scenarioEditorLoadFileChooserTitle = "Open Scenario";
	public static final String scenarioEditorSaveFileChooserTitle = "Save Scenario";

	
	// Scanerio maker Strings
	public static final String scenarioMakerTitle = "Scanerio Maker";
	
	// PopupBox Strings
	//public static final String errorListReportPopUpBoxTitle = "";
	public static final String createCommandPopUpBoxTitle = "Create Scenario";
	
	// Voice Recorder Strings
	public static final String voiceRecorderTitle = "Voice Recorder";
	public static final String voiceRecorderFileChooserTitle = "Choose sound files";
	
	// Text answerbox title
	//public static final String textAnswerBoxTitle = "";
	
	
	//These are unused so far due to imcompatibility of scenebuilder to the variable String.
	
	// Main menu Strings
	public static final String mainMenuExitButton = "Exit";
	public static final String mainMenuScenarioEditorButton = "Scenario Editor";
	public static final String mainMenuBraileProjectLabel = "Braile Project";
	//? Main menu Strings

	
	// Scenario editor Strings
	
	public static final String scenarioEditorCreateScenario = "Create a new Scenario";
	public static final String scenarioEditorEditScenario = "Edit selected Scenario";
	public static final String scenarioEditorSaveScenario = "Save selected Scenario";
	public static final String scenarioEditorLoadScenario = "Load Scenario";
	public static final String scenarioEditorRunScenario = "Run Selected Scenario";
	public static final String scenarioEditorExit = "Exit";
	//? Scenario editor Strings
	
	
	
	//? unused
}

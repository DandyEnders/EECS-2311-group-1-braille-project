package utility;

/**
 * A class representing a phrase.
 * @author Jinho Hwang
 *
 */

public class Phrase {
	private String type;
	private Phrase flag; // for repeat / end repeat
	private String[] arguments = new String[2]; // for button, cell , etc
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Phrase getFlag() {
		return flag;
	}

	public void setFlag(Phrase flag) {
		this.flag = flag;
	}

	public String[] getArguments() {
		return arguments;
	}

	public void setArguments(String[] arguments) {
		this.arguments = arguments;
	}

	/**
	 * Takes a type (String) of a phrase.
	 *  
	 * @param type
	 * 		Type of a phrase, Ex: reset, repeat, etc
	 */
	public Phrase(String type) {
		this.type = type;
		this.flag = null;
		String[] arguments = {null, null};
		
		this.arguments = arguments;
	}
	
	public Phrase(String type, String argument) {
		this.type = type;
		this.flag = null;
		String[] arguments = {argument, null};
		
		this.arguments = arguments;
	}
	
	/**
	 * Takes a type (String) and value (String) of a phrase.
	 * 
	 * @param type
	 * 		Type of a phrase, Ex: reset, repeat, etc
	 * @param value
	 * 		Value of a argument value, Ex: 1, 2, one, two, etc
	 */
	public Phrase(String type, String[] arguments){
		this(type,arguments,null);
	}
	
	/**
	 * Takes a type (String), value (String), and flag (Phrase)
	 * of a phrase.
	 * 
	 * @param type
	 * 		Type of a phrase, Ex: reset, repeat, etc
	 * @param value
	 * 		Value of a argument value, Ex: 1, 2, one, two, etc
	 * @param flag
	 * 		A reference to another phrase, Ex : repeat phrase has
	 * 		a flag of endrepeat.
	 */
	public Phrase(String type, String[] arguments, Phrase flag){
		this.type = type;
		this.arguments = arguments;
		this.flag = flag;
	}

	/**
	 * @param obj
	 * 			Phrase to compare to.
	 * @return true
	 * 			If this.equals(phrase) meets equal contracts. ( look Object API )
	 */
	@Override
	public boolean equals(Object obj){
		if (obj == null){
			return false;
		}
		if (this == obj){
			return true;
		}
		if (obj.getClass() != this.getClass()){
			return false;
		}
		
		Phrase phrase = (Phrase)obj;
		
		if (this.type.equals(phrase.getType())){
			if(this.getArguments()[0].equals(phrase.getArguments()[0])){
				if(this.getArguments()[1].equals(phrase.getArguments()[1])){
					if(this.flag == phrase.getFlag()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		String firstArg;
		String secondArg;
		
		if(this.getArguments()[0] == null) {
			firstArg = "";
		}else {
			firstArg = this.getArguments()[0];
		}
		
		if(this.getArguments()[1] == null) {
			secondArg = "";	
		}else {
			secondArg = this.getArguments()[1];
		}
		
		if(this.getArguments()[0] == null && this.getArguments()[1] == null) {
			return this.getType();
		}
		else if(this.getArguments()[0] != null && this.getArguments()[1] == null) {
			return this.getType() + firstArg;
		}
		else{
			return this.getType() + firstArg + " " + secondArg;
		}
	}
}
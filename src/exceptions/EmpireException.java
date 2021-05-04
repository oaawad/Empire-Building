package exceptions;

public abstract class EmpireException extends Exception{
	// A subclass of Exception, representing a generic exception that can occur during the game play. These exceptions arise from any invalid action that is performed.
	
	public EmpireException() {
		super();
	}
	public EmpireException(String s) {
		super(s);
	}
}

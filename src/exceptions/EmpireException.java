package exceptions;

public abstract class EmpireException extends Exception{
	// A subclass of Exception. Class representing a generic exception that can occur during the game play. These exceptions arise from any invalid action that is performed.
	protected EmpireException() {
		super();
	}
	protected EmpireException(String s) {
		super(s);
	}
}

package exceptions;

public abstract class ArmyException extends EmpireException{
   // A subclass of EmpireException representing an exception that occurs when trying to do invalid actions related to armies.
	
   protected ArmyException() {
		super();
	}
	protected ArmyException(String s) {
		super(s);
	}
}
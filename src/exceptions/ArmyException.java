package exceptions;

public abstract class ArmyException extends EmpireException{
   // A subclass of EmpireException representing an exception that occurs when trying to do invalid actions related to armies.
	
   public ArmyException() {
		super();
	}
	public ArmyException(String s) {
		super(s);
	}
}
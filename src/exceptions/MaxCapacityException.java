package exceptions;

public class MaxCapacityException extends ArmyException {
    // A subclass of ArmyException representing an exception that occurs when trying to add more units in an army while the maximum capacity was reached .
    public MaxCapacityException() {
		super();
	}
    public MaxCapacityException(String s) {
		super(s);
	}
	
}

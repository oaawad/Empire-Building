package exceptions;

public class FriendlyFireException extends ArmyException {
    // A subclass of ArmyException representing an exception that occurs when trying to attack a friendly army
    protected FriendlyFireException() {
		super();
	}
	protected FriendlyFireException(String s) {
		super(s);
	}
	
}

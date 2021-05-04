package exceptions;

public class FriendlyFireException extends ArmyException {
    // A subclass of ArmyException representing an exception that occurs when trying to attack a friendly army
    
	public FriendlyFireException() {
		super();
	}
	public FriendlyFireException(String s) {
		super(s);
	}
}

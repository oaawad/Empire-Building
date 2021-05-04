package exceptions;

public class FriendlyCityException extends ArmyException {
    // A subclass of ArmyException representing an exception that occurs when trying to attack a friendly city
    
	public FriendlyCityException() {
		super();
	}
	public FriendlyCityException(String s) {
		super(s);
	}
}

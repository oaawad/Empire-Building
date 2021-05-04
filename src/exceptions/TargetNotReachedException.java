package exceptions;

public class TargetNotReachedException extends ArmyException {
    // A subclass of ArmyException representing an exception that occurs when trying to attack a with an army while it haven’t reached the target city location. yet.

    public TargetNotReachedException() {
		super();
	}
	public TargetNotReachedException(String s) {
		super(s);
	}
}

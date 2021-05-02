package exceptions;

public class MaxLevelException extends BuildingException {
    // A subclass of BuildingException representing an exception that occurs when trying to do an action with a building while there isn’t enough gold(treasury) for this action.
	public MaxLevelException() {
		super();
	}
	public MaxLevelException(String s) {
		super(s);
	}
	
}

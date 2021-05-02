package exceptions;

public class NotEnoughGoldException extends BuildingException {
    // A subclass of BuildingException representing an exception that occurs when trying to do an action with a building while there isn’t enough gold(treasury) for this action.
    protected NotEnoughGoldException() {
		super();
	}
	protected NotEnoughGoldException(String s) {
		super(s);
	}
	
}

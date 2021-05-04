package exceptions;

public class NotEnoughGoldException extends BuildingException {
    // A subclass of BuildingException representing an exception that occurs when trying to do an action with a building while there isn’t enough gold(treasury) for this action.
    
	public NotEnoughGoldException() {
		super();
	}
	public NotEnoughGoldException(String s) {
		super(s);
	}	
}

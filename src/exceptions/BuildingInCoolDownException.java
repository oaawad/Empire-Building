package exceptions;

public class BuildingInCoolDownException extends BuildingException {
	// A subclass of BuildingException representing an exception that occurs when trying to do an action with a building while the building is cooling down.

	public BuildingInCoolDownException() {
		super();
	}
	public BuildingInCoolDownException(String s) {
		super(s);
	}
}

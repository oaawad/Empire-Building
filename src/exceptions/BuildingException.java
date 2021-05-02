package exceptions;

public abstract class BuildingException extends EmpireException {
	// A subclass of EmpireException representing an exception that occurs when trying t do invalid actions related to buildings.
	
	public BuildingException() {
		super();
	}
	public BuildingException(String s) {
		super(s);
	}
	
}

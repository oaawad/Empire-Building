package exceptions;

public abstract class BuildingException extends EmpireException {
	//: A subclass of EmpireException representing an exception that occurs when trying t do invalid actions related to buildings.
	protected BuildingException() {
		super();
	}
	protected BuildingException(String s) {
		super(s);
	}
	
}

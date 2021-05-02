package exceptions;

public class MaxRecruitedException extends BuildingException {
   // A subclass of BuildingException representing an exception that occurs when trying to recruit a unit with a building while the building reaches the maximum number of unit per turn.
        protected MaxRecruitedException() {
		super();
	}
	protected MaxRecruitedException(String s) {
		super(s);
	}
	
}

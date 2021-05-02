package buildings;

public abstract class MilitaryBuilding extends Building{
// A subclass of Building representing military buildings
	
	private int recruitmentCost;  // The cost for recruiting a unit.
	private int currentRecruit;   // Current number of units recruited by a building inside a turn
	private final int maxRecruit = 3;       // Maximum number of units a building can recruit per turn. Any building can recruit only 3 units per turn
	
	public MilitaryBuilding(int cost, int upgradeCost, int recruitmentCost) {
		super(cost, upgradeCost);
		this.recruitmentCost = recruitmentCost;
	}

	public int getRecruitmentCost() {
		return recruitmentCost;
	}

	public void setRecruitmentCost(int recruitmentCost) {
		this.recruitmentCost = recruitmentCost;
	}

	public int getCurrentRecruit() {
		return currentRecruit;
	}

	public void setCurrentRecruit(int currentRecruit) {
		this.currentRecruit = currentRecruit;
	}

	public int getMaxRecruit() {
		return maxRecruit;
	}


}

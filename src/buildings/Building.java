package buildings;

public abstract class Building {
	//A class representing a building
	
	private int cost; // The cost for creating a building
	private int level = 1; // The current level of the building, All buildings start from level 1
	private int upgradeCost; // The cost for upgrading building's level
	private boolean coolDown = true; // A variable stating if the building is cooling down.
	
	//Constructors
	public Building(int cost, int upgradeCost) {
		this.cost = cost;
		this.upgradeCost = upgradeCost;
	}
	
	// Setters & Getters
	public int getCost() {
		return cost;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getUpgradeCost() {
		return upgradeCost;
	}

	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}

	public boolean isCoolDown() {
		return coolDown;
	}

	public void setCoolDown(boolean coolDown) {
		this.coolDown = coolDown;
	}
}

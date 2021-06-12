package buildings;

import exceptions.*;

public class Farm extends EconomicBuilding {

	//A farm is an EconomicBuilding with 1000 cost and 500 upgradeCost.
	
	public Farm() {
		super(1000, 500);
	}
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		if (this.isCoolDown())
			throw new BuildingInCoolDownException("This building is currently in cool down");
		if (this.getLevel() == 1) {
			this.setLevel(2);
			this.setUpgradeCost(700);
		}
		else if (this.getLevel() == 2) 
			this.setLevel(3);
		else {
			throw new MaxLevelException("This building reached the maximum level");
		}
		this.setCoolDown(true); 
	}

	public  int harvest() {
		if (this.getLevel() == 1)
			return 500;
		else if (this.getLevel() == 2)
			return 700;
		else
			return 1000;
	}
}

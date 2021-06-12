package buildings;

import exceptions.*;

public class Market extends EconomicBuilding {

	//A Market is an EconomicBuilding with 1500 cost and 700 upgradeCost.
	
	public Market() {
		super(1500, 700);
	}

	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		if (this.isCoolDown())
			throw new BuildingInCoolDownException("This building is currently in cool down");
		if (this.getLevel() == 1) {
			this.setLevel(2);
			this.setUpgradeCost(1000);
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
			return 1000;
		else if (this.getLevel() == 2)
			return 1500;
		else
			return 2000;
	}		 
}

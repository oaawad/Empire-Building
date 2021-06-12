package buildings;

import exceptions.*;
import units.*;

public class Barracks extends MilitaryBuilding {
	//A barracks is a military building with 2000 cost, 1000 upgradeCost and 500 recruitmentCost.
	
	//Constructor
	public Barracks() {
		super(2000, 1000, 500);
	}
	
	//Methods
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		if (this.isCoolDown())
			throw new BuildingInCoolDownException("This building is currently in cool down");
		if (this.getLevel() == 1) {
			this.setLevel(2);
			this.setRecruitmentCost(550);
			this.setUpgradeCost(1500);
		}
		else if (this.getLevel() == 2) {
			this.setLevel(3);
			this.setRecruitmentCost(600);
		}
		else {
			throw new MaxLevelException("This building reached the maximum level");
		}
		this.setCoolDown(true); 
	}
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException {			
		if(this.isCoolDown()) 
			throw new BuildingInCoolDownException("This building is currently in Cool Down");
		
		if (this.getCurrentRecruit() < this.getMaxRecruit()) {
			Infantry A = null;
			if(this.getLevel() == 1) {
				A = new Infantry(1,50,0.5,0.6,0.7);
				this.setCurrentRecruit(getCurrentRecruit()+1);	
			}
			else if (this.getLevel() == 2) {
				A = new Infantry(2,50,0.5,0.6,0.7);
				this.setCurrentRecruit(getCurrentRecruit()+1);
			}
			else {
				A = new Infantry(3,60,0.6,0.7,0.8);
				this.setCurrentRecruit(getCurrentRecruit()+1);
			}
			return A;
		}
		else
			throw new MaxRecruitedException("This building reached the maximum number of recruited units.");
	}
}

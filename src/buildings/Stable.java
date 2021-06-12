package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Cavalry;
import units.Unit;

public class Stable extends MilitaryBuilding {

	//A Stable is a military building with 2500 cost, 1500 upgradeCost and 600 recruitmentCost.
	
	public Stable() {
		super(2500, 1500, 600);
	}

	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		if (this.isCoolDown())
			throw new BuildingInCoolDownException("This building is currently in cool down");
		if (this.getLevel() == 1) {
			this.setLevel(2);
			this.setRecruitmentCost(650);
			this.setUpgradeCost(2000);
		}
		else if (this.getLevel() == 2) {
			this.setLevel(3);
			this.setRecruitmentCost(700);
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
			Cavalry A = null;
			if(this.getLevel() == 1) {
				A = new Cavalry(1,40,0.6,0.7,0.75);
				this.setCurrentRecruit(getCurrentRecruit()+1);	
			}
			else if (this.getLevel() == 2) {
				A = new Cavalry(2,40,0.6,0.7,0.75);
				this.setCurrentRecruit(getCurrentRecruit()+1);
			}
			else {
				A = new Cavalry(3,60,0.7,0.8,0.9);
				this.setCurrentRecruit(getCurrentRecruit()+1);
			}
			return A;
		}
		else
			throw new MaxRecruitedException("This building reached the maximum number of recruited units.");
	}
}

package buildings;

import exceptions.*;
import units.*;

public class ArcheryRange extends MilitaryBuilding {

	public ArcheryRange() {
		super(1500, 800, 400);

	}
	
	// could be changed later 
	 public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		 if (this.isCoolDown())
			 throw new BuildingInCoolDownException("This building is currently in cool down");
		 if (this.getLevel() == 1) {
			this.setLevel(2);
			this.setUpgradeCost(700);
			this.setRecruitmentCost(450);
		}
		else if (this.getLevel() == 2) {
			this.setLevel(3);
			this.setRecruitmentCost(500);
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
			 Archer A = null;
			 if(this.getLevel() == 1) {
				 A = new Archer(1,60,0.4,0.5,0.6);
				 this.setCurrentRecruit(getCurrentRecruit()+1);	
			 }
			 else if (this.getLevel() == 2) {
				 A = new Archer(2,60,0.4,0.5,0.6);
				 this.setCurrentRecruit(getCurrentRecruit()+1);
			 }
			 else {
				A = new Archer(3,70,0.5,0.6,0.7);
				this.setCurrentRecruit(getCurrentRecruit()+1);
			 }
			 return A;
		 }
		 else
			 throw new MaxRecruitedException("This building reached the maximum number of recruited units.");
	}

}

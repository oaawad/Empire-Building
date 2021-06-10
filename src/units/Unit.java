package units;
import exceptions.FriendlyFireException;
import java.util.*;


public abstract class Unit {
	private int level;
	private int maxSoldierCount;
	private int currentSoldierCount;
	private double idleUpkeep;
	private double marchingUpkeep;
	private double siegeUpkeep;
	private Army parentArmy;

	public Unit(int level, int maxSoldierCount, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
		this.level = level;
		this.maxSoldierCount = maxSoldierCount;
		this.idleUpkeep = idleUpkeep;
		this.marchingUpkeep = marchingUpkeep;
		this.siegeUpkeep = siegeUpkeep;
		this.currentSoldierCount = maxSoldierCount;

	}

	public int getCurrentSoldierCount() {
		return currentSoldierCount;
	}

	public void setCurrentSoldierCount(int currentSoldierCount) {
		this.currentSoldierCount = currentSoldierCount;
	}

	public int getLevel() {
		return level;
	}

	public int getMaxSoldierCount() {
		return maxSoldierCount;
	}

	public double getIdleUpkeep() {
		return idleUpkeep;
	}

	public double getMarchingUpkeep() {
		return marchingUpkeep;
	}

	public double getSiegeUpkeep() {
		return siegeUpkeep;
	}

	public Army getParentArmy() {
		return parentArmy;
	}

	public void setParentArmy(Army parentArmy) {
		this.parentArmy = parentArmy;
	}
	
	 public void attack(Unit target) throws FriendlyFireException {
		 
		 if(this.getParentArmy().equals(target.getParentArmy()))
			 throw new FriendlyFireException("You can't attack yor own units!");
		 
		 if(this instanceof Archer)
		 {
			 switch(this.getLevel()) {
			 
			 case 1:
				 
				 if(target instanceof Archer) {
					 if(target.getCurrentSoldierCount()<=(int)(0.3*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.3*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Infantry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.2*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.2*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Cavalry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.1*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.1*this.getCurrentSoldierCount()));
				 }
				 break;
				 
			 case 2:
				 
				 if(target instanceof Archer) {
					 if(target.getCurrentSoldierCount()<=(int)(0.4*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.4*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Infantry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.3*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.3*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Cavalry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.1*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.1*this.getCurrentSoldierCount()));
				 }
				 break;
				 
			 case 3:
				 
				 if(target instanceof Archer) {
					 if(target.getCurrentSoldierCount()<=(int)(0.5*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.5*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Infantry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.4*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.4*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Cavalry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.2*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.2*this.getCurrentSoldierCount()));
				 }
				 break;
			  
			 }
		 }
			 
		 if(this instanceof Infantry)
		 {
			 switch(this.getLevel()) {
			 
			 case 1:
				 
				 if(target instanceof Archer) {
					 if(target.getCurrentSoldierCount()<=(int)(0.3*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.3*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Infantry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.1*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.1*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Cavalry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.1*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.1*this.getCurrentSoldierCount()));
				 }
				 break;
				 
			 case 2:
				 
				 if(target instanceof Archer) {
					 if(target.getCurrentSoldierCount()<=(int)(0.4*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.4*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Infantry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.2*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.2*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Cavalry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.2*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.2*this.getCurrentSoldierCount()));
				 }
				 break;
				 
			 case 3:
				 
				 if(target instanceof Archer) {
					 if(target.getCurrentSoldierCount()<=(int)(0.5*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.5*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Infantry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.3*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.3*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Cavalry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.25*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.25*this.getCurrentSoldierCount()));
				 }
				 break;
			  
			 }
		 }
		 if(this instanceof Cavalry)
		 {
			 switch(this.getLevel()) {
			 
			 case 1:
				 
				 if(target instanceof Archer) {
					 if(target.getCurrentSoldierCount()<=(int)(0.5*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.5*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Infantry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.3*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.3*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Cavalry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.2*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.2*this.getCurrentSoldierCount()));
				 }
				 break;
				 
			 case 2:
				 
				 if(target instanceof Archer) {
					 if(target.getCurrentSoldierCount()<=(int)(0.6*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.6*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Infantry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.4*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.4*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Cavalry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.2*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.2*this.getCurrentSoldierCount()));
				 }
				 break;
				 
			 case 3:
				 
				 if(target instanceof Archer) {
					 if(target.getCurrentSoldierCount()<=(int)(0.7*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.7*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Infantry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.5*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.5*this.getCurrentSoldierCount()));
				 }
				 if(target instanceof Cavalry) {
					 if(target.getCurrentSoldierCount()<=(int)(0.3*this.getCurrentSoldierCount()))
						 target.setCurrentSoldierCount(0);
					 else
						 target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(0.3*this.getCurrentSoldierCount()));
				 }
				 break;
			  
			 }
		 }
			 
			
		target.getParentArmy().handleAttackedUnit(target);
		 	 
  }
	 
	 public static void main(String[] args) {
		 Infantry i = new Infantry(1,50,0.4,0.3,0.2);
		 Archer ar = new Archer(1,50,0.4,0.3,0.2);
		 Cavalry c = new Cavalry(1,50,0.4,0.3,0.2);
		 ArrayList<Unit> l = new ArrayList<Unit>();
		 Army a = new Army("adasdas");
		 Army b = new Army("gdfgdfg");
		 
		 i.setParentArmy(a);
		 ar.setParentArmy(b);
		 try {
			i.attack(ar);
			System.out.println(ar.getCurrentSoldierCount());
		} catch (FriendlyFireException e) {
			// TODO Auto-generated catch block
			
		}
		 
	 }
}	 

package units;

import java.util.ArrayList;

import exceptions.MaxCapacityException;


public class Army{
	private Status currentStatus;
	private ArrayList<Unit> units;
	private int distancetoTarget;
	private String target;
	private String currentLocation;
	private final int maxToHold=10;

	//Methods
	public Army(String currentLocation) {
		this.currentLocation=currentLocation;
		currentStatus=Status.IDLE;
		units=new ArrayList<Unit>();
		distancetoTarget=-1;
		target="";
	}
	public void relocateUnit(Unit unit) throws MaxCapacityException{
		if (units.size() < this.maxToHold) {
			units.add(unit);
			unit.getParentArmy().getUnits().remove(unit);
			unit.setParentArmy(this);
			}
		else
			throw new MaxCapacityException("This Army has reached the maximum capacity of units");
	}
	public void handleAttackedUnit(Unit u) {
		if((u.getCurrentSoldierCount()==0)) 
			this.getUnits().remove(u);
		}
	public double foodNeeded() {
		double neededFood = 0;
		if (this.currentStatus.equals(Status.IDLE)) {
			for(Unit u : units) 
			neededFood += (u.getIdleUpkeep() * u.getCurrentSoldierCount());		
		}
		else if (this.currentStatus.equals(Status.MARCHING)) {
			for(Unit u : units) 
			neededFood += (u.getMarchingUpkeep() * u.getCurrentSoldierCount());		
		}
		else {
			for(Unit u : units) 
				neededFood += (u.getSiegeUpkeep() * u.getCurrentSoldierCount());
		}
		return neededFood;
	}
	
	//Setters & Getters
	public Status getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}
	public ArrayList<Unit> getUnits() {
		return units;
	}
	public void setUnits(ArrayList<Unit> units) {
		this.units = units;
	}
	public int getDistancetoTarget() {
		return distancetoTarget;
	}
	public void setDistancetoTarget(int distancetoTarget) {
		this.distancetoTarget = distancetoTarget;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public int getMaxToHold() {
		return maxToHold;
	}
	
	
}

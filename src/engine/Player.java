package engine;

import java.util.ArrayList;

import buildings.*;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.Army;
import units.Status;
import units.Unit;

public class Player {
	private String name;
	private ArrayList<City> controlledCities;
	private ArrayList<Army> controlledArmies;
	private double treasury;
	private double food;

	public Player(String name) {
		this.name = name;
		this.controlledCities = new ArrayList<City>();
		this.controlledArmies = new ArrayList<Army>();
	}
	
	public void build(String type,String cityName) throws NotEnoughGoldException{
		City c = null;
		for(City c2 : this.controlledCities) {
			if (c2.getName().toLowerCase().equals(cityName.toLowerCase())) {
				c = c2;
			}
		}
		boolean flag = false;
		switch(type) {
		case "ArcheryRange": for (Building b : c.getMilitaryBuildings() ) {
						   	 	if ( b instanceof ArcheryRange) 
						   	 		flag = true;	
							 }
								if (!flag) {
									ArcheryRange A = new ArcheryRange();
							 		if (A.getCost() <this.treasury) {
							 			c.getMilitaryBuildings().add(A);
							 			this.treasury -= A.getCost();
							 			A.setCoolDown(false);
							 		}
							 		else
							 			throw new NotEnoughGoldException("You don't have enough gold to build this building.");
							 	}
								break;
								
								
		case "Barracks": for (Building b : c.getMilitaryBuildings() ) {
					   	 	if ( b instanceof Barracks) 
					   	 		flag = true;	
						 }
							if (!flag) {
								Barracks A = new Barracks();
						 		if (A.getCost() <this.treasury) {
						 			c.getMilitaryBuildings().add(A);
						 			this.treasury -= A.getCost();
						 			A.setCoolDown(false);
						 		}
						 		else
						 			throw new NotEnoughGoldException("You don't have enough gold to build this building.");
						 	}
							break;
		case "Stable":for (Building b : c.getMilitaryBuildings() ) {
				  	 		if ( b instanceof Stable) 
				   	 		flag = true;	
					 }
						if (!flag) {
							Stable A = new Stable();
					 		if (A.getCost() <this.treasury) {
					 			c.getMilitaryBuildings().add(A);
					 			this.treasury -= A.getCost();
					 			A.setCoolDown(false);
					 		}
					 		else
					 			throw new NotEnoughGoldException("You don't have enough gold to build this building.");
					 	}
						break;
		case "Farm":for (Building b : c.getEconomicalBuildings() ) {
				   	 	if ( b instanceof Farm) 
				   	 		flag = true;	
					 }
						if (!flag) {
							Farm A = new Farm();
					 		if (A.getCost() <this.treasury) {
					 			c.getEconomicalBuildings().add(A);
					 			this.treasury -= A.getCost();
					 			A.setCoolDown(false);
					 		}
					 		else
					 			throw new NotEnoughGoldException("You don't have enough gold to build this building.");
					 	}
						break;
			case "Market":	for (Building b : c.getEconomicalBuildings() ) {
						   	 	if ( b instanceof Market) 
						   	 		flag = true;	
							 }
								if (!flag) {
									Market A = new Market();
							 		if (A.getCost() <this.treasury) {
							 			c.getEconomicalBuildings().add(A);
							 			this.treasury -= A.getCost();
							 			A.setCoolDown(false);
							 		}
							 		else
							 			throw new NotEnoughGoldException("You don't have enough gold to build this building.");
							 	}
								break;
		}
	}
	
	public void initiateArmy(City city,Unit unit) {
		Army A = new Army(city.getName());
		A.getUnits().add(unit);
		city.getDefendingArmy().getUnits().remove(unit);
		unit.setParentArmy(A);
		this.controlledArmies.add(A);
	}
	
	public double getTreasury() {
		return treasury;
	}

	public void setTreasury(double treasury) {
		this.treasury = treasury;
	}

	public double getFood() {
		return food;
	}

	public void setFood(double food) {
		this.food = food;
	}

	public String getName() {
		return name;
	}

	public ArrayList<City> getControlledCities() {
		return controlledCities;
	}

	public ArrayList<Army> getControlledArmies() {
		return controlledArmies;
	}
	
	public void recruitUnit(String type,String cityName) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException{
		
		for(City x : this.getControlledCities()) {
			
			if(x.getName() == cityName) {
				
				switch(type) {
					
				case "Archer": for(MilitaryBuilding b : x.getMilitaryBuildings()) {
					
					if(b instanceof ArcheryRange) {
						
						if(b.isCoolDown())
							throw new BuildingInCoolDownException("Building is in cool down");
						if(  b.getCurrentRecruit()==b.getMaxRecruit())
							throw new MaxRecruitedException("Building has reached max recruited");
						if(b.getRecruitmentCost()>this.getTreasury())
							throw new NotEnoughGoldException("Not enough gold");
						
						Unit A =b.recruit();
						this.setTreasury(this.getTreasury()-b.getRecruitmentCost());
						x.getDefendingArmy().getUnits().add(A);
						break;
					}
					
				}
					break;
					
				case "Infantry": for(MilitaryBuilding b : x.getMilitaryBuildings()) {
					
					if(b instanceof Barracks) {
						
						if(b.isCoolDown())
							throw new BuildingInCoolDownException("Building is in cool down");
						if(  b.getCurrentRecruit()==b.getMaxRecruit())
							throw new MaxRecruitedException("Building has reached max recruited");
						if(b.getRecruitmentCost()>this.getTreasury())
							throw new NotEnoughGoldException("Not enough gold");
						
						Unit A =b.recruit();
						this.setTreasury(this.getTreasury()-b.getRecruitmentCost());
						x.getDefendingArmy().getUnits().add(A);
						break;
					}
					
				}
					break;
					
				case "Cavalry": for(MilitaryBuilding b : x.getMilitaryBuildings()) {
					
					if(b instanceof Stable) {
						
						if(b.isCoolDown())
							throw new BuildingInCoolDownException("Building is in cool down");
						if(  b.getCurrentRecruit()==b.getMaxRecruit())
							throw new MaxRecruitedException("Building has reached max recruited");
						if(b.getRecruitmentCost()>this.getTreasury())
							throw new NotEnoughGoldException("Not enough gold");
						
						Unit A =b.recruit();
						this.setTreasury(this.getTreasury()-b.getRecruitmentCost());
						x.getDefendingArmy().getUnits().add(A);
						break;
					}
				}
					break;
				}
				
				break;
				
				}
				
				
			}
		}
	
	public void upgradeBuilding(Building b) throws NotEnoughGoldException,BuildingInCoolDownException, MaxLevelException {
		
		if(this.getTreasury()<b.getUpgradeCost())
			throw new NotEnoughGoldException("Not enough gold");
		if(b.isCoolDown())
			throw new BuildingInCoolDownException("Building is in cool down");
		if(b.getLevel()==3)
			throw new MaxLevelException("Max level reached");
		b.upgrade();
		this.setTreasury((this.getTreasury()-b.getUpgradeCost()));
	}
	
	public void laySiege(Army army,City city) throws TargetNotReachedException,FriendlyCityException{
		
		if(army.getDistancetoTarget()>0)
			throw new TargetNotReachedException("Target not reached");
		for(City x :this.getControlledCities()) {
			if(x.equals(city))
				throw new FriendlyCityException("You can't lay siege on your own cities");
		}
		army.setCurrentStatus(Status.BESIEGING);
		city.setUnderSiege(true);
		city.setTurnsUnderSiege(0);
		
	}
	
		
		public static void main(String[]args) {
			City c = new City("Cairo");
			ArcheryRange a = new ArcheryRange();
			c.getMilitaryBuildings().add(a);
			Player ibra = new Player("Ibra");
			ibra.getControlledCities().add(c);
			ibra.setTreasury(90000.0);
			a.setCoolDown(false);
			try {
				try {
					ibra.upgradeBuilding(a);
					System.out.print(ibra.getTreasury());
				} catch (MaxLevelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (BuildingInCoolDownException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotEnoughGoldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


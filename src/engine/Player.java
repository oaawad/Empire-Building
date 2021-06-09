package engine;

import java.util.ArrayList;

import buildings.*;
import exceptions.NotEnoughGoldException;
import units.Army;
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
}

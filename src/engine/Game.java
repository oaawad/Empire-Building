package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import buildings.*;
import exceptions.FriendlyFireException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

public class Game {
	private Player player;
	private ArrayList<City> availableCities;
	private ArrayList<Distance> distances;
	private final int maxTurnCount = 30;
	private int currentTurnCount;
	
	//Constructor
	public Game(String playerName, String playerCity) throws IOException {

		player = new Player(playerName);
		availableCities = new ArrayList<City>();
		distances = new ArrayList<Distance>();
		currentTurnCount = 1;
		loadCitiesAndDistances();
		for (City c : availableCities) {
			if (c.getName().equals(playerCity))

				player.getControlledCities().add(c);

			else
				loadArmy(c.getName(), c.getName().toLowerCase() + "_army.csv");

		}
	}

	//Methods
	private void loadCitiesAndDistances() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("distances.csv"));
		String currentLine = br.readLine();
		ArrayList<String> names = new ArrayList<String>();

		while (currentLine != null) {

			String[] content = currentLine.split(",");
			if (!names.contains(content[0])) {
				availableCities.add(new City(content[0]));
				names.add(content[0]);
			} else if (!names.contains(content[1])) {
				availableCities.add(new City(content[1]));
				names.add(content[1]);
			}
			distances.add(new Distance(content[0], content[1], Integer.parseInt(content[2])));
			currentLine = br.readLine();

		}
		br.close();
	}
	public void loadArmy(String cityName, String path) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(path));
		String currentLine = br.readLine();
		Army resultArmy = new Army(cityName);
		while (currentLine != null) {
			String[] content = currentLine.split(",");
			String unitType = content[0].toLowerCase();
			int unitLevel = Integer.parseInt(content[1]);
			Unit u = null;
			if (unitType.equals("archer")) {

				if (unitLevel == 1)
					u = (new Archer(1, 60, 0.4, 0.5, 0.6));

				else if (unitLevel == 2)
					u = (new Archer(2, 60, 0.4, 0.5, 0.6));
				else
					u = (new Archer(3, 70, 0.5, 0.6, 0.7));
			} else if (unitType.equals("infantry")) {
				if (unitLevel == 1)
					u = (new Infantry(1, 50, 0.5, 0.6, 0.7));

				else if (unitLevel == 2)
					u = (new Infantry(2, 50, 0.5, 0.6, 0.7));
				else
					u = (new Infantry(3, 60, 0.6, 0.7, 0.8));
			} else if (unitType.equals("cavalry")) {
				if (unitLevel == 1)
					u = (new Cavalry(1, 40, 0.6, 0.7, 0.75));

				else if (unitLevel == 2)
					u = (new Cavalry(2, 40, 0.6, 0.7, 0.75));
				else
					u = (new Cavalry(3, 60, 0.7, 0.8, 0.9));
			}
			resultArmy.getUnits().add(u);
			currentLine = br.readLine();
		}
		br.close();
		
		for (City c : availableCities) {
			if (c.getName().toLowerCase().equals(cityName.toLowerCase())) {
				c.setDefendingArmy(resultArmy);
				for(Unit u :c.getDefendingArmy().getUnits())
					u.setParentArmy(c.getDefendingArmy());
			}	
		}			
	}
	public void endTurn() {
		this.currentTurnCount++;
		for (City c : player.getControlledCities()) {
			for(EconomicBuilding b : c.getEconomicalBuildings()) {
				b.setCoolDown(false);
				if (b instanceof Farm)
					player.setFood(player.getFood()+b.harvest());
				else 
					player.setTreasury(player.getTreasury()+b.harvest());
			}
			for(MilitaryBuilding b : c.getMilitaryBuildings()) {
				b.setCoolDown(false);
				b.setCurrentRecruit(0);
			}
		}
		for (Army a: player.getControlledArmies()) {
			
			if (player.getFood() > a.foodNeeded())
				player.setFood(player.getFood()-a.foodNeeded());
			else 
				player.setFood(0);
			
			
			if(player.getFood() == 0) {
				for (Unit u : a.getUnits()) {
					int reduced = u.getCurrentSoldierCount()/10;
					u.setCurrentSoldierCount(u.getCurrentSoldierCount()-reduced);
				}	
			}
			if(!a.getTarget().equals("")) {
				if (a.getDistancetoTarget() > 0)
					a.setDistancetoTarget(a.getDistancetoTarget()-1);
				if (a.getDistancetoTarget() == 0) {
					a.setCurrentLocation(a.getTarget());
					a.setCurrentStatus(Status.IDLE);
					a.setTarget("");
				}		
			}
		}
		for (City c : this.availableCities) {
			if (c.isUnderSiege()) {
				c.setTurnsUnderSiege(c.getTurnsUnderSiege()+1);
				for (Unit u : c.getDefendingArmy().getUnits()) {
					int reduced = u.getCurrentSoldierCount()/10;
					u.setCurrentSoldierCount(u.getCurrentSoldierCount()-reduced);
				}
			}
				
		}
	}
	public void occupy(Army a,String cityName) {
		for(City c: availableCities) {
			if (c.getName().equals(cityName)) {
				player.getControlledCities().add(c);
				for(Unit u : c.getDefendingArmy().getUnits()) 
					a.getUnits().add(u);
				c.setDefendingArmy(a);
				c.setUnderSiege(false);
				c.setTurnsUnderSiege(-1);
			}
		}		
	}
	public void autoResolve(Army attacker, Army defender) throws FriendlyFireException{
		for(City c : player.getControlledCities()) {
			if (defender.getCurrentLocation().equals(c.getName()))
				throw new FriendlyFireException("You cannot Attack this city.");
		}
		Boolean attackerTurn = true;
		while (!(attacker.getUnits().isEmpty() || defender.getUnits().isEmpty())) {
			Random randomNum = new Random();
			int index = randomNum.nextInt(attacker.getUnits().size());
			Unit a = attacker.getUnits().get(index);
			Random randomNum2 = new Random();
			int index2 = randomNum2.nextInt(defender.getUnits().size());
			Unit d = defender.getUnits().get(index2);
			if(attackerTurn) 
				a.attack(d);
			else
				d.attack(a);
			attackerTurn = !attackerTurn;
		}
		if (defender.getUnits().isEmpty())
			occupy(attacker, defender.getCurrentLocation());
		else
			player.getControlledArmies().remove(attacker);
			
	}
	public void targetCity(Army army, String targetName) {
		if(army.getCurrentStatus()==Status.MARCHING) {}
		else {
			for(Distance x:this.getDistances()) {
				if((army.getCurrentLocation()==x.getFrom()&&targetName==x.getTo())||(army.getCurrentLocation()==x.getTo()&& targetName==x.getFrom())) {
					army.setDistancetoTarget(x.getDistance());
					army.setTarget(targetName);
				}
			}
		}
			
	}
	
	public boolean isGameOver() {
		if (currentTurnCount == 31) 
			return true;
		boolean flag = false;
		for (City c : availableCities) {
			if (!player.getControlledCities().contains(c))
				flag = true;	
			}
		if (!flag)
			return true;
		return false;
	}
	
	
	// Setters & Getters
	public ArrayList<City> getAvailableCities() {
		return availableCities;
	}
	public ArrayList<Distance> getDistances() {
		return distances;
	}
	public int getCurrentTurnCount() {
		return currentTurnCount;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getMaxTurnCount() {
		return maxTurnCount;
	}
	public void setCurrentTurnCount(int currentTurnCount) {
		this.currentTurnCount = currentTurnCount;
	}

}

package engine;
import java.util.ArrayList;
import buildings.*;
import units.Army;

public class City {
    // A class representing a city.

    private String name; // The name of the city
    private ArrayList<EconomicBuilding> economicalBuildings; // : An ArrayList containing the economical buildings inside the city
    private ArrayList<MilitaryBuilding> militaryBuildings; // : An ArrayList containing the military buildings inside the city
    private Army defendingArmy = new Army(name); // The defending army of the city
    private int turnsUnderSiege; // Number of turns the city has been sieged
    private boolean underSiege = false; // checking if the city is under siege or not

    // Constructors  
    public City(String name){
        this.name = name;
    }

    // Setters & Getters 
    public String getName() {
        return this.name;
    }

    public ArrayList<EconomicBuilding> getEconomicalBuildings() {
        return this.economicalBuildings;
    }

    public ArrayList<MilitaryBuilding> getMilitaryBuildings() {
        return this.militaryBuildings;
    }
    
    public Army getDefendingArmy() {
        return this.defendingArmy;
    }

    public void setDefendingArmy(Army defendingArmy) {
        this.defendingArmy = defendingArmy;
    }

    public int getTurnsUnderSiege() {
        return this.turnsUnderSiege;
    }

    public void setTurnsUnderSiege(int turnsUnderSiege) {
        this.turnsUnderSiege = turnsUnderSiege;
    }

    public boolean isUnderSiege() {
        return this.underSiege;
    }

    public void setUnderSiege(boolean underSiege) {
        this.underSiege = underSiege;
    }

}

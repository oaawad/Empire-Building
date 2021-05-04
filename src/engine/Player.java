package engine;

import java.util.ArrayList;
import units.Army;

public class Player {
    // A class representing the game player 

    private String name; // The name of the player
    private ArrayList<City> controlledCities; // An ArrayList containing the player's controlled cities
    private ArrayList<Army> controlledArmies; // An ArrayList containing the player's controlled armies
    private double treasury; // The amount of gold the player has
    private double food; // The amount of food the player has
    
    // Constructors
    public Player(String name){
        this.name = name;
        this.controlledCities = new ArrayList<City>();
        this.controlledArmies = new ArrayList<Army>();
    }

    // Setters & Getters
    public String getName() {
        return this.name;
    }

    public ArrayList<City> getControlledCities() {
        return this.controlledCities;
    }

    public ArrayList<Army> getControlledArmies() {
        return this.controlledArmies;
    }

    public double getTreasury() {
        return this.treasury;
    }

    public void setTreasury(double treasury) {
        this.treasury = treasury;
    }

    public double getFood() {
        return this.food;
    }

    public void setFood(double food) {
        this.food = food;
    }
}

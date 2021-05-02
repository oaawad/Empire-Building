package units;

public abstract class Unit {
    // A class representing a unit
    
    private int level; // The current level of a unit
    private int maxSoldierCount; // The maximum number of soldiers a unit can hold.
    private int currentSoldierCount; // The current number of soldiers inside a unit.
    private double idleUpkeep; // The amount of food a unit will consume when being idle.
    private double marchingUpkeep; // The amount of food a unit will consume when marching to another city.
    private double siegeUpkeep; // The amount of food a unit will consume when laying siege

    // Constructors 
    public Unit(int level,int maxSoldierCount,double idleUpkeep, double marchingUpkeep,double siegeUpkeep){
        this.level = level;
        this.maxSoldierCount = maxSoldierCount; // el variable dah kan fe typo fel milestone description khly balk w enta b test.
        this.idleUpkeep = idleUpkeep;
        this.marchingUpkeep = marchingUpkeep;
        this.siegeUpkeep = siegeUpkeep;
    }

    // Setters & Getters 
    public int getLevel() {
        return this.level;
    }

    public int getMaxSoldierCount() {
        return this.maxSoldierCount;
    }

    public int getCurrentSoldierCount() {
        return this.currentSoldierCount;
    }

    public void setCurrentSoldierCount(int currentSoldierCount) {
        this.currentSoldierCount = currentSoldierCount;
    }

    public double getIdleUpkeep() {
        return this.idleUpkeep;
    }

    public double getMarchingUpkeep() {
        return this.marchingUpkeep;
    }

    public double getSiegeUpkeep() {
        return this.siegeUpkeep;
    }

}

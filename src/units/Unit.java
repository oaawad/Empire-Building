package units;

public class Unit {
    // A class representing a unit
    
    private int level; // The current level of a unit 
    private int maxSolidierCount; // The maximum number of soldiers a unit can hold.
    private int currentSoliderCount; // The current number of soldiersinside a unit.
    private double idleUpkeep; // The amount of food a unit will consume when being idle.
    private double marchingUpkeep; // The amount of food a unit will consume when marching to another city.
    private double siegeUpkeep; // The amount of food a unit will consume when laying siege

    public Unit(int level,int maxSolidierCount,double idleUpkeep, double marchingUpkeep,double siegeUpkeep){
        this.level = level;
        this.maxSolidierCount = maxSolidierCount; // el variable dah kan fe typo fel milestone description khly balk w enta b test.
        this.idleUpkeep = idleUpkeep;
        this.marchingUpkeep = marchingUpkeep;
        this.siegeUpkeep = siegeUpkeep;
    }

}

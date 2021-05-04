package units;

public class Infantry extends Unit {
    //  A subclass of Unit representing Infantries.

    public Infantry(int level, int maxSoldierCount, double idleUpkeep, double marchingUpkeep, double siegeUpkeep){
        super(level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
    }
}

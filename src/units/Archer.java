package units;

public class Archer extends Unit {
    //  A subclass of Unit representing Archers.

	public Archer(int level, int maxSoldierCount, double idleUpkeep, double marchingUpkeep, double siegeUpkeep){
        super(level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
    }
}

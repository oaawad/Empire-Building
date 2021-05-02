package units;

import java.util.ArrayList;

public class Army {
    // A class representing the player army.

    private Status currentStatus = Status.IDLE; // The current status of an army
    private ArrayList<Unit> units; // An ArrayList containing the units of the army.
    private int distancetoTarget = -1; // The distance needed to reach the target city.
    private String target = ""; // The target city
    private String currentLocation; // The current location of the army. The army can be either in a city or on road to another one.
    private final int maxToHold = 10; // The maximum number of units a unit can hold.
    
    // Construtors 
    public Army(String currentLocation){
        this.currentLocation = currentLocation;
        this.units = new ArrayList<>();
    }

    // Setters & getters
    public Status getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    public int getDistancetoTarget() {
        return this.distancetoTarget;
    }

    public void setDistancetoTarget(int distancetoTarget) {
        this.distancetoTarget = distancetoTarget;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getMaxToHold() {
        return maxToHold;
    }

}

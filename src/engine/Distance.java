package engine;

public class Distance {
    // A class representing the distance between two cities.
    private String from;
    private String to;
    private int dist; // naming the variable "distance" causes an error because it's the same of the class.

    // Constructors 
    public Distance(String from, String to, int dist){
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
    
    // Setters & Getters 
    public String getFrom() {
        return this.from;
    }
    
    public String getTo() {
        return this.to;
    }

    public int getDist() {
        return this.dist;
    }

}

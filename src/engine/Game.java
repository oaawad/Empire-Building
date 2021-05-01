package engine;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;


public class Game {
    // A class representing the game
    private Player player; // The current player of the game
    private ArrayList<City> availableCities; // An ArrayList containing the cities in the game
    private ArrayList<Distance> distances; // an Arraylist containing the distance between the cities
    private final int maxTurnCount = 30; // masimum number of turns in the Game
    private int currentTurnCount = 1; // Current numbe of turns

    // Constructors
    public Game(String playerName, String playerCity) throws IOException{
       this.player = new Player(playerName);
       
    }

    // Setters & Getters 
    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<City> getAvailableCities() {
        return this.availableCities;
    }

    public ArrayList<Distance> getDistances() {
        return this.distances;
    }

    public final int getMaxTurnCount() {
        return maxTurnCount;
    }

    public int getCurrentTurnCount() {
        return this.currentTurnCount;
    }

    public void setCurrentTurnCount(int currentTurnCount) {
        this.currentTurnCount = currentTurnCount;
    }
   

}

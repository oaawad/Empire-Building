package engine;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.swing.JPopupMenu.Separator;

import static org.junit.Assert.fail;

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
       this.player.getControlledCities().add(new City(playerCity));
       this.availableCities = new ArrayList<>();
       this.distances = new ArrayList<>();
       loadCitiesAndDistances();

    //   // intiallizing the defeanding armies  
    //   switch(playerCity){
    //        case Cairo:
    //            loadArmy(Roma);
    //            loadArmy(Sparta);
    //            break;
    //        
    //        case Roma:
    //            loadArmy(Cairo);
    //            loadArmy(Sparta);
    //            break;
    //    
    //        case Sparta:
    //            loadArmy(Cairo);
    //            loadArmy(Roma);
    //            break;
    //        default;    
    //   }
    }

    //public void loadArmy(String cityName,String path) throws IOException{
//
    //}
    private void loadCitiesAndDistances() throws IOException{
        String str = "";
        try (BufferedReader br = new BufferedReader(new FileReader("distances.csv"))) {
            while ((str = br.readLine()) != null) {
                String[] result = str.split(",");
                distances.add(new Distance(result[0], result[1], result[2]));
                    for(int i = 0; i < 2; i++){
                        boolean flag = false;
                        for(int j = 0; j < availableCities.size(); j++){
                            if(result[i] == availableCities.get(j).getName()){
                                flag = true;
                                break;
                            }       
                        }
                        if(!flag)
                            availableCities.add(new City(result[i]));
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
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
   
    public static void main(String[] args) throws IOException{
        Game g = new Game(omar, Cairo);
        System.out.println(g.availableCities.get(0).toString());
    }

}

package engine;

import java.io.IOException;
import java.util.ArrayList;

import units.*;

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

    //   Initializing the defending armies  
     
       switch(playerCity){
            case "Cairo":
                loadArmy("Roma","rome_army.csv");
                loadArmy("Sparta","sparta_army.csv");
                break;
            
            case "Roma":
                loadArmy("Cairo","cairo_army.csv");
                loadArmy("Sparta","sparta_army.csv");
                break;
        
            case "Sparta":
                loadArmy("Roma","rome_army.csv");
                loadArmy("Cairo","cairo_army.csv");
                break;
            default:
       }
    }

    public void loadArmy(String cityName,String path) throws IOException{
    	String str = "";
    	Army a = new Army(cityName);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((str = br.readLine()) != null) {
                String[] result = str.split(",");
                switch(result[0]) {
                	case "Archer":
                		switch(result[1]) {
                			case "1":
                				a.getUnits().add(new Archer(1,60,0.4,0.5,0.6));
                				break;
                			case "2":
                				a.getUnits().add(new Archer(2,60,0.4,0.5,0.6));
                				break;
                			case "3":
                				a.getUnits().add(new Archer(3,70,0.5,0.6,0.7));
                				break;	
                		}
                		break;
                	case "Infantry":
                		switch(result[1]) {
            			case "1":
            				a.getUnits().add(new Infantry(1,50,0.5,0.6,0.7));
            				break;
            			case "2":
            				a.getUnits().add(new Infantry(2,50,0.5,0.6,0.7));
            				break;
            			case "3":
            				a.getUnits().add(new Infantry(3,60,0.6,0.7,0.8));
            				break;	
                		}
            		
                		break;
                	case "Cavalry":
                		switch(result[1]) {
            			case "1":
            				a.getUnits().add(new Cavalry(1,40,0.6,0.7,0.75));
            				break;
            			case "2":
            				a.getUnits().add(new Cavalry(2,40,0.6,0.6,0.75));
            				break;
            			case "3":
            				a.getUnits().add(new Cavalry(3,60,0.7,0.8,0.9));
            				break;	
                		}
            		
                		break;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }    
    	
    	
    	
    }
    private void loadCitiesAndDistances() throws IOException{
        String str = "";
        try (BufferedReader br = new BufferedReader(new FileReader("distances.csv"))) {
            while ((str = br.readLine()) != null) {
                String[] result = str.split(",");
                distances.add(new Distance(result[0], result[1], Integer.parseInt(result[2])));
                    
                for(int i = 0; i < 2; i++){
                    boolean flag = false;
                    for(int j = 0; j < availableCities.size(); j++){
                        if(result[i].equals(availableCities.get(j).getName())){
                            flag = true;
                            break;
                        }       
                    }
                    if(!flag)
                        availableCities.add(new City(result[i]));
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
        Game g = new Game("omar", "Cairo");
        System.out.println(g.availableCities.size());
    }

}

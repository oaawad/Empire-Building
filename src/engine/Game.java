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
    private ArrayList<Distance> distances; // An ArrayList containing the distance between the cities
    private final int maxTurnCount = 30; // Maximum number of turns in the Game
    private int currentTurnCount = 1; // Current number of turns

    // Constructors
    public Game(String playerName, String playerCity) throws IOException{
       this.player = new Player(playerName);
       this.availableCities = new ArrayList<City>();
       this.distances = new ArrayList<Distance>();
       loadCitiesAndDistances();
       //Initializing the defending armies  
       for(int i = 0; i<availableCities.size(); i++) {
       		if(playerCity.equals(availableCities.get(i).getName())) {
       			availableCities.get(i).setDefendingArmy(null);
       			this.player.getControlledCities().add(availableCities.get(i));
       		}
       }
       switch(playerCity){
            case "Cairo":
                loadArmy("Rome","rome_army.csv");
                loadArmy("Sparta","sparta_army.csv");
                break;
            
            case "Rome":
                loadArmy("Cairo","cairo_army.csv");
                loadArmy("Sparta","sparta_army.csv");
                break;
        
            case "Sparta":
                loadArmy("Rome","rome_army.csv");
                loadArmy("Cairo","cairo_army.csv");
                break;
       }
    }

    //Methods
    public void loadArmy(String cityName,String path) throws IOException{
		String str = "";
		Army defendingArmy = new Army(cityName);
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		while ((str = br.readLine()) != null) {
            String[] result = str.split(","); 
            switch(result[0]) {
            	case "Archer":
            		switch(result[1]) {
            			case "1":
            				defendingArmy.getUnits().add(new Archer(1,60,0.4,0.5,0.6));
            				break;
            			case "2":
            				defendingArmy.getUnits().add(new Archer(2,60,0.4,0.5,0.6));
            				break;
            			case "3":
            				defendingArmy.getUnits().add(new Archer(3,70,0.5,0.6,0.7));
            				break;	
            		}
            		break;
            	case "Infantry":
            		switch(result[1]) {
        			case "1":
        				defendingArmy.getUnits().add(new Infantry(1,50,0.5,0.6,0.7));
        				break;
        			case "2":
        				defendingArmy.getUnits().add(new Infantry(2,50,0.5,0.6,0.7));
        				break;
        			case "3":
        				defendingArmy.getUnits().add(new Infantry(3,60,0.6,0.7,0.8));
        				break;	
            		}
        		
            		break;
            	case "Cavalry":
            		switch(result[1]) {
        			case "1":
        				defendingArmy.getUnits().add(new Cavalry(1,40,0.6,0.7,0.75));
        				break;
        			case "2":
        				defendingArmy.getUnits().add(new Cavalry(2,40,0.6,0.7,0.75));
        				break;
        			case "3":
        				defendingArmy.getUnits().add(new Cavalry(3,60,0.7,0.8,0.9));
        				break;	
            		}
        		
            		break;
            }}    	
		
        for(int i = 0 ; i<availableCities.size(); i++ ) {
        	if (cityName.equals(availableCities.get(i).getName()))
        		availableCities.get(i).setDefendingArmy(defendingArmy);
        }
    	br.close();	
    }
    
    public void loadCitiesAndDistances() throws IOException{
        String str = "";
        FileReader fileReader= new FileReader("distances.csv");
		BufferedReader br = new BufferedReader(fileReader);
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
     br.close();   
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

package elemnts;

import java.util.ArrayList;

public class AirSpace {
	
	public static final int XMAX = 10; // Delimitacio de l'espai aeri, espai real = 10^3
	public static final int YMAX = 10;
	public static final int MAXCAP = 5;
	
	int[][] zone = new int[XMAX][YMAX]; // ini constructor
	private ArrayList<Airplane> currentAirplanes = new ArrayList<Airplane>();
	
	
	
	
	
	
	public ArrayList<Airplane> getCurrentAirplanes() { //menu 4. Info?
		return currentAirplanes;
	}
	public void addAirplane(Airplane airplane) {
		this.currentAirplanes.add(airplane);
	}
	public void removeAirplane(int airplaneNumber) { 
		this.currentAirplanes.remove(airplaneNumber);
	}
	
	
	
	

}

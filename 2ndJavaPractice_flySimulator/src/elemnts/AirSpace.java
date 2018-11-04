package elemnts;

import java.util.ArrayList;

import utilities.InputListener;

public class AirSpace {
	
	public static final int XMAX = 10; // Delimitacio de l'espai aeri, espai real = 10^3
	public static final int YMAX = 10;
	public static final int MAXCAP = 5;
	
	int[][] zone;
	private Airplane[] currentAirplanes;
	
	public AirSpace() {
		zone = new int[XMAX][YMAX];
		currentAirplanes = new Airplane[MAXCAP];
	}

	
	
	
	
	public Airplane[] getCurrentAirplanes() {
		return currentAirplanes;
	}
	

	public void addAirplane(Airplane newairplane) {
		for(int i = 0; i < currentAirplanes.length; i++) {
			if(currentAirplanes[i] == null) currentAirplanes[i] = newairplane;
		}
	}
			
	public int getNumberOfExistingAirplanes() {
		
		int numberOfAirplanes = 0;
		
		for(int i = 0; i < currentAirplanes.length; i++) {		
			if(currentAirplanes[i] != null) {
				numberOfAirplanes++;
			}
		}
		return numberOfAirplanes;
	}
	
	public void airplaneActions(int airplaneNumber, String action) {
		
		switch(action) { 

        case "launchMotor":
        	currentAirplanes[airplaneNumber].turnOn_motor();
            break;
        case "stopMotor":
        	currentAirplanes[airplaneNumber].turnOff_motor();
            break;
        case "accelerate":
        	currentAirplanes[airplaneNumber].increaseSpeed(InputListener.inputInt());
            break;
        case "stop":
        	currentAirplanes[airplaneNumber].decreaseSpeed(InputListener.inputInt());
            break;
        case "increaseAltitude":
        	currentAirplanes[airplaneNumber].increaseAltitude(InputListener.inputInt());
            break;
        case "decreaseAltitude":
        	currentAirplanes[airplaneNumber].decreaseAltitude(InputListener.inputInt());
            break;
        case "landingGearOn_Off": 
        	
        	if(currentAirplanes[airplaneNumber].isLanding_gearOn()) 
        		System.out.println("El tren d'aterratge es troba actiu. Procendint a tancar");
        		else  
        			System.out.println("El tren d'aterratge es troba tancat. Procendint a desplegar");
        	
        	currentAirplanes[airplaneNumber].open_closeLandingGear();
        	
            break;
        case "newDirection":
        	// currentAirplanes[airplaneNumber].setDirection(newDirection);
            break;
        case "newX_Y":
        	System.out.println("Introdueix la posicio X");
        	currentAirplanes[airplaneNumber].setPositionX(InputListener.inputInt());
        	System.out.println("Introdueix la posicio Y");
        	currentAirplanes[airplaneNumber].setPositionY(InputListener.inputInt());
            break;
        case "park":
        	currentAirplanes[airplaneNumber].park();
            break;
        case "endOperations":
        	// airSpace. ??????
            break;
		}
		
	}

	
	
	
	
	

}

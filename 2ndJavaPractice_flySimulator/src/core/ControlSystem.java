package core;

import java.util.ArrayList;
import elemnts.AirSpace;
import elemnts.Airplane;
import utilities.InputListener;

public class ControlSystem {

	
	// AirSpace airSpace = new AirSpace();
	
	public static final int XMAX = 10; // Delimitacio de l'espai aeri, espai real = 10^3
	public static final int YMAX = 10;
	public static final int MAXCAP = 5;
	
	int[][] zone;
	private Airplane[] currentAirplanes;
	
	public ControlSystem(AirSpace space) {
		// airSpace = space;
		
	}
	
	public boolean minAltitude(int airplaneNumber) {
		Airplane test = currentAirplanes.getAirplane(airplaneNumber);
		test.getAltitude();
		return true;
	}


// New airplanes (menu option 1)
	
	public void AddNewAirplane() {
		
		if(getNumberOfExistingAirplanes() < MAXCAP) {
			
			String model = InputListener.inputString(),
				   manufacturer =  InputListener.inputString(),
				   numberPlate = InputListener.inputString();
			
			int maxCapacity = InputListener.inputInt(),
				x = InputListener.inputInt(),
				y = InputListener.inputInt();
			
			addAirplane(new Airplane(model, manufacturer, numberPlate, maxCapacity, x, y));
					
		} else {			
			System.out.println("L'espai aeri esta ple. Utilitza la opcio del menu 3 per realitzar un manteniment de l'espai aeri");
		}
	}
// Airplanes functions (menu option 2)
	
	public int checkNumberPlateMatches() {
		
		String numberPlate = InputListener.inputString();
		Airplane[] currentAirplanes = getCurrentAirplanes();
		int position = 0;
		
		for(Airplane airplane : currentAirplanes) {
			if(airplane!=null) {
				if(airplane.getNumberPlate().equals(numberPlate))
					return position;
			}	
		}
		return -1;
	}
	
	public boolean checkNameindevelopment(String airplaneNumber) { /// can an airplane do certains functions??
		
		
		
		return true;
	}
	
	public void mainAirplaneFunctions(int airplaneNumber) {
		
		if(airplaneNumber != -1) {
			
			String airplaneOption = InputListener.inputOfMenuOptionN2();
			
			airSpace.airplaneActions(airplaneNumber, airplaneOption);
			
		} else {
			System.out.println("Aquesta matriucla no es troba registrada entre els avions que hi han a pista");
		}
	}
	
	
	
	
	public void clean(int airplanePosition) {

		// zone.removeAirplane();
		// use iterator list
	}

	public void display() {
		airSpace.getCurrentAirplanes(); // more 
	}
	
	//AirSpace
		

	public Airplane[] getCurrentAirplanes() {
		return currentAirplanes;
	}
	public Airplane getAirplane(int number) {
		return currentAirplanes[number];
	}
	

	public void addAirplane(Airplane newairplane) {
		for(int i = 0; i < currentAirplanes.length; i++) {
			if(currentAirplanes[i] == null) currentAirplanes[i] = newairplane;
		}
	}
	
	//CHECKS
	public int getNumberOfExistingAirplanes() {
		
		int numberOfAirplanes = 0;
		
		for(int i = 0; i < currentAirplanes.length; i++) {		
			if(currentAirplanes[i] != null) {
				numberOfAirplanes++;
			}
		}
		return numberOfAirplanes;
	}
	
	public boolean checkFreePositionOnCreate(int newX, int newY) {
		for(Airplane airplane : currentAirplanes) {
			if(airplane!=null) {
				if(airplane.getPositionX() == newX && airplane.getPositionY() == newY )
					return false;
			}	
		}
		return true;
	}
	
	
	public boolean checkBeforeChangeAltitude(String action, int airplaneNumber, int inputNewAltitude) {
		
		int currentAltitude = currentAirplanes[airplaneNumber].getAltitude();
		
		if(action.equals("increase")) {
			int desiredAltitude = currentAltitude + inputNewAltitude;

				if(currentAltitude==0) {
					if(checkRequiredSpeedToTakeOff(airplaneNumber)==false) {
						return false;
					}
				} else {
					if(checkIfLandingGearHasToBeOpen(desiredAltitude)==false) {
						return false;
					}
				}
		}
				
		}else if(action.equals("decrease")) {
			
			int desiredAltitude = currentAltitude - inputNewAltitude;
			
		}
		return true;	
		}

			

	

	
	public boolean checkRequiredSpeedToTakeOff(int airplaneNumber ) {
		
	
		int currentSpeed = currentAirplanes[airplaneNumber].getSpeed();
		boolean takeoff;
			
			if(currentSpeed >= 180) {
				return true;
			} else {
				System.out.println("Has de tenir una velocitat minima de 180km/h per enlairarte");
				return false;
			}	
	}
	
	public boolean checkIfLandingGearHasToBeOpen(int desiredAltitude) {
		
		if(desiredAltitude>500) {
			System.out.println("Has de recollir el tren d'aterratge si vols enlairarte a mes de 500m d'altitud");
			return false;
		} else {
			return true;
		}
	}

	public boolean checkIfLandingGearHasToBeClosed(int desiredAltitude) {
		
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
        	if(checkBeforeChangeAltitude("increase", airplaneNumber, InputListener.inputInt()))
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
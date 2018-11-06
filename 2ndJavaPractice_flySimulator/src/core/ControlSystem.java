package core;

import java.util.ArrayList;
import elemnts.AirSpace;
import elemnts.Airplane;
import utilities.InputListener;

public class ControlSystem {

	
	AirSpace airSpace = new AirSpace();
	
	public ControlSystem(AirSpace space) {
		airSpace = space;
		
	}
	
	public boolean minAltitude(int airplaneNumber) {
		Airplane test = airSpace.getAirplane(airplaneNumber);
		test.getAltitude();
		return true;
	}


// New airplanes (menu option 1)
	
	public void AddNewAirplane() {
		
		if(airSpace.getNumberOfExistingAirplanes() < airSpace.MAXCAP) {
			
			String model = InputListener.inputString(),
				   manufacturer =  InputListener.inputString(),
				   numberPlate = InputListener.inputString();
			
			int maxCapacity = InputListener.inputInt(),
				x = InputListener.inputInt(),
				y = InputListener.inputInt();
			
			airSpace.addAirplane(new Airplane(model, manufacturer, numberPlate, maxCapacity, x, y));
					
		} else {			
			System.out.println("L'espai aeri esta ple. Utilitza la opcio del menu 3 per realitzar un manteniment de l'espai aeri");
		}
	}
// Airplanes functions (menu option 2)
	
	public int checkNumberPlateMatches() {
		
		String numberPlate = InputListener.inputString();
		Airplane[] currentAirplanes = airSpace.getCurrentAirplanes();
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
	


}
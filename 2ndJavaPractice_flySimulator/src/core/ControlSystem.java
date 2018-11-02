package core;

import elemnts.AirSpace;
import elemnts.Airplane;

public class ControlSystem {

	
	AirSpace airSpace = new AirSpace();
	
	public ControlSystem(AirSpace space) {
		airSpace = space;
		
	}


	
	public void newAirplane (String model, String manufacturer, String numberPlate,int MaxCapacity, int x, int y) {

		airSpace.addAirplane(new Airplane(model, manufacturer, numberPlate, MaxCapacity, x, y));

	}

	public void clean(int airplanePosition) {

		// zone.removeAirplane();
		// use iterator list
	}

	public void display() {
		airSpace.getCurrentAirplanes(); // more 
	}


}
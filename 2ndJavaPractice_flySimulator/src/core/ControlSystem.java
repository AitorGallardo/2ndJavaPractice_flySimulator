package core;

import elemnts.AirSpace;
import elemnts.Airplane;

public class ControlSystem {

	AirSpace zone = new AirSpace();


	public void newAirplane (String model, String manufacturer, String numberPlate,int MaxCapacity, int x, int y) {

		zone.addAirplane(new Airplane(model, manufacturer, numberPlate, MaxCapacity, x, y));

	}

	public void clean(int airplanePosition) {

		// zone.removeAirplane();

	}

	public void display() {

	}


}
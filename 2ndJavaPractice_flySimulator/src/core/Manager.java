package core;

import elemnts.AirSpace;
import utilities.InputListener;

public class Manager {
	
		ControlSystem controlSystem = new ControlSystem(new AirSpace());

		
		public void mainLoop() {
			
			boolean end = false;
			int menuOption;
			
			menuOption = InputListener.menuGeneralOptions(InputListener.inputInt());

			while(end==false) {


				switch(menuOption) { 

			        case 1:
			        	controlSystem.AddNewAirplane();
			            break;
			        case 2:
			        	controlSystem.mainAirplaneFunctions(controlSystem.lookForNumberPlateMatches());
			            break;
			        case 3:
			        	printer.printInitialMap(); //printer.printInitialMap();  When the game has been completed <------
			        	toPlay=true;
			            break;
			        case 4:
			        	printer.printInitialMap(); //printer.printInitialMap();  When the game has been completed <------
			        	toPlay=true;
			            break;
				}
			
		}
		

}
}

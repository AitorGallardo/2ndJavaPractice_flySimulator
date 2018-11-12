package core;

import elemnts.AirSpace;
import elemnts.Airplane;
import utilities.InputListener;

public class Manager {
	
		ControlSystem controlSystem = new ControlSystem();

		
		public void mainLoop() {
			
			boolean end = false;
			int menuOption;
			
			

			while(end==false) {
				
				System.out.println("Introdueix la opcio de menu");
				menuOption = InputListener.menuGeneralOptions(InputListener.inputInt());
				System.out.println("Has introduit "+menuOption);

				switch(menuOption) { 

			        case 1:
			        	controlSystem.AddNewAirplane(); //TENEMOS AVION 
			            break;
			        case 2:
			        	controlSystem.mainAirplaneFunctions(controlSystem.checkNumberPlateMatches(InputListener.inputStringExactLenght(Airplane.NUMBERPLATE_MAXLENGHT)));
			            break;
			        /*case 3:
			        	printer.printInitialMap(); //printer.printInitialMap();  When the game has been completed <------
			        	toPlay=true;
			            break;
			        case 4:
			        	printer.printInitialMap(); //printer.printInitialMap();  When the game has been completed <------
			        	toPlay=true;
			            break;*/
				}
				// end = true;
			
		}
		

}
}

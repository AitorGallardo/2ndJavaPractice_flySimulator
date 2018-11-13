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
			        	System.out.println("Introdueix la matricula de l'avio amb el que vols iniciar l'operativa");
			        	controlSystem.mainAirplaneFunctions(controlSystem.checkNumberPlateMatches(InputListener.inputStringExactLenght(Airplane.NUMBERPLATE_MAXLENGHT)));
			        	controlSystem.airSpaceMaintenance();
			        	System.out.println("MENU 4");
			        	controlSystem.checkDangers();
			        	// MENU 4
			            break;
			        case 3:
						controlSystem.airSpaceMaintenance();
			            break;
			        case 4:
						System.out.println("MENU 4");
						controlSystem.checkDangers();
			            break;
				}
				// end = true;
			}	
		}
}

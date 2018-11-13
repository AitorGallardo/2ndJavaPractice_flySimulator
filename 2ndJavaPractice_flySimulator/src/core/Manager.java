package core;

import elemnts.Airplane;
import utilities.InputListener;
import utilities.Printer;

public class Manager {
	
		ControlSystem controlSystem = new ControlSystem();

		
		public void mainLoop() {
			
			boolean end = false;
			int menuOption;
			
			

			while(end==false) {
				
				// System.out.println("Introdueix la opcio de menu");
				menuOption = InputListener.menuGeneralOptions(InputListener.inputInt());
				System.out.println("Has introduit "+menuOption);

				switch(menuOption) { 

			        case 1:
			        	Printer.menu1();
			        	controlSystem.AddNewAirplane(); //TENEMOS AVION 
			            break;
			        case 2:
			        	Printer.menu2();
			        	Printer.inputNumberPlateToStartOperative();
			        	controlSystem.mainAirplaneFunctions(controlSystem.checkNumberPlateMatches(InputListener.inputStringExactLenght(Airplane.NUMBERPLATE_MAXLENGHT)));
			        	controlSystem.airSpaceMaintenance();
			        	System.out.println("MENU 4");
			        	controlSystem.checkDangers();
			        	// MENU 4
			            break;
			        case 3:
			        	Printer.menu3();
						controlSystem.airSpaceMaintenance();
			            break;
			        case 4:
			        	Printer.menu4();
                        Printer.airplaneTable(controlSystem.copyOfCurrentAirplanes());
                        controlSystem.checkDangers();
                        break;
				}
				// end = true;
			}	
		}
}

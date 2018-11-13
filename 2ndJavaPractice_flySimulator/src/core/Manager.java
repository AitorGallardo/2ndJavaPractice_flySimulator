package core;

import elemnts.Airplane;
import utilities.InputListener;
import utilities.Printer;

public class Manager {
	
		ControlSystem controlSystem = new ControlSystem();

		
		public void mainLoop() {
			
			boolean end = false;
			int menuOption;
			
			
			Printer.generalOptions();
			while(end==false) {
				Printer.chooseMenuOption();
				menuOption = InputListener.menuGeneralOptions(InputListener.inputInt(4, "Escull una de les 4 opcions del menu"));
				System.out.print("Has escollit la ");

				switch(menuOption) { 

			        case 1:
			        	Printer.menu1();
			        	controlSystem.AddNewAirplane(); //TENEMOS AVION 
			            break;
			        case 2:
			        	Printer.menu2();
			        	Printer.inputNumberPlateToStartOperative();
			        	controlSystem.mainAirplaneFunctions(controlSystem.checkNumberPlateMatches(InputListener.inputStringExactLenght(Airplane.NUMBERPLATE_MAXLENGHT)));
			        	Printer.menu3();
			        	controlSystem.airSpaceMaintenance();
			        	Printer.menu4();
                        Printer.airplaneTable(controlSystem.copyOfCurrentAirplanes());
                        controlSystem.checkDangers();
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

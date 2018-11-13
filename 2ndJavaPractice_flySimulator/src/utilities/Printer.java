package utilities;

import elemnts.Airplane;

public final class Printer {
	
	private Printer() {}

	// Menu options
	
	public static void generalOptions() {
		System.out.println("Opcions principals\n\n"
				+ "Opcio 1 del menu: -Afegir avions-\n"
				+ "Opcio 2 del menu: -Operativa amb avions-\n"
				+ "Opcio 3 del menu: -Manteniment de l'espai aeri-\n"
				+ "Opcio 4 del menu: -Informacio de l'espai aeri-");
	}
	public static void chooseMenuOption() {
		System.out.println("\nEscull una opcio");
	}
	
	
	// Inputs

	public static void inputMenuOption() {
		System.out.println("Introdueix la opcio de menu");
	}
	public static void inputNumberPlateToStartOperative() {
		System.out.println("Introdueix la matricula de l'avio amb el que vols iniciar l'operativa");
	}		
	public static void inputNumberPlate() {
		System.out.println("Introdueix matricula");
	}
	public static void inputModel() {
		System.out.println("Introdueix model");
	}
	public static void inputManufacturer() {
		System.out.println("Introdueix fabricant");
	}
	public static void inputCapacity() {
		System.out.println("Introdueix la capacitat maxima");
	}
	public static void inputX() {
		System.out.println("Introdueix posicio x");
	}
	public static void inputY() {
		System.out.println("Introdueix posicio y");
	}
	public static void inputIncreaseSpeed() {
		System.out.println("Introdueix quants k/h vols augmentar la velocitat");
	}
	public static void inputDeccreaseSpeed() {
		System.out.println("Introdueix quants k/h vols reduir la velocitat");
	}	
	public static void inputIncreaseAltitude() {
		System.out.println("Introdueix quants metres vols agumentar l' altitud");
	}	
	public static void inputDecreaseAltitude() {
		System.out.println("Introdueix quants metres vols reduir l' altitud");
	}	
	public static void inputLandingGeaR() {
		System.out.println("/////////////////");
	}	
	public static void inputDirection() {
		System.out.println("Introdueix la nova direccio, rang de 0 a 360 graus");
	}	


	// Actions

	public static void menu1() {
		System.out.println("opcio 1 del menu: -Afegir avions-\n");
	}	
	public static void menu2() {
		System.out.println("opcio 2 del menu: -Operativa amb avions-\n");
	}
	public static void menu3() {
		System.out.println("opcio 3 del menu: -Manteniment de l'espai aeri-\n");
	}
	public static void menu4() {
		System.out.println("opcio 4 del menu: -Informacio de l'espai aeri-\n");
	}		
	public static void turningOnMotor() {
		System.out.println("Has escollit encendre el motor de l'avio");
	}
	public static void turningOffMotor() {
		System.out.println("Has escollit apagar el motor de l'avio");
	}
	public static void increasingSpeed() {
		System.out.println("Has escollit augmentar la velocitat l'avio");
	}
	public static void motorStateOn(String state) {
		System.out.println("Motor"+state+"ences");
	}
	public static void motorStateOff(String state) {
		System.out.println("Motor"+state+"apagat");
	}
	public static void decreasingSpeed() {
		System.out.println("Has escollit reduir la velocitat l'avio");
	}
	public static void landingGearAction(String action) {
		System.out.println("Has "+action+" el tren d'aterratge");
	}
	public static void increasingAltitude() {
		System.out.println("Has escollit incrementar l'altitud de l'avio");
	}
	public static void decreasingAltitude() {
		System.out.println("Has escollit reduir l'altitud de l'avio");
	}
	public static void changingDirection() {
		System.out.println("Has escollit canviar la direccio l'avio");
	}
	public static void changingPosition() {
		System.out.println("Has escollit canviar la posicio de l'avio");
	}
	public static void parkig() {
		System.out.println("Has escollit aparcar l'avio");
	}
	public static void onParkig() {
		System.out.println("Es procedeix a aparcar l'avio");
	}	
	public static void finishingOperative() {
		System.out.println("Has finalitzat l'operativa de l'avio");
	}
	public static void newAirplaneCreated() {
		System.out.println("Has creat un nou avio");
	}


	// Alerts

	public static void numberPlateAlreadyRegistered() {
		System.out.println("Aquesta matricula ja es troba registrada");
	}
	public static void fullAirspace() {
		System.out.println("L'espai aeri esta ple. Utilitza la opcio del menu 3 per realitzar un manteniment de l'espai aeri");
	}
	public static void OccupedPosition() {
		System.out.println("En aquesta posicio ja es troba un avio");
	}
	public static void voidAirspace() {
		System.out.println("L'espair aeri es troba buit");
	}
	public static void freeNumberPlate() {
		System.out.println("Matricula no registrada");
	}
	public static void acceptedNumberPlate() {
		System.out.println("Matricula registrada");
	}
	public static void deletedAirplane(String numberPlate) {
		System.out.println("L' avio amb matricula "+numberPlate+" s'ha eliminat");
	}
	public static void untouchedAirspace() {
		System.out.println("No s'ha efectuat cap canvi a l'espai aeri");
	}					
	public static void crashRisk(String numberPlate1, String numberPlate2) {
		System.out.println("Els avions amb matricula "+numberPlate1+ " i " +numberPlate2+" estan en risc de colisio!!");
	}
	public static void dangerMotorOff() {
		System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
	}	
	public static void miniumSpeedToPark() {
		System.out.println("La velocitat ha de ser inferior a 20km/h per aparcar");
	}
	public static void landedToPark() {
		System.out.println("L'avio ha de estar aterrat per poder aparcar");
	}			
	public static void alreadyParked() {
		System.out.println("L'avio ja esta aparcat");
	}
	public static void miniumSpeedToFly() {
		System.out.println("Has de tenir una velocitat minima de 180km/h per enlairarte");
	}
	public static void landingGearOffToFly() {
		System.out.println("Has de recollir el tren d'aterratge si vols enlairarte a mes de 500m d'altitud");
	}
	public static void landingGearOnTOFly() {
		System.out.println("Hauras de reduir la teva altitud i o velocitat per poder desplegar el tren d'aterratge");
	}			
	public static void incAltitudToLandingGear() {
		System.out.println("Hauras d'augmentar la teva altitud per poder tancar el tren d'aterratge");
	}
	public static void alreadyLanded() {
		System.out.println("Estas a terra, no pots descendir");
	}
	public static void landingGearToLand() {
		System.out.println("Has de desplegar el tren d'aterratge per poder aterrar");
	}
	public static void crashAltitude() {
		System.out.println("No pots descendir aquesta altura o colisionaras contra el terre");
	}
	public static void landingGearToDesc() {
		System.out.println("Has de desplagar el tren d'aterratge si vols descendir a una altitud inferior als 100 metres");
	}
	public static void cantCloseLandingGearLanded() {
		System.out.println("No pots recollir el tren d'aterratge si estas aterrat");
	}
	public static void maxSpeed() {
		System.out.println("La velocitat maxima de l'avio no pot superar els 2000km/h");
	}
	public static void minSpeed() {
		System.out.println("La velocitat minima de l'avio no pot ser inferior a 0");
	}
	

	// tableInfo
    public static void airplaneTable(Airplane[] currentAirplanes) {
        
        String[] parameters = {"Marca: ","Model: ","Matricula: ","X: ","Y: ","Alcada: ","Velocitat: ","Tren Aterratge: ","Motor: ","Aparcat: "};
        
        System.out.printf("%n%-17s %-17s %-17s %-17s %-17s %-17s %n", "", "Aeronau 1", "Aeronau 2", "Aeronau 3", "Aeronau 4", "Aeronau 5");
        System.out.printf("%-17s %-85s %n", "", "----------------------------------------------------------------------------------");
        System.out.println();
        for(int position = 0; position < 10; position++) {
            System.out.printf("%-18s", parameters[position]);
            for(Airplane airplane : currentAirplanes) {
                System.out.printf("%-18s", airplane.valueToPrint(position));
            }
            System.out.println();
        }
        System.out.println();
    }
}

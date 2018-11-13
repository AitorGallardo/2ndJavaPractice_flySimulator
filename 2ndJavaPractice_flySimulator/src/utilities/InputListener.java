package utilities;

import java.util.Scanner;

public final class InputListener {
	
	//Airplane actions
	private static final String[] menuOptionN2 = {"a","b","c","d","e","f","g","h","i","j","k"};
	
	private static final String  launchMotor = "launchMotor",
								stopMotor = "stopMotor",
								accelerate = "accelerate",
								stop = "stop",
								increaseAltitude = "increaseAltitude",
								decreaseAltitude = "decreaseAltitude",
								landingGearOn_Off = "landingGearOn_Off",
								newDirection = "newDirection",
								newX_Y = "newX_Y",
								park = "park",
								endOperations = "endOperations";
	
	private static final String[] menuOptionN2Print = { "a = Encendre motor",
														"b = Parar motor",
														"c = Augmentar velocitat",
														"d = Disminuir velocitat",
														"e = Incrementar altitud",
														"f = Disminuir altitud",
														"g = Obrir/tancar tren d'aterratge",
														"h = Nova direccio",
														"i = Nova posicio X i Y",
														"j = Aparcar",
														"k = Acabar operativa de l'avio" };
					
	
	public static int inputInt(){
		int defaultValue = 9999;
		return inputInt(defaultValue);	
	}
	
	public static int inputInt(int controlValue){
		
		Scanner log = new Scanner(System.in);
		int input = 0;
		boolean validation = false;
		
		while(validation==false) {
			while (!log.hasNextInt()){
				log.next();
				System.out.print("Input no valid. Introdueix un número"); //MIRAR CLASSE STATICA
		
			}
			input=log.nextInt();
			if(input >= 0 && input <= controlValue) {
				validation = true;	
			}
		}
		log.nextLine();
		return input;
	}
	
	public static int inputInt(int controlValue, String[] rules){
		
		Scanner log = new Scanner(System.in);
		int input = 0;
		boolean validation = false;
		
		while(validation==false) {
			while (!log.hasNextInt()){
				log.next();
				System.out.print("Input no valid. Introdueix un número"); //MIRAR CLASSE STATICA
		
			}
			input=log.nextInt();
			if(input >= 0 && input <= controlValue) {
				validation = true;	
			}
			else {
				System.out.println("\n");
				for(String rule : rules) {
					
					System.out.println(rule);
				}
			}
		}
		log.nextLine();
		return input;
	}
	
	public static int inputInt(int controlValue, String missatge){
		
		Scanner log = new Scanner(System.in);
		int input = 0;
		boolean validation = false;
		
		while(validation==false) {
			while (!log.hasNextInt()){
				log.next();
				System.out.print("Input no valid. Introdueix un número"); //MIRAR CLASSE STATICA
		
			}
			input=log.nextInt();
			if(input >= 0 && input <= controlValue) {
				validation = true;	
			}
			else {
				System.out.println("\n"+missatge);
			}
		}
		log.nextLine();
		return input;
	}
	
	public static String inputString() {
		int defaultValue = 9999;
		return inputString(defaultValue);
	}
	
	public static String inputString(int controlValue) {
		
		String input = "";
		boolean validation = false;
		
		Scanner log = new Scanner(System.in);
		
		while(validation==false) {
			input = log.nextLine();
			
			if(input.length() <= controlValue)
				validation = true;
				else
					System.out.println("No pots introduir mes de  "+controlValue+" caracters");
		}
		return input.toLowerCase();	
	}
	
	public static String inputString(int controlValue, String[] rules) {
		
		String input = "";
		boolean validation = false;
		
		Scanner log = new Scanner(System.in);
		
		while(validation==false) {
			input = log.nextLine();
			
			if(input.length() <= controlValue)
				validation = true;
				else {
					System.out.println("\n");
					for(String rule : rules) {
						
						System.out.println(rule);
					}
				}
		}
		return input.toLowerCase();	
	}
	
	public static String inputStringExactLenght(int controlValue, String[] rules) {
		
		String input = "";
		boolean validation = false;
		
		Scanner log = new Scanner(System.in);
		
		while(validation==false) {
			input = log.nextLine();
			
			if(input.length() == controlValue) 
				validation = true;
			else {
				System.out.println("\n");
				for(String rule : rules) {
					
					System.out.println(rule);
				}
			}
		}
		return input.toLowerCase();	
	}
	
	public static String inputStringExactLenght(int controlValue) {
		
		String input = "";
		boolean validation = false;
		
		Scanner log = new Scanner(System.in);
		
		while(validation==false) {
			input = log.nextLine();
			
			if(input.length() == controlValue) 
				validation = true;
				else
					System.out.println("Has d'introduir "+controlValue+" caracters");
		}
		return input.toLowerCase();	
	}
	
	public static int menuGeneralOptions(int inputNumber) {
		
		int menuOption = -1;
		
		while(inputNumber < 1 && inputNumber > 4) {
			
			System.out.print("Escull una opció del menu"); //MIRAR CLASSE STATICA
		}
		
		menuOption = inputNumber;
		
		return menuOption;
	}
	
	 public static String inputOfMenuOptionN2() {
	     
		 boolean out = false;
		 String airplaneAction = "";
	     char command = 0;
	     Scanner log = new Scanner(System.in);
	     System.out.println("\n\n----> ESCULL UNA ACCIO");

	     while(out==false){
	    	 
	 		System.out.println("\n");
			for(String menu: menuOptionN2Print) {
				System.out.println(menu);
			}
	    	 command=log.next().charAt(0);

		     for(int i =0 ; i < menuOptionN2.length; i++){
		    	 
		     		if(menuOptionN2[i].charAt(0) == Character.toLowerCase(command)){ // keys[i].equals(command)
		     			
		     			out=true;
		     			
		     			if(i==0) airplaneAction = launchMotor;
		    			
		     			if(i==1) airplaneAction = stopMotor;

		     			if(i==2) airplaneAction = accelerate;
		     			
		     			if(i==3) airplaneAction = stop;

		     			if(i==4) airplaneAction = increaseAltitude;

		     			if(i==5) airplaneAction = decreaseAltitude;

		     			if(i==6) airplaneAction = landingGearOn_Off;

		     			if(i==7) airplaneAction = newDirection;

		     			if(i==8) airplaneAction = newX_Y;

		     			if(i==9) airplaneAction = park;

		     			if(i==10) airplaneAction = endOperations;
		     			
		     		}

		     }
		}
		return airplaneAction;
	}
}

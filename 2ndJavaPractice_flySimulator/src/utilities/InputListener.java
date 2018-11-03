package utilities;

import java.util.Scanner;

public final class InputListener {
	
	//Airplane actions
	private static final String[] menuOptionN2 = {"a","b","c","d","e","f","g","h","i","j","k"};
	
	private static final String  launchMotor = "launchMotor",
								stopMotor = "stopMotor",
								accelerate = "accelerate",
								stop = "stop",
								increaseAltitude = "+increaseAltitude",
								decreaseAltitude = "decreaseAltitude",
								landingGearOn_Off = "landingGearOn_Off",
								newDirection = "newDirection",
								newX_Y = "newX_Y",
								park = "park",
								endOperations = "endOperations";
					
	
	
	public static int inputInt(){
		
		Scanner log = new Scanner(System.in);
		int input = 0;

		while (!log.hasNextInt()){
				log.next();
				System.out.print("Input no valid. Introdueix un número"); //MIRAR CLASSE STATICA
		}
		input=log.nextInt();
		log.nextLine();
		return input;
	}
	
	public static String inputString() {
		
		String input = "";
		Scanner log = new Scanner(System.in);
		
		input = log.nextLine();
		
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

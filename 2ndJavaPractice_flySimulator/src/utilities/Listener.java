package utilities;

import java.util.Scanner;

public class Listener {
	
	//Airplane actions
	String[] menuOptionN2 = {"a","A","b","B","c","C","d","D","e","E","f","F","g","G","h","H","i","I","j","J","k","K"};
	
	private String  launchMotor = "launchMotor",
					stopMotor = "stopMotor",
					accelerate = "accelerate",
					stop = "stop",
					increaseAltitude = "+increaseAltitude",
					decreaseAltitude = "decreaseAltitude",
					landingGearOn = "landingGearOn",
					landingGearOff = "landingGearOff",
					newDirection = "newDirection",
					newX = "newX",
					newY = "newY",
					park = "park",
					endOperations = "endOperations";
					
	
	
	public int inputInt(){
		
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
	
	public String inputString() {
		
		String input = "";
		Scanner log = new Scanner(System.in);
		
		input = log.nextLine();
		
		return input;	
	}
	
	public int menuGeneralOptions(int inputNumber) {
		
		int menuOption = -1;
		
		while(inputNumber < 1 && inputNumber > 4) {
			
			System.out.print("Escull una opció del menu"); //MIRAR CLASSE STATICA
		}
		
		menuOption = inputNumber;
		
		return menuOption;
	}
	
	 public String inputOfMenuOptionN2() {
	     
		 boolean out = false;
		 String airplaneAction = "";
	     char command = 0;
	     Scanner log = new Scanner(System.in);
	     System.out.println("\n\n----> ESCULL UNA ACCIO");
	     while(out==false){
	    	 command=log.next().charAt(0);
	     	 // System.out.println(command);
		     for(int i =0 ; i < menuOptionN2.length; i++){
		     		if(menuOptionN2[i].charAt(0)==command){// keys[i].equals(command)
		     			out=true;
		     			if((i>=0) && (i<=1)) {
		     				airplaneAction = launchMotor;
		     			}
		     			if((i>=2) && (i<=3)) {
		     				airplaneAction = stopMotor;
		     			}
		     			if((i>=4) && (i<=5)) {
		     				airplaneAction = accelerate;
		     			}
		     			if((i>=6) && (i<=7)) {
		     				airplaneAction = stop;
		     			}
		     			if((i>=8) && (i<=9)) {
		     				airplaneAction = increaseAltitude;
		     			}
		     			if((i>=10) && (i<=11)) {
		     				airplaneAction = decreaseAltitude;
		     			}
		     			if((i>=12) && (i<=13)) {
		     				airplaneAction = landingGearOn;
		     			}
		     			if((i>=14) && (i<=15)) {
		     				airplaneAction = landingGearOff;
		     			}
		     			if((i>=16) && (i<=17)) {
		     				airplaneAction = newDirection;
		     			}
		     			if((i>=18) && (i<=19)) {
		     				airplaneAction = newX;
		     			}
		     			if((i>=20) && (i<=21)) {
		     				airplaneAction = newY;
		     			}
		     			if((i>=22) && (i<=23)) {
		     				airplaneAction = park;
		     			}
		     			if((i>=24) && (i<=25)) {
		     				airplaneAction = endOperations;
		     			}
		     		}
		     	}
		}
		return airplaneAction;
	}
}

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
					
	
	
	 public String inputOfMenuOptionN2() {
	     
		 boolean out = false;
		 String keyWord = "";
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
		     				keyWord = launchMotor;
		     			}
		     			if((i>=2) && (i<=3)) {
		     				keyWord = stopMotor;
		     			}
		     			if((i>=4) && (i<=5)) {
		     				keyWord = accelerate;
		     			}
		     			if((i>=6) && (i<=7)) {
		     				keyWord = stop;
		     			}
		     			if((i>=8) && (i<=9)) {
		     				keyWord = increaseAltitude;
		     			}
		     			if((i>=10) && (i<=11)) {
		     				keyWord = decreaseAltitude;
		     			}
		     			if((i>=12) && (i<=13)) {
		     				keyWord = landingGearOn;
		     			}
		     			if((i>=14) && (i<=15)) {
		     				keyWord = landingGearOff;
		     			}
		     			if((i>=16) && (i<=17)) {
		     				keyWord = newDirection;
		     			}
		     			if((i>=18) && (i<=19)) {
		     				keyWord = newX;
		     			}
		     			if((i>=20) && (i<=21)) {
		     				keyWord = newY;
		     			}
		     			if((i>=22) && (i<=23)) {
		     				keyWord = park;
		     			}
		     			if((i>=24) && (i<=25)) {
		     				keyWord = endOperations;
		     			}
		     		}
		     	}
		}
		return keyWord;
	}
}

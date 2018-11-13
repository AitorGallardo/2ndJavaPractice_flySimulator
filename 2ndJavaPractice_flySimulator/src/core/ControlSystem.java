        

package core;

import java.util.ArrayList;
import elemnts.Airplane;
import utilities.InputListener;
import utilities.Printer;

public class ControlSystem {

    
    // AirSpace airSpace = new AirSpace();
    
    public static final int XMAX = 1000, YMAX = 1000, MAXCAP = 5; // Delimitacio de l'espai aeri, espai real = 10^3

    
    int[][] zone;
    private Airplane[] currentAirplanes;
    
    public ControlSystem() {
    	this.currentAirplanes = new Airplane[5];
    }
    
    //// CHECKS PARA QUE NO SE PASEN DE LOS RANGOS DEL MAPA, 



    


// New airplanes (menu option 1)
    
    public void AddNewAirplane() {

        boolean freeXYPosition = false;
        int x = 0, y = 0;
        
        if(getAmountOfCurrentAirplanes() < MAXCAP) {
        	Printer.inputNumberPlate();
            String numberPlate = InputListener.inputStringExactLenght(Airplane.NUMBERPLATE_MAXLENGHT);
            
            if(checkNumberPlateMatches(numberPlate) == -1){
            	Printer.inputModel();
                String model = InputListener.inputString(Airplane.MODEL_MAXLENGHT);
                Printer.inputManufacturer();
                String manufacturer =  InputListener.inputString(Airplane.MANUFACTURER_MAXLENGHT);
                	
             Printer.inputCapacity();
                int maxCapacity = InputListener.inputInt();
                while(freeXYPosition == false){
                	Printer.inputX();
                     	x = InputListener.inputInt(XMAX);
                     	System.out.println("x: "+x);
                     	Printer.inputY();
                        y = InputListener.inputInt(YMAX);
                        System.out.println("y: "+y);
                      freeXYPosition = checkFreePositionOnCreate(x, y);
                }
                addAirplane(new Airplane(model, manufacturer, numberPlate, maxCapacity, x, y));
                Printer.newAirplaneCreated();

            } else {
            	Printer.numberPlateAlreadyRegistered();
            }

                    
        } else {            
            Printer.fullAirspace();
        }
    }
    
    public void addAirplane(Airplane newairplane) {
        for(int i = 0; i < currentAirplanes.length; i++) {
            if(currentAirplanes[i] == null) {
            	currentAirplanes[i] = newairplane;
            	return;
            }
            
        }
    }
    
    //CHECKS
    public int getAmountOfCurrentAirplanes() {
        
        int numberOfAirplanes = 0;
        
        for(int i = 0; i < currentAirplanes.length; i++) {      
            if(currentAirplanes[i] != null) {
                numberOfAirplanes++;
            }
        }
        return numberOfAirplanes;
    }
    
    public boolean checkFreePositionOnCreate(int newX, int newY) {
        for(Airplane airplane : currentAirplanes) {
            if(airplane!=null) {
                if(airplane.getPositionX() == newX && airplane.getPositionY() == newY ) {
                    Printer.OccupedPosition();
                    return false;
                }
            }   
        }
        return true;
    }
// Airplanes functions (menu option 2)
    
    public int checkNumberPlateMatches(String numberPlate) {

        int position = 0;
        
        
        for(Airplane airplane : currentAirplanes) {
            if(airplane!=null) {
                if(airplane.getNumberPlate().equals(numberPlate))
                    return position;
            } 
            position++;  
        }
        
        return -1;
    }
    
    public void mainAirplaneFunctions(int airplaneNumber) {
        
        if(airplaneNumber != -1 && getAmountOfCurrentAirplanes() > 0) {
            
            String airplaneOption = InputListener.inputOfMenuOptionN2();
            System.out.println("Escull quina accio vols realitzi l'avio"); // FALTA
            airplaneActions(airplaneNumber, airplaneOption);
            
        } else if(getAmountOfCurrentAirplanes() == 0) {
        	Printer.voidAirspace();
        } else {
        	Printer.freeNumberPlate();
        }
    }
    
    
    
    
    public void clean(int airplanePosition) {

        // zone.removeAirplane();
        // use iterator list
    }

    public void display() {
        // airSpace.getCurrentAirplanes(); // more 
    }
    
    //AirSpace
        

    public void airSpaceMaintenance() {
        
        int position = 0;

        for(Airplane airplane : currentAirplanes) {
        	if(airplane != null) {
                if(!airplane.isActive()) {
                    Printer.deletedAirplane(airplane.getNumberPlate());
                    currentAirplanes[position]= null;
                }
                else if(airplane.getPositionX()>XMAX || airplane.getPositionY()>YMAX 
                        || airplane.getPositionX()<0 || airplane.getPositionY()<0) {
                	Printer.deletedAirplane(airplane.getNumberPlate());
                    currentAirplanes[position]= null;
                }
        	}
            position++;   
        }
    }

    public Airplane[] copyOfCurrentAirplanes() { // Gives a copy of the airplanes with the exact number of positions

        int airplanesAmount = getAmountOfCurrentAirplanes();
        Airplane[] currentAirplanesCopy = new Airplane[airplanesAmount];
        int copyPosition = 0;


        for(int position = 0 ; position < currentAirplanes.length; position++) {
            if(currentAirplanes[position] != null) {
                currentAirplanesCopy[copyPosition] = currentAirplanes[position];
                copyPosition++;
            }
        }
        return currentAirplanesCopy; 
    }

    public void checkDangers() {

        int comparedAirplane = 0;
        int checkingAirplane = 0;
        int airplanesAmount = copyOfCurrentAirplanes().length;
        Airplane[] currentAirplanesCopy = copyOfCurrentAirplanes();
        
        if(airplanesAmount > 1) {
            while(checkingAirplane < airplanesAmount){
            	String checkingNumberPlate = currentAirplanesCopy[checkingAirplane].getNumberPlate(); 
                int checkingX = currentAirplanesCopy[checkingAirplane].getPositionX(),
                    checkingY = currentAirplanesCopy[checkingAirplane].getPositionY(),
                    checkingAltitude = currentAirplanesCopy[checkingAirplane].getAltitude();
                comparedAirplane = checkingAirplane+1;
                while(comparedAirplane < airplanesAmount) {
                	String numberPlate = currentAirplanesCopy[comparedAirplane].getNumberPlate(); 
                    int x =  Math.abs(checkingX - currentAirplanesCopy[comparedAirplane].getPositionX());
                    int y =  Math.abs(checkingY - currentAirplanesCopy[comparedAirplane].getPositionY());
                    int altitude = Math.abs(checkingAltitude - currentAirplanesCopy[comparedAirplane].getAltitude());
                    if((x<50 && y<50) && altitude < 500) {       
                        Printer.crashRisk(checkingNumberPlate, numberPlate);
                    }
                    comparedAirplane++;
                }
                checkingAirplane++;
            }
        }

        
    }
    


    

    public void airplaneActions(int airplaneNumber, String action) {

    	boolean endOperative = false;
    	
    	while(!endOperative) {
            switch(action) { 
            //TODOS LOS MENSAJES DE INTRODUCIR TAL DATO
			    case "launchMotor": // podria avisar de q ya esta encendido o apagado			    	
			    	Printer.turningOnMotor();
			        currentAirplanes[airplaneNumber].turnOn_motor();
			        break;
			    case "stopMotor":
			    	Printer.turningOffMotor();
			        currentAirplanes[airplaneNumber].turnOff_motor();
			        break;
			    case "accelerate":
			    	Printer.increasingSpeed();
			    	Printer.inputIncreaseSpeed();
			        currentAirplanes[airplaneNumber].increaseSpeed(InputListener.inputInt(Airplane.SPEED_LIMIT));
			        break;
			    case "stop":
			    	Printer.decreasingSpeed();
			    	Printer.inputDeccreaseSpeed();
			        currentAirplanes[airplaneNumber].decreaseSpeed(InputListener.inputInt()); // comprobar q no sea menor a 0 y si te qdas sin velocidad en el aire algo
			        break;
			    case "increaseAltitude":
			    	Printer.increasingAltitude();
			    	Printer.inputIncreaseAltitude();
			        currentAirplanes[airplaneNumber].increaseAltitude(InputListener.inputInt());
			        break;
			    case "decreaseAltitude":
			    	Printer.decreasingAltitude();
			    	Printer.inputDecreaseAltitude();
			        currentAirplanes[airplaneNumber].decreaseAltitude(InputListener.inputInt());
			        break;
			    case "landingGearOn_Off": 
			    	String landGear = currentAirplanes[airplaneNumber].isLanding_gearOn() == true ? "tancat" : "obert";
			    	Printer.landingGearAction(landGear);
			        currentAirplanes[airplaneNumber].open_closeLandingGear();
			        break;
			    case "newDirection":
			    	Printer.changingDirection();
			    	Printer.inputDirection();
			        currentAirplanes[airplaneNumber].setDirection(Airplane.MAXDIRECTION);
			        break;
			    case "newX_Y":
			    	Printer.changingPosition();
			        Printer.inputX();
			        currentAirplanes[airplaneNumber].setPositionX(InputListener.inputInt());
			        Printer.inputY();
			        currentAirplanes[airplaneNumber].setPositionY(InputListener.inputInt());
			        break;
			    case "park":
			    	Printer.parkig();
			        currentAirplanes[airplaneNumber].park();
			        break;
			    case "endOperations":
			    	Printer.finishingOperative();
			    	endOperative = true;
			        break;
			}
            action = endOperative == true ? null : InputListener.inputOfMenuOptionN2();
    	}
    }
}
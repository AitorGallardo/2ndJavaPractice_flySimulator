        

            package core;

import java.util.ArrayList;
import elemnts.AirSpace;
import elemnts.Airplane;
import utilities.InputListener;

public class ControlSystem {

    
    // AirSpace airSpace = new AirSpace();
    
    public static final int XMAX = 10, YMAX = 10, MAXCAP = 5; // Delimitacio de l'espai aeri, espai real = 10^3

    
    int[][] zone;
    private Airplane[] currentAirplanes;
    
    public ControlSystem(AirSpace space) {
        // airSpace = space;
    }
    
    //// CHECKS PARA QUE NO SE PASEN DE LOS RANGOS DEL MAPA, 



    


// New airplanes (menu option 1)
    
    public void AddNewAirplane() {

        boolean freeXYPosition = false;
        int x, y;
        
        if(getNumberOfExistingAirplanes() < MAXCAP) {
            String numberPlate = InputListener.inputString(Airplane.NUMBERPLATE_MAXLENGHT);
            if(checkNumberPlateMatches(numberPlate) != -1){
                String model = InputListener.inputString(Airplane.MODEL_MAXLENGHT),
                       manufacturer =  InputListener.inputString(Airplane.MANUFACTURER_MAXLENGHT);
                        //CHECK DE LAS MATRICULAS
                
                int maxCapacity = InputListener.inputInt();
                while(freeXYPosition == false){
                    x = InputListener.inputInt();
                    y = InputListener.inputInt();
                      freeXYPosition = checkFreePositionOnCreate(x, y);
                }
                addAirplane(new Airplane(model, manufacturer, numberPlate, maxCapacity, x, y));

            } else {
                System.out.println("Aquesta matricula ja es troba registrada");
            }

                    
        } else {            
            System.out.println("L'espai aeri esta ple. Utilitza la opcio del menu 3 per realitzar un manteniment de l'espai aeri");
        }
    }
    
    public void addAirplane(Airplane newairplane) {
        for(int i = 0; i < currentAirplanes.length; i++) {
            if(currentAirplanes[i] == null) currentAirplanes[i] = newairplane;
        }
    }
    
    //CHECKS
    public int getNumberOfExistingAirplanes() {
        
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
                if(airplane.getPositionX() == newX && airplane.getPositionY() == newY )
                    System.out.println("En aquesta posicio ja es troba un avio");
                    return false;
            }   
        }
        return true;
    }
// Airplanes functions (menu option 2)
    
    public int checkNumberPlateMatches(String numberPlate) {
        
        Airplane[] currentAirplanes = getCurrentAirplanes();
        int position = 0;
        
        
        for(Airplane airplane : currentAirplanes) {
            if(airplane!=null) {
                if(airplane.getNumberPlate().equals(numberPlate))
                    return position;
            }   
        }
        return -1;
    }
    
    public void mainAirplaneFunctions(int airplaneNumber) {
        
        if(airplaneNumber != -1) {
            
            String airplaneOption = InputListener.inputOfMenuOptionN2();
            
            airplaneActions(airplaneNumber, airplaneOption);
            
        } else {
            System.out.println("Aquesta matriucla no es troba registrada entre els avions que hi han a pista");
        }
    }
    
    
    
    
    public void clean(int airplanePosition) {

        // zone.removeAirplane();
        // use iterator list
    }

    public void display() {
        airSpace.getCurrentAirplanes(); // more 
    }
    
    //AirSpace
        

    public Airplane[] getCurrentAirplanes() {
        return currentAirplanes;
    }
    public Airplane getAirplane(int number) {
        return currentAirplanes[number];
    }
    


    

    public void airplaneActions(int airplaneNumber, String action) {
        
        switch(action) { 
                    //TODOS LOS MENSAJES DE INTRODUCIR TAL DATO
            case "launchMotor": // podria avisar de q ya esta encendido o apagado
                currentAirplanes[airplaneNumber].turnOn_motor();
                break;
            case "stopMotor":
                currentAirplanes[airplaneNumber].turnOff_motor();
                break;
            case "accelerate":
                currentAirplanes[airplaneNumber].increaseSpeed(InputListener.inputInt(Airplane.SPEED_LIMIT));
                break;
            case "stop":
                currentAirplanes[airplaneNumber].decreaseSpeed(InputListener.inputInt()); // comprobar q no sea menor a 0 y si te qdas sin velocidad en el aire algo
                break;
            case "increaseAltitude":
                currentAirplanes[airplaneNumber].increaseAltitude(InputListener.inputInt());
                break;
            case "decreaseAltitude":
                currentAirplanes[airplaneNumber].decreaseAltitude(InputListener.inputInt());
                break;
            case "landingGearOn_Off": 
                currentAirplanes[airplaneNumber].open_closeLandingGear();
                break;
            case "newDirection":
                currentAirplanes[airplaneNumber].setDirection(Airplane.MAXDIRECTION);
                break;
            case "newX_Y":
                System.out.println("Introdueix la posicio X");
                currentAirplanes[airplaneNumber].setPositionX(InputListener.inputInt());
                System.out.println("Introdueix la posicio Y");
                currentAirplanes[airplaneNumber].setPositionY(InputListener.inputInt());
                break;
            case "park":
                currentAirplanes[airplaneNumber].park();
                break;
            case "endOperations":
                break;
        }
    }
        
    


}
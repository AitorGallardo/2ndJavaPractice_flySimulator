package elemnts;

import utilities.Printer;

public class Airplane {
	
	public static final int MODEL_MAXLENGHT = 10, MANUFACTURER_MAXLENGHT = 10, NUMBERPLATE_MAXLENGHT = 8, MAXDIRECTION = 360, SPEED_LIMIT = 2000, MAXCAPACITY_LIMIT = 500;
	
	private String model, manufacturer, numberPlate;
	private int positionX, positionY;
	private int altitude;
	private int direction;
	private int speed;
	private boolean motorOn, landing_gearOn, active;
	private int MaxCapacity;
	
	public Airplane(String model, String manufacturer, String numberPlate, int MaxCapacity, int x, int y) {
		
		this.model = model;
		this.manufacturer = manufacturer;
		this.numberPlate = numberPlate;
		this.MaxCapacity = MaxCapacity;	
		this.positionX = x;
		this.positionY = y;
		this.landing_gearOn = true;
		this.motorOn = true;
		this.active = true;
		this.altitude = 0;
				
	}
	
	//Airplane main functions

	public void turnOn_motor() {
		motorOn = true;
	}
	public void turnOff_motor() {
		motorOn = false;
	}
	public void increaseSpeed(int addSpeed) {
		if(motorOn && speed+addSpeed<=2000) {
			speed+=addSpeed;
		}else if(!motorOn) {
			Printer.dangerMotorOff();
		} else {
			Printer.maxSpeed();
		}
	}
	public void decreaseSpeed(int reduceSpeed) {
		if(motorOn && speed-reduceSpeed>=0) {
			speed-=reduceSpeed;
		}else if(!motorOn) {
			Printer.dangerMotorOff();
		} else {
			Printer.minSpeed();
		}
	}
	public void increaseAltitude(int increasingAltitude) {
		if(motorOn && checkBeforeIncreasingAltitude(increasingAltitude)) {
			speed+=increasingAltitude;
		}else if(!motorOn) {
			Printer.dangerMotorOff();
		}
	}
	public void decreaseAltitude(int decreasingAltitude) {
		if(motorOn && checkBeforeDecreasingAltitude(decreasingAltitude)) {
			speed-=decreasingAltitude;
		}else if(!motorOn) {
			Printer.dangerMotorOff();
		}
	}
	public void open_closeLandingGear() {
		if(motorOn) {
			if(this.landing_gearOn==true){
				if(checkIfCanICloseLandingGear()){
					this.landing_gearOn = !this.landing_gearOn;
				}
			} else {
				if(checkIfCanIOpenLandingGear()){
					this.landing_gearOn = !this.landing_gearOn;
				}
			}
		} else {
			Printer.dangerMotorOff();
		}
	}
	public void setDirection(int newDirection) {
		if(motorOn) {
			direction = newDirection;
		} else {
			Printer.dangerMotorOff();
		}
	}
	public void setPositionX(int positionX) {
		if(motorOn) {
			this.positionX = positionX;
		} else {
			Printer.dangerMotorOff();
		}
	}

	public void setPositionY(int positionY) {
		if(motorOn) {
			this.positionY = positionY;
		} else {
			Printer.dangerMotorOff();
		}
	}
	public void park() {
		if(motorOn&&checkBeforePark()) {
			Printer.onParkig();
			setActive(false);
		} else if(!motorOn) {
			Printer.dangerMotorOff();
		}
	}
	
	// Check functions
	
	public boolean checkBeforePark() {
		
		double speedToPark = getSpeed();
		double altitudeToPark = getAltitude();
		
		if(isActive()) {
			if(speedToPark <= 20 && altitudeToPark == 0) {
				return true;
			} else {
				if(speedToPark > 20)
					Printer.miniumSpeedToPark();
				if(altitudeToPark > 0)
					Printer.landedToPark();
			}
		} else {
			Printer.alreadyParked();
		}
		return false;
	}
		
	public boolean checkRequiredSpeedToTakeOff() {

		int currentSpeed = getSpeed();
		int minSpeedToTakeOff = 180;

			
			if(currentSpeed >= minSpeedToTakeOff) {
				return true;
			} else {
				Printer.miniumSpeedToFly();
				return false;
			}	
	}
	
	public boolean checkLandingGearOnRaiseAltitude(int desiredAltitude) {
		
		if(desiredAltitude > 500 && landing_gearOn==false) {
			Printer.landingGearOffToFly();
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkIfCanIOpenLandingGear() {
		
		int currentAltitude = getAltitude();
		int currentSpeed = getSpeed();
		
		if(currentAltitude > 500 && currentSpeed >= 300) {
			Printer.landingGearOnTOFly();
			return false;
		} else {
			return true;
		}
		
	}
	
	public boolean checkIfCanICloseLandingGear() {
		
		int currentAltitude = getAltitude();

		if(currentAltitude <= 50) {
			Printer.incAltitudToLandingGear();
			return false;
		} else if(altitude==0) {
			Printer.cantCloseLandingGearLanded();
			return false;
		} else {
			return true;
		}
		
	}
	
	public boolean checkBeforeIncreasingAltitude(int inputNewAltitude) {
		
		int currentAltitude = getAltitude();
		int desiredAltitude = currentAltitude + inputNewAltitude;

			if(currentAltitude==0) {
				if(checkRequiredSpeedToTakeOff()) {
					return false;
				}
			} else {
				if(checkLandingGearOnRaiseAltitude(desiredAltitude)==false) {
					return false;
				}
			}
			return true;
	}
	
	public boolean checkBeforeDecreasingAltitude(int inputNewAltitude) {
		
		int currentAltitude = getAltitude();
		int desiredAltitude = currentAltitude - inputNewAltitude;

			if(currentAltitude==0) {
				Printer.alreadyLanded();
					return false;
			} else if(desiredAltitude==0) {
				Printer.landingGearToLand();
				return false;
			} else if(desiredAltitude<0) {
				Printer.crashAltitude();
					return false;
			} else if(desiredAltitude<100){
				Printer.landingGearToDesc();
					return false;
			}		
					
			return true;
	}
	
	
	
	// General info to print in a table
	
    public String valueToPrint(int number) {
    
    String info = "";
    
    switch(number) {
        case 0:
            info =  String.valueOf(getManufacturer());
            break;
        case 1:
            info = String.valueOf(getModel());
            break;
        case 2:
            info = String.valueOf(getNumberPlate());
            break;
        case 3:
            info = String.valueOf(getPositionX());
            break;
        case 4:
            info = String.valueOf(getPositionY());
            break;
        case 5:
            info = String.valueOf(getAltitude());
            break;
        case 6:
            info = String.valueOf(getSpeed());
            break;
        case 7:
            info = String.valueOf(isLanding_gearOn());
            break;
        case 8:
            info = String.valueOf(isMotorOn());
            break;
        case 9:
            info = String.valueOf(isActive());
            break;
    }
    return info;
}

	
	
	
	
	
	// Getters&setters
	
	public String getModel() {
		return model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public int getAltitude() {
		return altitude;
	}

	public int getDirection() {
		return direction;
	}

	public int getSpeed() {
		return speed;
	}

	public boolean isMotorOn() {
		return motorOn;
	}

	public boolean isLanding_gearOn() {
		return landing_gearOn;
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getMaxCapacity() {
		return MaxCapacity;
	}
	
	
	

	
	

	

}

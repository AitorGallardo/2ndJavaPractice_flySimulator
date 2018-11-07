package elemnts;

public class Airplane {
	
	private String model, manufacturer, numberPlate;
	private int positionX, positionY;
	private int altitude;
	private int direction;
	private int speed;
	private boolean motorOn, landing_gearOn, active;
	private int MaxCapacity;
	
	public Airplane(String model, String manufacturer, String numberPlate,int MaxCapacity, int x, int y) {
		
		this.model = model;
		this.manufacturer = manufacturer;
		this.numberPlate = numberPlate;
		this.MaxCapacity = MaxCapacity;	
		this.positionX = x;
		this.positionY = y;
		this.landing_gearOn = true;
		
		
	}
	
	//Printer indicando canvios?

	public void turnOn_motor() {
		motorOn = true;
	}
	public void turnOff_motor() {
		motorOn = false;
	}
	public void increaseSpeed(int addSpeed) {
		if(motorOn) {
			speed+=addSpeed;
		}
	}
	public void decreaseSpeed(int reduceSpeed) {
		if(motorOn) {
			speed-=reduceSpeed;
		}
	}
	public void increaseAltitude(int increasingAltitude) {
		if(motorOn && checkBeforeIncreasingAltitude(increasingAltitude)) {
			speed+=increasingAltitude;
		}
	}
	public void decreaseAltitude(int decreasingAltitude) {
		if(motorOn) {
			speed-=decreasingAltitude;
		}
	}
	public void open_closeLandingGear() {
		this.landing_gearOn = !this.landing_gearOn;
	}
	public void setDirection(int newDirection) {
		if(motorOn) {
			direction = newDirection;
		}
	}
	public void setPositionX(int positionX) {
		if(motorOn) {
			this.positionX = positionX;
		}
	}

	public void setPositionY(int positionY) {
		if(motorOn) {
			this.positionY = positionY;
		}
	}
	public void park() {
		if(motorOn&&checkBeforePark()) {
			System.out.println("Es procedeix a aparcar l'avio"); // printer
			setActive(false);
		}
	}
	
	public boolean checkBeforePark() {
		
		double speedToPark = getSpeed();
		double altitudeToPark = getAltitude();
		
		if(isActive()) {
			if(speedToPark >= 20 && altitudeToPark == 0) {
				return true;
			} else {
				if(speedToPark > 20)
					System.out.println("La velocitat ha de ser inferior a 20km/h per aparcar. Pots reduir la velocitat apretant 'd'");
				if(altitudeToPark > 0)
					System.out.println("L'avio ha de estar aterrat per poder aparcar. Pots reduir la altitud de l'avio fins a aterrar apretant 'f'");
			}
		} else {
			System.out.println("L'avio ja esta aparcat");
		}
		return false;
	}
		
	public boolean checkRequiredSpeedToTakeOff() {

		int currentSpeed = getSpeed();
		int minSpeedToTakeOff = 180;

			
			if(currentSpeed >= minSpeedToTakeOff) {
				return true;
			} else {
				System.out.println("Has de tenir una velocitat minima de 180km/h per enlairarte");
				return false;
			}	
	}
	
	public boolean checkIfLandingGearHasToBeOpen(int desiredAltitude) {
		
		if(desiredAltitude > 500 && landing_gearOn==false) {
			System.out.println("Has de recollir el tren d'aterratge si vols enlairarte a mes de 500m d'altitud");
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkIfCanIOpenLandingGear() {
		
		int currentAltitude = getAltitude();
		int currentSpeed = getSpeed();
		
		if(currentAltitude > 500 && currentSpeed >= 300) {
			System.out.println("Hauras de reduir la teva altitud o velocitat per poder desplegar el tren d'aterratge");
			return false;
		}
		
	}
	
	public boolean checkIfCanICloseLandingGear() {
		
		int currentAltitude = getAltitude();
		int currentSpeed = getSpeed();
		
		if(currentAltitude > 500 && currentSpeed >= 300) {
			System.out.println("Hauras de reduir la teva altitud o velocitat per poder desplegar el tren d'aterratge");
			return false;
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
				if(checkIfLandingGearHasToBeOpen(desiredAltitude)==false) {
					return false;
				}
			}
			return true;
	}
	
	public boolean checkBeforeDecreasingAltitude(int inputNewAltitude) {
		
		int currentAltitude = getAltitude();
		int desiredAltitude = currentAltitude - inputNewAltitude;

			if(currentAltitude==0) {
				System.out.println("Estas a terra, no pots descendir ");
					return false;
			} else if(desiredAltitude==0) {
				System.out.println("Has de desplegar el tren d'aterratge per poder aterrar");
				return false;
			} else if(desiredAltitude<0) {
				System.out.println("No pots descendir aquesta altura o colisionaras contra el terre");
					return false;
			} else if(desiredAltitude<100){
				System.out.println("Has de desplagar el tren d'aterratge si vols descendir a una altitud inferior als 100 metres");
					return false;
			} else if() {
				
			}

			return true;
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

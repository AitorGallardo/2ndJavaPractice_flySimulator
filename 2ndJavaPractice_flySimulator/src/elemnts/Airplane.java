package elemnts;

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
				
	}

	// MAXIMO MATRICULA, MAXIMO MANUFACTURER, MODELO,MAX DIRECTION, SPEED, CAPACIDAD
	// PODRIA HACER UNA CLASSE VALIDATORS PARA LAS CONDICIONES O HACER DIRECTAMENTE LOS METODOS EN CADA CLASSE
	

			/*public void setAnumber(int value) { //// MAX POSITION RANGE (((CONTROL SYSTEM)))
		    if ((value < 1) || (value > 3))
		        throw new IllegalArgumentException("value is out of range for anumber");
		    this.anumber = value;
			}*/

	
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
		}else {
			System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
		}
	}
	public void decreaseSpeed(int reduceSpeed) {
		if(motorOn) {
			speed-=reduceSpeed;
		}else if(!motorOn) {
			System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
		}
	}
	public void increaseAltitude(int increasingAltitude) {
		if(motorOn && checkBeforeIncreasingAltitude(increasingAltitude)) {
			speed+=increasingAltitude;
		}else if(!motorOn) {
			System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
		}
	}
	public void decreaseAltitude(int decreasingAltitude) {
		if(motorOn && checkBeforeDecreasingAltitude(decreasingAltitude)) {
			speed-=decreasingAltitude;
		}else if(!motorOn) {
			System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
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
			System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
		}
	}
	public void setDirection(int newDirection) {
		if(motorOn) {
			direction = newDirection;
		} else {
			System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
		}
	}
	public void setPositionX(int positionX) {
		if(motorOn) {
			this.positionX = positionX;
		} else {
			System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
		}
	}

	public void setPositionY(int positionY) {
		if(motorOn) {
			this.positionY = positionY;
		} else {
			System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
		}
	}
	public void park() {
		if(motorOn&&checkBeforePark()) {
			System.out.println("Es procedeix a aparcar l'avio"); // printer
			setActive(false);
		} else if(!motorOn) {
			System.out.println("No pots realitzar aquesta operacio, el motor esta apagat");
		}
	}
	
	// Check functions
	
	public boolean checkBeforePark() {
		
		double speedToPark = getSpeed();
		double altitudeToPark = getAltitude();
		
		if(isActive()) {
			if(speedToPark >= 20 && altitudeToPark == 0) {
				return true;
			} else {
				if(speedToPark > 20)
					System.out.println("La velocitat ha de ser inferior a 20km/h per aparcar");
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
	
	public boolean checkLandingGearOnRaiseAltitude(int desiredAltitude) {
		
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
			System.out.println("Hauras de reduir la teva altitud i o velocitat per poder desplegar el tren d'aterratge");
			return false;
		} else {
			return true;
		}
		
	}
	
	public boolean checkIfCanICloseLandingGear() {
		
		int currentAltitude = getAltitude();

		if(currentAltitude <= 50) {
			System.out.println("Hauras d'augmentar la teva altitud per poder tancar el tren d'aterratge");
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
			}		
					
			return true;
	}
	
	
/*	public void valueToPrint(int number) {
		
		switch(number) {
			case 0:
				getManufacturer();
				break;
			case 1:
				getModel();
				break;
			case 2:
				getNumberPlate();
				break;
			case 3:
				getPositionX();
				break;
			case 4:
				getPositionY();
				break;
			case 5:
				getAltitude();
				break;
			case 6:
				getSpeed();
				break;
			case 7:
				isLanding_gearOn();
				break;
			case 8:
				isMotorOn();
				break;
			case 9:
				isActive();
				break;
		}
	}*/

	
	
	
	
	
	
	
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

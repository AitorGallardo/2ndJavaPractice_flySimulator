package elemnts;

public class Airplane {
	
	private String model, manufacturer, numberPlate;
	private int positionX, positionY;
	private double altitude;
	private double direction;
	private double speed;
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

	public void turnOn_motor() {
		motorOn = true;
	}
	public void turnOff_motor() {
		motorOn = false;
	}
	public void increaseSpeed(int addSpeed) {
		speed+=addSpeed;
	}
	public void decreaseSpeed(int reduceSpeed) {
		speed-=reduceSpeed;
	}
	public void increaseAltitude(int increaseAltitude) {
		speed+=increaseAltitude;
	}
	public void decreaseAltitude(int decreaseAltitude) {
		speed-=decreaseAltitude;
	}
	public void open_closeLandingGear(boolean landing_gearOn) {
		this.landing_gearOn = landing_gearOn;
	}
	public void setDirection(double newDirection) {
		direction = newDirection;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public void park() {
		
		double speedToPark = getSpeed();
		double altitudeToPark = getAltitude();
		
		if(isActive()) {
			if(speedToPark == 20 && altitudeToPark == 0) {
				System.out.println("Es procedeix a aparcar l'avio"); // printer
				setActive(false);
			} else {
				if(speedToPark > 20)
					System.out.println("La velocitat ha de ser inferior a 20km/h per aparcar. Pots reduir la velocitat apretant 'd'");
				if(altitudeToPark > 0)
					System.out.println("L'avio ha de estar aterrat per poder aparcar. Pots reduir la altitud de l'avio fins a aterrar apretant 'f'");
			}
		} else {
			System.out.println("L'avio ja esta aparcat");
			return;
		}	
	}
	
	
	
	
	
	
	
	// Getters
	
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

	public double getAltitude() {
		return altitude;
	}

	public double getDirection() {
		return direction;
	}

	public double getSpeed() {
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

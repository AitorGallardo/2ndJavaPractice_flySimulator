package elemnts;

public class Airplane {
	
	private String model, manufacturer, numberPlate;
	private int positionX, positionY;
	private double altitude;
	private double direction;
	private double speed;
	private boolean motorOn;
	private boolean landing_gearOn;
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

	public int getMaxCapacity() {
		return MaxCapacity;
	}
	
	
	

	
	

	

}

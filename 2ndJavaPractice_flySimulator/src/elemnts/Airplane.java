package elemnts;

public class Airplane {
	
	private String model, manufacturer, numberPlate;
	private int positionX, positionY;
	private double altitude;
	private double direction;
	private double speed;
	private boolean motorOn;
	private int MaxCapacity;
	
	public Airplane(String model, String manufacturer, String numberPlate,int MaxCapacity, int x, int y) {
		
		this.model = model;
		this.manufacturer = manufacturer;
		this.numberPlate = numberPlate;
		this.MaxCapacity = MaxCapacity;
		this.positionX = x;
		this.positionY = y;
		
		
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
	public void increaseAltitude() {
		
	}
	public void decreaseAltitude() {
		
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

	public int getMaxCapacity() {
		return MaxCapacity;
	}
	
	
	

	
	

	

}

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
	

	

}

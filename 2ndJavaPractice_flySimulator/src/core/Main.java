package core;

public class Main {
	
	Manager manager = new Manager();

	public static void main(String[] args) {
		Main flySimulator = new Main();
		flySimulator.start();

	}
	
	public void start() {
		manager.mainLoop();
	}

}

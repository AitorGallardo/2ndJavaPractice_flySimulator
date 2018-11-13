package utilities;

import elemnts.Airplane;

public final class Printer {
	
	private Printer() {}

	public static void print() {
		System.out.println("holholahola");
	}
	
	
/*	public static void airplaneTable(Airplane[] currentAirplanes) {
		int position = 0;
		System.out.printf("%10s %30s %20s %5s %5s", "STUDENT ID", "EMAIL ID", "NAME", "AGE", "GRADE");
		for(Airplane airplane : currentAirplanes) {
			System.out.format("%10s %30s %20s %5d %5c", airplane.valueToPrint(position));
		}
	}
*/
}

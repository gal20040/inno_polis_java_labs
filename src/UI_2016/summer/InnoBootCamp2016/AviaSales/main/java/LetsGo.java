//import java.util.ArrayList;
//
//public class LetsGo {
//
//	public static void main(String[] args) {
//		Menu.showMenu();
//
//		ArrayList arrayList = new ArrayList();
//
//		ParserFromFile.readFile("sad", arrayList);
//
//		System.out.println();
//		System.out.println("Parsing result");
//		System.out.println("--------------");
//
//		for (int i = 0; i < arrayList.size(); i++) {
//			Flight flight = (Flight) arrayList.get(i);
//
//			System.out.print("From: " + flight.departure + " ");
//			System.out.print("To: " + flight.arrival + " ");
//			System.out.print("Dep date and time: " + flight.departureDateTime + " ");
//			System.out.print("Arr date and time: " + flight.arrivalDateTime + " ");
//			System.out.print("Price: " + flight.cost + " ");
//			System.out.print("Distance : " + flight.distance + " ");
//			System.out.print("Trip class: " + flight.tripClass + " ");
//			System.out.println("Number of changes: " + flight.numberOfChanges);
//		}
//	}
//}
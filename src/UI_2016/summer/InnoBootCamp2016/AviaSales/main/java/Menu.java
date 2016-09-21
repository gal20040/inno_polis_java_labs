import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
//    static User currentUser;

    public static void showMenu() {
    	String[] menuItems = new String[4];

		menuItems[0] = "Search flights";
		menuItems[1] = "Register";
		menuItems[2] = "Login";
		menuItems[3] = "Exit";

		int selectedItem = 0;
		Scanner scanner = new Scanner(System.in);
		boolean needRepeat = true;

		while (needRepeat) {
			for (int i = 0; i < menuItems.length; i++) {
//				String template = "%s. %s";
//				System.out.println(String.format(null, template, i + 1, menuItems[i]));
				System.out.println(i + 1 + ". " + menuItems[i]);
			}

			if (scanner.hasNextInt())
				selectedItem = scanner.nextInt();
			else
				selectedItem = menuItems.length+1;

			switch (selectedItem) {
			case 1:
				Flight infoAboutNecessaryFlight = gatherFlightInfo();
				searchTickets(infoAboutNecessaryFlight);
				break;
			case 2:
				register();
				break;
			case 3:
				logIn();
				break;
			case 4:
				if (isUserLogedIn())
					logOut();
				needRepeat = false;
				break;
			default:
				System.out.println("Incorrect input. Enter number of main menu item.");
				break;
			}
		}
		scanner.close();
    }

    public static void register() {

    }

    public static void logIn() {
//        input = String;
//        Authentication.logIn(input);
//        System.out.println("result of login");
    }

    public static boolean isUserLogedIn() {
    	//TODO need to check whether user loged or not
    	return false;
    }

    public static void logOut() {

    }

    public static Flight gatherFlightInfo() {
    	String[] menuItems = new String[4];

		menuItems[0] = "Enter departute location: ";
		String depLocation = null;
		menuItems[1] = "Enter arrival location: ";
		String arrLocation = null;
		menuItems[2] = "Enter date (yyyy.MM.dd): ";
		Date depDate = null;
		menuItems[3] = "One-way or two-way flight (1 or 2)? ";
		int oneTwoWay = 0;

//		int selectedItem = 0;
		Scanner scanner = new Scanner(System.in);


		boolean needRepeat = true;

		while (needRepeat) {
			for (int i = 0; i < menuItems.length; i++) {
				System.out.println(menuItems[i]);

				switch (i) {
				case 0:
					depLocation = scanner.nextLine();
					break;
				case 1:
					arrLocation = scanner.nextLine();
					break;
				case 2:
					String dateTemplate = "yyyy.MM.dd";
					SimpleDateFormat inputFormatDate = new SimpleDateFormat(dateTemplate);
					try {
						depDate = inputFormatDate.parse(scanner.nextLine()); //TODO make checking
					} catch (java.text.ParseException e) {
						System.out.println("You have entered incorrect date, enter date in format: " + dateTemplate);
						e.printStackTrace();
						i--; //We need to repeat answer
					}

					break;
				case 3:
//					if (scanner.hasNextInt())
						oneTwoWay =scanner.nextInt(); //TODO make checking whether the data is int or not
//					else {
//						System.out.println("You have entered incorrect data, use only 1 or 2 numbers.");
//						i--; //We need to repeat answer
//					}

						if (oneTwoWay != 1 || oneTwoWay != 2) {
							System.out.println("You have entered incorrect data, use only 1 or 2 numbers.");
							i--;
						}
					break;
				default:

					break;
				}

				System.out.println();
			}

		}
		scanner.close();

		Flight flight = new Flight(depLocation, arrLocation, depDate);

		return flight;
    }

    public static void searchTickets(Flight infoAboutNecessaryFlight) {

    }

    public void showProfile() {

    }
}

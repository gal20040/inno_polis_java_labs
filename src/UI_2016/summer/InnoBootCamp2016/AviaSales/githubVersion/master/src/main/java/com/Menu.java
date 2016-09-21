//package com;
//
//import com.db.ParserFromFile;
//import com.entities.Flight;
//import com.entities.User;
//
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Scanner;
//import com.entities.User;
//import com.exceptions.InvalidLoginException;
//import com.exceptions.InvalidPasswordException;
//import com.exceptions.LoginAlreadyOccupiedException;
//
//import static com.Authentication.register;
//
//public class Menu {
//
//    private static User currentUser;
//    private static boolean userLoggedIn = false;
//    private static Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        Menu.showMenu();
//        scanner.close();
//    }
//
//    public static void showMenu() {
//        String[] menuItems = new String[5];
//        int count = 0;
//
//        menuItems[count] = "Search flights";
//        count++;
//        menuItems[count] = "Register";
//        count++;
//        menuItems[count] = "Login";
//        count++;
//        menuItems[count] = "Show profile";
//        count++;
//        menuItems[count] = "Exit";
//
//        int selectedItem;
//        boolean needRepeat = true;
//
//        while (needRepeat) {
//            for (int i = 0; i < menuItems.length; i++) {
//                System.out.println(i + 1 + ". " + menuItems[i]);
//            }
//
//            selectedItem = -1; //строчку не убирать, без неё while зацикливается
//            if (scanner.hasNextInt()) {
//                selectedItem = scanner.nextInt();
//            }
//            else {
//                selectedItem = menuItems.length + 1;
//                if (scanner.hasNextLine())
//                    scanner.nextLine();
//            }
//
//            switch (selectedItem) {
//                case 1:
//                    searchTickets(gatherFlightInfo());
//                    break;
//                case 2:
//                    registerUser();
//                    break;
//                case 3:
//                    logIn();
//                    break;
//                case 4:
//                    showProfile();
//                    System.out.println();
//                    break;
//                case 5:
//                    logOut();
//                    needRepeat = false;
//                    break;
//                default:
//                    System.out.println("Incorrect input. Enter number of main menu item.");
//                    break;
//            }
//        }
////        scanner.close();
//    }
//
//    public static boolean registerUser() {
//        if (!userLoggedIn) {
//            String[] menuItems = new String[5];
//
//            menuItems[0] = "Enter your login:";
//            menuItems[1] = "Enter your password:";
//            menuItems[2] = "Enter your first name:";
//            menuItems[3] = "Enter your last name:";
//            menuItems[4] = "Enter your passport data:";
//
//            String login = "";
//            String password = "";
//            String firstName = "";
//            String lastName = "";
//            String passport = "";
//
//            boolean needRepeat = true;
//
//            while (needRepeat) {
//                for (int i = 0; i < menuItems.length; i++) {
//                    System.out.println(menuItems[i]);
//
//                    switch (i) {
//                        case 0:
//                            login = scanner.nextLine();
//                            login = "";
//                            login = scanner.nextLine();
//                            break;
//                        case 1:
//                            password = scanner.nextLine();
//                            break;
//                        case 2:
//                            firstName = scanner.nextLine();
//                            break;
//                        case 3:
//                            lastName = scanner.nextLine();
//                            break;
//                        case 4:
//                            passport = scanner.nextLine();
//                            needRepeat = false;
//                            break;
//                        default:
//                            break;
//                    }
//                }
//
//                User newUser = new User(login, password, firstName, lastName, passport);
//                boolean registrationResult = false;
//
//                try {
//                    registrationResult = register(newUser);
//                } catch (InvalidLoginException e) {
//                    System.out.println("InvalidLoginException");
//                } catch (InvalidPasswordException e) {
//                    System.out.println("InvalidPasswordException");
//                } catch (LoginAlreadyOccupiedException e) {
//                    System.out.println("LoginAlreadyOccupiedException");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                if (registrationResult) {
//                    setCurrentUser(newUser);
//                    System.out.println("Registration successfully completed. You are logged in.");
//                }
//                else
//                    System.out.println("Something went wrong.");
//
//            }
//            System.out.println();
//            userLoggedIn = true;
//            return true;
//        } else {
//            System.out.println("You are already logged in.");
//            System.out.println();
//            return false;
//        }
//    }
//
//    public static boolean logIn() {
//        if (!userLoggedIn) {
//            System.out.println("Enter login:");
//            scanner.nextLine();
//            String login = scanner.nextLine();
//            System.out.println("Enter password:");
//            String password = scanner.nextLine();
//
////        setCurrentUser(getUser(new User(login, password)));
//
//            // TODO не могу подключить getUser()
//            // поэтому пока что тестового юзера подключаю
//            String firstName = "test firstName data";
//            String lastName = "test lastName data";
//            String passport = "test passport data";
//            setCurrentUser(new User(login, password, firstName, lastName, passport));
//
//            System.out.println("You have successfully logged in.");
//
//            System.out.println();
//            userLoggedIn = true;
//            return true;
//        } else {
//            System.out.println("You are already logged in.");
//            System.out.println();
//            return false;
//        }
//    }
//
////    public static boolean isUserLoggedIn() {
////        if (userLoggedIn)
////            return true;
////        else
////            return false;
////    }
//
//    public static void logOut() {
//        if (userLoggedIn) {
//            userLoggedIn = false;
//            currentUser = null;
//        }
//    }
//
//    public static Flight gatherFlightInfo() {
//        String[] menuItems = new String[4];
//        String dateTemplate = "yyyy.MM.dd";
//
//        menuItems[0] = "Enter departure location (3 letters): ";
//        menuItems[1] = "Enter arrival location (3 letters): ";
//        menuItems[2] = "Enter date (" + dateTemplate + "): ";
//        menuItems[3] = "One-way or two-way flight (1 or 2)? ";
//
//        String depLocation = null;
//        String arrLocation = null;
//        Date depDate = null;
//        int oneTwoWay;
//
////        Scanner scanner = new Scanner(System.in);
//
//
//        boolean needRepeat = true;
//        Object answer;
//
//        SimpleDateFormat inputFormatDate = new SimpleDateFormat(dateTemplate);
//
//        while (needRepeat) {
//            for (int i = 0; i < menuItems.length; i++) {
//                System.out.println(menuItems[i]);
//
//                switch (i) {
//                    case 0:
//                        depLocation = scanner.nextLine();
//                        depLocation = depLocation.toUpperCase();
//
//                        answer = ParserFromFile.checkLocation(depLocation, null);
//
//                        if (answer instanceof String) {
//                            System.out.println("Airport departure title: " + answer);
//                        } else {
//                            System.out.println("Entered location has not been founded. Try another one.");
//                            //System.out.println("Airport departure title: " + answer); //TODO удалить строчку после окончания тестирования
//                            i--; //We need to repeat answer
//                        }
//                        break;
//                    case 1:
//                        arrLocation = scanner.nextLine();
//                        arrLocation = arrLocation.toUpperCase();
//
//                        answer = ParserFromFile.checkLocation(arrLocation, null);
//
//                        if (answer instanceof String) {
//                            System.out.println("Airport arrival title: " + answer);
//                        } else {
//                            System.out.println("Entered location has not been founded. Try another one.");
//                            //System.out.println("Airport arrival title: " + answer); //TODO удалить строчку после окончания тестирования
//                            i--; //We need to repeat answer
//                        }
//                        break;
//                    case 2:
//                        try {
//                            depDate = inputFormatDate.parse(scanner.nextLine()); //TODO make checking
//                        } catch (java.text.ParseException e) {
//                            System.out.println("You have entered incorrect date, enter date in format: " + dateTemplate);
////						e.printStackTrace();
//                            i--; //We need to repeat answer
//                        }
//
//                        break;
//                    case 3:
//                        if (scanner.hasNextInt())
//                            oneTwoWay = scanner.nextInt();
//                        else {
//                            scanner.nextLine();
//                            oneTwoWay = -1;
//                        }
//
//                        if (oneTwoWay == 1 || oneTwoWay == 2)
//                            needRepeat = false;
//                        else {
//                            System.out.println("You have entered incorrect data, use only numbers 1 or 2.");
//                            i--; //We need to repeat answer
//                        }
//                        break;
//                    default:
//                        break;
//                }
//
//                System.out.println();
//            }
//        }
//        // scanner.close(); //комментирование со строчки не снимать и строчку не удалять: сканер закрывать здесь нельзя - метод showMenu() зацикливается
//
//        return new Flight(depLocation, arrLocation, depDate);
//    }
//
//    public static void searchTickets(Flight infoAboutNecessaryFlight) {
//
//    }
//
//    public static void setCurrentUser(User currentUser) {Menu.currentUser = currentUser;}
//    public static User getCurrentUser() {return currentUser;}
//
//    public static void showProfile() {
//        if (userLoggedIn) {
//
//            System.out.println();
//            System.out.println("User login: " + currentUser.getLogin());
//            System.out.println("User first name: " + currentUser.getFirstName());
//            System.out.println("User last name: " + currentUser.getLastName());
//            System.out.println("User passport: " + currentUser.getPassport());
//
////        //для тестирования
////        ArrayList<Flight> tickets = new ArrayList<Flight>();
////        tickets.add(new Flight("depLoc1", "arrLoc1", new Date()));
////        tickets.add(new Flight("depLoc2", "arrLoc2", new Date()));
////        currentUser.setTickets(tickets);
////        //для тестирования
//
//            ArrayList<Flight> currentUserTickets = currentUser.getTickets();
//            if (currentUserTickets != null) {
////            System.out.println("currentUserTickets.size() = " + currentUserTickets.size());
//                if (currentUserTickets.size() > 0) {
//                    System.out.println("You have purchased " + currentUserTickets.size() + " tickets:");
//                    for (int i = 0; i < currentUserTickets.size(); i++) {
//                        System.out.println();
//                        System.out.println("Ticket #" + (i + 1));
//                        System.out.println("Flight name: " + currentUserTickets.get(i).getFlight());
//                        System.out.println("Departure location: " + currentUserTickets.get(i).getDeparture());
//                        System.out.println("Arrival location: " + currentUserTickets.get(i).getArrival());
//                        System.out.println("Departure date and time: " + currentUserTickets.get(i).getDepartureTime());
//                        System.out.println("Arrival date and time: " + currentUserTickets.get(i).getArrivalTime());
//                        System.out.println("Cost: " + currentUserTickets.get(i).getCost());
//                    }
//                } else {
//                    System.out.println("You have no purchased tickets.");
//                }
//            } else {
//                System.out.println("You have no purchased tickets.");
//            }
//        } else {
//            System.out.println("You are not logged in. Register or login please.");
//        }
//    }
//}

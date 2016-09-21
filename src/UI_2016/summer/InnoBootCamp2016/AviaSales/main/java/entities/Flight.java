package main.java.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Flight {

    String flightName;
    String departure;
    String arrival;
    LocalDate departureTime;
    LocalDate arrivalTime;
    int cost;
    int freePlaces;
    ArrayList<User> pasengers;

    public ArrayList<Flight> searchFlight(String params) {
        return null;
    }

}

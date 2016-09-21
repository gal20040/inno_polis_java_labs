package main.java.entities;

import java.util.ArrayList;

public class User {

    String login;
    String password;
    String firstName;
    String lastName;
    ArrayList<Flight> tickets;
    String passport;

    public boolean buyTicket(Flight flight) {
        return false;
    }

}

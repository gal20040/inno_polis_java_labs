//package com.entities;
//
//import java.util.ArrayList;
//
////import com.db.Database;
//
//public class User {
//
//    String login;
//    String password;
//    String firstName;
//    String lastName;
//    ArrayList<Flight> tickets;
//    String passport;
//
//    public User(String login, String password) {
//        this.login = login;
//        this.password = password;
//    }
//
//    public User(String login, String password, String firstName, String lastName, String passport) {
//        this.login = login;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.passport = passport;
//    }
//
//    public boolean buyTicket(Flight flight) {
//        // После покупки билетов надо обновлять список билетов
//        return false;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public ArrayList<Flight> getTickets() {
//        return tickets;
//    }
//
//    public String getPassport() {
//        return passport;
//    }
//}
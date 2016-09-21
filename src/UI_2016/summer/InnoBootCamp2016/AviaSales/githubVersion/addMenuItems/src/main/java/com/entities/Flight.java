//package com.entities;
//
//import java.util.Date;
//import java.util.ArrayList;
//
//public class Flight {
//
//    String flightName;
//    String departure;
//    String arrival;
//    Date departureTime;
//    Date arrivalTime;
//    int cost;
//    int freePlaces;
//
//    ArrayList<User> pasengers;
//
//    public Flight(String flightName, String departure, String arrival,
//                  Date departureTime, Date arrivalTime, int cost, int freePlaces) {
//        this.flightName = flightName;
//        this.departure = departure;
//        this.arrival = arrival;
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
//        this.cost = cost;
//        this.freePlaces = freePlaces;
//    }
//
//    public boolean equals(Flight secondFlight) {
//        if (flightName != secondFlight.flightName || departure != secondFlight.departure || arrival != secondFlight.arrival ||
//                departureTime != secondFlight.departureTime || arrivalTime != secondFlight.arrivalTime || cost != secondFlight.cost) {
//            return false;
//        }
//        return true;
//    }
//
//    public static ArrayList<Flight> searchFlight(String params) {
//        return null;
//    }
//
//    public Flight(String departure, String arrival, Date departureTime) {
//        this.departure = departure;
//        this.arrival = arrival;
//        this.departureTime = departureTime;
//    }
//
//    public String getFlight() {
//        return flightName;
//    }
//
//    public String getDeparture() {
//        return departure;
//    }
//
//    public String getArrival() {
//        return arrival;
//    }
//
//    public Date getDepartureTime() {
//        return departureTime;
//    }
//
//    public Date getArrivalTime() {
//        return arrivalTime;
//    }
//
//    public int getCost() {
//        return cost;
//    }
//
//    public int getSeatsLeft() {
//        return freePlaces;
//    }
//
//    public ArrayList<User> getPasengers() {
//        return pasengers;
//    }
//}
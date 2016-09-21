//package com.entities;
//
//import java.util.Date;
//import java.util.ArrayList;
//
//public class Flight {
//
//    private String flightName;
//    private String departure;
//    private String arrival;
//    private Date departureTime;
//    private Date arrivalTime;
//    private int cost;
//    private int freePlaces;
//    ArrayList<User> passengers;
//
//    public Flight(String flightName, String departure, String arrival,
//    			Date departureTime, Date arrivalTime, int cost, int freePlaces) {
//    	this.flightName = flightName;
//    	this.departure = departure;
//    	this.arrival = arrival;
//    	this.departureTime = departureTime;
//    	this.arrivalTime = arrivalTime;
//    	this.cost = cost;
//    	this.freePlaces = freePlaces;
//    }
//
//    public Flight() {
//
//    }
//
//    public boolean equals(Flight secondFlight) {
//    	if (flightName != secondFlight.flightName || departure != secondFlight.departure || arrival != secondFlight.arrival ||
//    			departureTime != secondFlight.departureTime || arrivalTime != secondFlight.arrivalTime || cost != secondFlight.cost) {
//    		return false;
//    	}
//    	return true;
//    }
//
//
//	public static ArrayList<Flight> searchFlight(String params) {
//        return null;
//    }
//
//}

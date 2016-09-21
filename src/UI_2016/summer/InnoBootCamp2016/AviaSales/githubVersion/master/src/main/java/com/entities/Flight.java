//package com.entities;
//
//import java.sql.Date;
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
//    private ArrayList<User> passengers;
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
//    public Flight(String departure, String arrival, Date departureTime) {
//        this.departure = departure;
//        this.arrival = arrival;
//        this.departureTime = departureTime;
//    }
//
//    public static ArrayList<Flight> searchFlight(String params) {
//	//getAllFlights, getNumberOfCities, parseCityToInt, make another class for search
//
//    	ArrayList<Flight> base = new ArrayList<Flight>();
//    	getAllFlights(base);
//
//    	int sizeVertex;
//    	int sizeEdge;
//
//    	sizeVertex = getNumberOfCities();
//    	sizeEdge = getNumberOfFlights();
//
//	ArrayList<ArrayList<String>> graph = new ArrayList<ArrayList<String>>();
//
//    	for(int count = 0; count < size_edge; count++){
//    			int vertex1 = parseCityToInt(base.get(count).departure);
//    			int vertex2 = parseCityToInt(base.get(count).arrival);
//
//    			graph.get(vertex1).add(vertex2 + '|' + base.get(count).flightName);
//
//    		}
//
//        return null;
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
//    public String getFlightName() {
//        return flightName;
//    }
//
//    public int getFreePlaces() {
//        return freePlaces;
//    }
//
//    public void setFlightName(String flightName) {
//        this.flightName = flightName;
//    }
//
//    public void setArrival(String arrival) {
//        this.arrival = arrival;
//    }
//
//    public void setDeparture(String departure) {
//        this.departure = departure;
//    }
//
//    public void setDepartureTime(Date departureTime) {
//        this.departureTime = departureTime;
//    }
//
//    public void setCost(int cost) {
//        this.cost = cost;
//    }
//
//    public void setArrivalTime(Date arrivalTime) {
//        this.arrivalTime = arrivalTime;
//    }
//
//    public void setFreePlaces(int freePlaces) {
//        this.freePlaces = freePlaces;
//    }
//
//    public void setPassengers(ArrayList<User> passengers) {
//        this.passengers = passengers;
//    }
//
//    public ArrayList<User> getPassengers() {
//        return passengers;
//    }
//
//    public int getSeatsLeft() {
//        return freePlaces;
//    }
//
//    public ArrayList<User> getPasengers() {
//        return passengers;
//    }
//
//}

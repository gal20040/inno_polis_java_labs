//package com.db;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.HashSet;
//
//import com.entities.Flight;
//import com.entities.User;
//public class Database {
//
//	public static void initDatabase() {
//		Connection conn = getConnection();
//        String tableUser = "CREATE TABLE users (login STRING PRIMARY KEY, password STRING, firstName STRING, lastName STRING, passport STRING)";
//		String tableFlights = "CREATE TABLE flights (flight STRING PRIMARY KEY, departure STRING, arrival STRING, departureTime STRING, arrivalTime STRING, freePlaces INTEGER, cost INTEGER)";
//		String tableTickets = "CREATE TABLE tickets (passenger STRING FOREIGN KEY, flight STRING FOREIGN KEY)";
//		try {
//			Statement stmt = conn.createStatement();
//			stmt.setQueryTimeout(10);
//	        stmt.execute(tableUser);
//	        stmt.execute(tableFlights);
//	        stmt.execute(tableTickets);
//		} catch (SQLException e) {
//			System.err.println("Problem creating database tables");
//		} finally {
//			try {
//				if(conn != null)
//                	conn.close();
//            }
//			catch(SQLException e) {
//				System.err.println(e);
//			}
//		}
//	}
//
//
//	private static Connection getConnection() {
//
//		Connection conn = null;
//
//		try {
//			Class.forName("org.sqlite.JDBC");
//			conn = DriverManager.getConnection("jdbc:sqlite:storage.db");
//
//		} catch(Exception e) {
//			System.err.println("Failed to connect to database");
//		}
//		return conn;
//	}
//    public static boolean registerUser(User user) {
//    	PreparedStatement stmt = null;
//        Connection conn = null;
//        String queryString = "INSERT INTO users(login, password, firstName, lastName, passport) VALUES(?, ?, ?, ?, ?)";
//
//        try {
//        	conn = getConnection();
//        	stmt = conn.prepareStatement(queryString);
//        	stmt.setString(1, user.getLogin());
//        	stmt.setString(2, user.getPassword());
//        	stmt.setString(3, user.getFirstName());
//        	stmt.setString(4, user.getLastName());
//        	stmt.setString(5, user.getPassport());
//        	stmt.executeUpdate();
//        } catch (SQLException e ) {
//            if (conn != null) {
//            	System.err.print("Error on inserting a new user.");
//            }
//            return false;
//        } finally {
//        	try {
//				if(conn != null)
//                	conn.close();
//            }
//			catch(SQLException e) {
//				System.err.println(e);
//			}
//        }
//    }
//
//    public static boolean addFlight(Flight flight) {
//        PreparedStatement stmt = null;
//        Connection conn = null;
//        String queryString = "INSERT INTO flights(flight, departure, arrival, departureTime, arrivalTime, seatsLeft, cost) VALUES(?, ?, ?, ?, ?, ?, ?)";
//
//        try {
//        	conn = getConnection();
//        	stmt = conn.prepareStatement(queryString);
//        	stmt.setString(1, flight.getFlightName());
//        	stmt.setString(2, flight.getDeparture());
//        	stmt.setString(3, flight.getArrival());
//        	stmt.setString(4, flight.getDepartureTime());
//        	stmt.setString(5, flight.getArrivalTime());
//        	stmt.setInt(6, flight.getFreePlaces());
//        	stmt.setInt(7, flight.getCost());
//        	stmt.executeUpdate();
//        } catch (SQLException e ) {
//            if (conn != null) {
//            	System.err.print("Error on inserting a new flight.");
//            }
//            return false;
//        } finally {
//        	try {
//				if(conn != null)
//                	conn.close();
//            }
//			catch(SQLException e) {
//				System.err.println(e);
//			}
//        }
//        return true;
//    }
//
//    public static ArrayList<Flight> getAllFlights() {
//    	Connection conn = null;
//    	ArrayList<Flight> results = new ArrayList<Flight>();
//    	try {
//    		String queryString = "SELECT * FROM flights";
//    		conn = getConnection();
//    		Statement stmt = conn.createStatement();
//    		stmt.setQueryTimeout(10);
//    		ResultSet flights = stmt.executeQuery(queryString);
//
//    		while (flights.next()) {
//    			Flight current = new Flight();
//    			current.setFlightName(flights.getString("flight"));
//    			current.setDeparture(flights.getString("departure"));
//    			current.setArrival(flights.getString("arrival"));
//    			current.setDepartureTime(new Date((long) flights.getInt("departureTime")*1000));
//    			current.setArrivalTime(new Date((long) flights.getInt("arrivalTime")*1000));
//    			current.setFreePlaces(flights.getInt("freePlaces"));
//    			current.setCost(flights.getInt("cost"));
//    			results.add(current);
//    		}
//    		flights.close();
//    		stmt.close();
//    	} catch (SQLException e) {
//			System.err.println("Problem accessing flights table");
//		} finally {
//			try {
//				if(conn != null)
//                	conn.close();
//            }
//			catch(SQLException e) {
//				System.err.println(e);
//			}
//		}
//    	return results;
//    }
//
//    public static User getUser(User user) throws InvalidLoginException, InvalidPasswordException {
//    	Connection conn;
//    	PreparedStatement stmt;
//    	User loggedUser = new User();
//    	String queryString = "SELECT * FROM users WHERE login=?";
//    	try {
//    		conn = getConnection();
//    		stmt = conn.prepareStatement(queryString);
//    		stmt.setString(1, user.getLogin());
//    		ResultSet res = stmt.executeQuery();
//    		if (!res.next()) {
//    			throw new InvalidLoginException();
//    		}
//    		loggedUser.setPassword(res.getString("password"));
//    		if (!User.getPassword().equals(user.getPassword())) {
//    			throw new InvalidPasswordException();
//    		}
//    		loggedUser.setLogin(res.getString("login"));
//    		loggedUser.setFirstName(res.getString("firstName"));
//    		loggedUser.setLastName(res.getString("lastName"));
//    		loggedUser.setPassport(res.getString("passport"));
//    		res.close();
//    		stmt.close();
//    	} catch (SQLException e) {
//			System.err.println("Problem getting user");
//		} finally {
//			try {
//				if(conn != null)
//                	conn.close();
//            }
//			catch(SQLException e) {
//				System.err.println(e);
//			}
//		}
//    	return loggedUser;
//    }
//
//    public static int getNumberOfCities() {
//    	ArrayList<Flight> allFlights = getAllFlights();
//    	HashSet<String> cities = new HashSet<String>();
//    	for (Flight flight : allFlights) {
//    		cities.add(flight.getDeparture());
//    		cities.add(flight.getArrival());
//    	}
//    	return cities.size();
//    }
//
//    public static ArrayList<Flight> getUserTickets(User passenger) {
//    	Connection conn;
//    	PreparedStatement stmt;
//    	ArrayList<Flight> tickets = new ArrayList<>();
//    	String queryString = "SELECT tickets.*, flights.* FROM tickets INNER JOIN flights ON tickets.flight=flights.flight WHERE tickets.passenger=?";
//    	try {
//    		conn = getConnection();
//    		stmt = conn.prepareStatement(queryString);
//    		stmt.setString(1, passenger.getLogin());
//    		ResultSet ticketsFound = stmt.executeQuery();
//    		while(ticketsFound.next()) {
//    			Flight current = new Flight();
//    			current.setFlightName(ticketsFound.getString("flight"));
//    			current.setDeparture(ticketsFound.getString("departure"));
//    			current.setArrival(ticketsFound.getString("arrival"));
//    			current.setDepartureTime(new Date((long) ticketsFound.getInt("departureTime")*1000));
//    			current.setArrivalTime(new Date((long) ticketsFound.getInt("arrivalTime")*1000));
//    			current.setFreePlaces(ticketsFound.getInt("freePlaces"));
//    			current.setCost(ticketsFound.getInt("cost"));
//    			tickets.add(current);
//    		}
//    	} catch (SQLException e) {
//    		System.err.println("Error trying to get user tickets");
//    	} finally {
//    		stmt.close();
//    		try {
//				if(conn != null)
//                	conn.close();
//            }
//			catch(SQLException e) {
//				System.err.println(e);
//			}
//    	}
//    	return tickets;
//    }
//
//    public static void addTicketToUser(User user, Flight flight) throws SQLException {
//    	Connection conn;
//    	PreparedStatement stmt;
//    	String queryString = "INSERT INTO tickets (passenger, flight) VALUES(?, ?)";
//    	conn = getConnection();
//    	stmt = conn.prepareStatement(queryString);
//		stmt.setString(1, user.getLogin());
//    	stmt.setString(2, flight.getFlightName());
// 		stmt.executeUpdate();
// 		stmt.close();
//		try {
//			if(conn != null)
//            	conn.close();
//        }
//		catch(SQLException e) {
//			System.err.println(e);
//		}
//    }
//
//}

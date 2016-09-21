//package com.db;
//
//import com.entities.Flight;
//import com.entities.User;
//import com.exceptions.InvalidLoginException;
//import com.exceptions.InvalidPasswordException;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.HashSet;
//public class Database {
//
//	public void initDatabase() {
//		Connection conn = getConnection();
//		String tableUser = "CREATE TABLE users (login STRING PRIMARY KEY, password STRING, firstName STRING, lastName STRING, passport STRING)";
//		String tableFlights = "CREATE TABLE flights (flight STRING PRIMARY KEY, departure STRING, arrival STRING, departureTime STRING, arrivalTime STRING, seatsLeft INTEGER, cost INTEGER)";
//		String tableTickets = "CREATE TABLE tickets (passenger STRING FOREIGN KEY, flight STRING FOREIGN KEY)";
//		try {
//			Statement stmt = conn.createStatement();
//			stmt.setQueryTimeout(10);
//			stmt.execute(tableUser);
//			stmt.execute(tableFlights);
//			stmt.execute(tableTickets);
//		} catch (SQLException e) {
//			System.err.println("Problem creating database tables");
//		} finally {
//			try {
//				if(conn != null)
//					conn.close();
//			}
//			catch(SQLException e) {
//				System.err.println(e);
//			}
//		}
//	}
//
//	private Connection getConnection() {
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
//        return true; //?????
//    }
//
//		} catch(Exception e) {
//			System.err.println("Failed to connect to database");
//		}
//		return conn;
//	}
//
//	public boolean registerUser(User user) {
//		PreparedStatement stmt = null;
//		Connection conn = null;
//		String queryString = "INSERT INTO users(login, password, firstName, lastName, passport) VALUES(?, ?, ?, ?, ?)";
//
//		try {
//			conn = getConnection();
//			stmt = conn.prepareStatement(queryString);
//			stmt.setString(1, user.getLogin());
//			stmt.setString(2, user.getPassword());
//			stmt.setString(3, user.getFirstName());
//			stmt.setString(4, user.getLastName());
//			stmt.setString(5, user.getPassport());
//			stmt.executeUpdate();
//		} catch (SQLException e ) {
//			if (conn != null) {
//				System.err.print("Error on inserting a new user.");
//			}
//			return false;
//		} finally {
//			try {
//				if(conn != null)
//					conn.close();
//			}
//			catch(SQLException e) {
//				System.err.println(e);
//			}
//		}
//
//		return true;
//	}
//
////	public boolean addFlight(Flight flight) {
////		PreparedStatement stmt = null;
////		Connection conn = null;
////		String queryString = "INSERT INTO flights(flight, departure, arrival, departureTime, arrivalTime, seatsLeft, cost) VALUES(?, ?, ?, ?, ?, ?, ?)";
////
////		try {
////			conn = getConnection();
////			stmt = conn.prepareStatement(queryString);
////			stmt.setString(1, flight.getFlight());
////			stmt.setString(2, flight.getDeparture());
////			stmt.setString(3, flight.getArrival());
////			stmt.setDate(4, flight.getDepartureTime());
////			stmt.setDate(5, flight.getArrivalTime());
////			stmt.setInt(6, flight.getSeatsLeft());
////			stmt.setInt(7, flight.getCost());
////			stmt.executeUpdate();
////		} catch (SQLException e ) {
////			if (conn != null) {
////				System.err.print("Error on inserting a new flight.");
////			}
////			return false;
////		} finally {
////			try {
////				if(conn != null)
////					conn.close();
////			}
////			catch(SQLException e) {
////				System.err.println(e);
////			}
////		}
////		return true;
////	}
//
//	public User getUser(User user) throws InvalidLoginException, InvalidPasswordException {
//		return null;
//	}
//
////	public Flight getFlight(String flightName, Date departureDateTime) {
////
////		//TODO ниже тестовый функционал
//////        SimpleDateFormat inputFormatDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
////		Date arrivalDateTime;
//////        , departureDateTime = null;
//////        try {
//////            departureDateTime = inputFormatDateTime.parse("2016-07-19T03:33:24+04:00");
//////        } catch (ParseException e) {
//////            e.printStackTrace();
//////        }
////		int distance = 837, freePlaces = 10, cost = 1394;
////		int tripClass = 0, numberOfChanges = 0;
////
////		Calendar calendar = Calendar.getInstance();
////		calendar.setTime(departureDateTime);
////		calendar.add(Calendar.SECOND, (distance * 6)); // 3600/600=6
////		arrivalDateTime = calendar.getTime();
////
////		Flight flight = new Flight(flightName, "RIX", "OSL", departureDateTime, arrivalDateTime,
////				cost, freePlaces, distance, tripClass, numberOfChanges);
////		//TODO выше тестовый функционал
////
////		return flight;
////	}
//}

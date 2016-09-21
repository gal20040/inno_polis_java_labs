//package com.db;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Random;
//
//import com.entities.Flight;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//public class ParserFromFile {
//    public static void main(String[] args) {
//
//        //Airports info
//        String filePath = ".\\src\\main\\java\\com\\db\\airports.json";
//        System.out.println("Airports data parsing results");
//        System.out.println("-----------------------------");
//        parseAirportsData(filePath);
//        System.out.println();
//
//        //Flights data
//        filePath = ".\\src\\main\\java\\com\\db\\dataForParsing.json";
//        System.out.println("Data parsing results");
//        System.out.println("--------------------");
//        parseFlightsData(filePath);
//    }
//
//
//    private static JSONObject preParse(String filePath) {
//        /*
//         * Prepare input file for parsing
//         * API documentation:
//		 * https://support.travelpayouts.com/hc/ru/articles/203956163
//		 *
//		 * Example:
//		 * http://api.travelpayouts.com/v2/prices/latest?currency=rub&period_type=year&page=1&limit=30&show_to_affiliates=true&sorting=price&trip_class=0&token=d5116d5cd0bd2ef9099ace2d7e13ba7c
//         */
//
//        FileReader jsonFile = null;
//        try {
//            jsonFile = new FileReader(filePath);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        JSONParser parser = new JSONParser();
//
//        Object obj = null;
//        try {
//            obj = parser.parse(jsonFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return (JSONObject) obj;
//    }
//
//    public static ArrayList<Flight> parseFlightsData(String filePath) {
//        JSONObject jsonObjectMain = preParse(filePath);
//        final Random random = new Random();
//        ArrayList<Flight> flightList = new ArrayList<Flight>();
//
//        /*
//         * Documentation: https://support.travelpayouts.com/hc/ru/articles/203956163 in chapter "Цены на авиабилеты"
//         * API: http://api.travelpayouts.com/v2/prices/latest?currency=rub&period_type=year&page=1&limit=999&show_to_affiliates=true&sorting=price&token=d5116d5cd0bd2ef9099ace2d7e13ba7c
//         */
//        if (jsonObjectMain.get("success") != null)
//            if ((jsonObjectMain.get("success") + "").equals("true")) {
//                // success=true - It takes true for successful request and false otherwise
//
//                JSONArray jsonArray = (JSONArray) jsonObjectMain.get("data");
//                JSONObject jsonArrayData;
//                SimpleDateFormat inputFormatDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
//                SimpleDateFormat simpleFormatDateTime = new SimpleDateFormat("yyyy-MM-dd");
//                Date departureDateTime = null, arrivalDateTime;
//
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    jsonArrayData = (JSONObject) jsonArray.get(i);
//
//                    if (jsonArrayData.get("actual") != null) {
//                        if ((jsonArrayData.get("actual") + "").equals("true")) {
//                            // actual=true - It takes true if offer is relevant and false otherwise
//
//                            String departure = (String) jsonArrayData.get("origin");
//                            String arrival = (String) jsonArrayData.get("destination");
//
//                            if (checkLocation(departure, null) instanceof String
//                                    && checkLocation(arrival, null) instanceof String) {
//
//                                Object dataFromFile;
//                                dataFromFile = jsonArrayData.get("distance");
//                                int distance = toInt(dataFromFile);
//
//                                // found_at - actually it's time and date, when the ticket was found
//                                // but in that project we use it as departure date and time
//                                String stringDepartureDateTime = (String) jsonArrayData.get("found_at");
//
//                                try {
//                                    departureDateTime = inputFormatDateTime.parse(stringDepartureDateTime);
//                                } catch (java.text.ParseException e) {
//
//                                    // "2000-01-01" - it's a dummy
//                                    stringDepartureDateTime = "2000-01-01";
//                                    try {
//                                        departureDateTime = simpleFormatDateTime.parse(stringDepartureDateTime);
//                                    } catch (java.text.ParseException e1) {
//                                        e1.printStackTrace();
//                                    }
//
//                                    e.printStackTrace();
//                                }
//
//                                // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
//                                // LocalDate date = LocalDate.parse("2005-nov-12", formatter);
//
//                                // DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("yyyy-MMM-dd");
//                                // DateTime dateTime = FORMATTER.parseDateTime("2005-nov-12");
//                                // LocalDate localDate = dateTime.toLocalDate();
//
//                                Calendar calendar = Calendar.getInstance();
//                                calendar.setTime(departureDateTime);
//                                /*suggest that airplain velocity is 600km/h
//                                 *based on this we can calculate arrivalDateTime
//                                 *it's hardcoded for this project only*/
//                                calendar.add(Calendar.SECOND, (distance * 6)); // 3600/600=6
//                                arrivalDateTime = calendar.getTime();
//
//                                dataFromFile = jsonArrayData.get("value");
//                                int cost = toInt(dataFromFile);
//
////                                dataFromFile = jsonArrayData.get("trip_class");
////                                int tripClass = toInt(dataFromFile);
//
////                                dataFromFile = jsonArrayData.get("number_of_changes");
////                                int numberOfChanges = toInt(dataFromFile);
//
//                                //now API doesn't give quantity of free tickets, that's why it's hardcoded
//                                int freePlaces = random.nextInt(100) + 100;
////                                freePlaces = 10; //TODO it's only for testing purposes
//
//                                //now API doesn't give flight name, that's why it's random formed
//                                String flightName = "" + random.nextInt(10) + random.nextInt(10)
//                                        + (char) (random.nextInt(26)+65) + (char) (random.nextInt(26)+65)
//                                        + random.nextInt(10) + random.nextInt(10);
////                                flightName = "testName"; //TODO it's only for testing purposes
//
//                                com.entities.Flight flight = new com.entities.Flight(flightName, departure, arrival,
//                                        departureDateTime, arrivalDateTime, cost, freePlaces);
//
//                                flightList.add(flight);
//                            }
//                        }
//                    }
//                }
//            } else if (jsonObjectMain.get("error") != null)
//                System.out.println("Error = " + jsonObjectMain.get("error"));
//
//        return flightList;
//    }
//
//    //    @Deprecated
//    public static int toInt(Object obj) {
//        /*
//        Converts data from input file. Data might to be Long.
//         */
//        if (obj instanceof String)
//            return Integer.parseInt((String) obj);
//        else if (obj instanceof Integer)
//            return ((Integer) obj).intValue();
//        else {
//            String toString = obj.toString();
//            if (toString.matches("-?\\d+"))
//                return Integer.parseInt(toString);
//
//            throw new IllegalArgumentException("This Object doesn't represent an int");
//        }
//    }
//
//    public static Object checkLocation(String locationCode, String locationName) {
//        //!!!!!!!!!!!!Attention!!! locationName - it's unnecessery parameter that's why it might be null!!!!!!!!!!!!!
//
//        Object returnStatement;
//
////        if (locationCode.equals("locationOK") || locationCode.equals("LOCATIONOK"))
//        if (true) {
//            //TODO make searching for departure and arrival location in DB
//            //TODO if the location doesn't exist in DB then create it there
//            returnStatement = "locationOKName";
//        } else
//            returnStatement = false;
//
//        return returnStatement; //return "locationName" if the location exists in DB or its creation was successful
//    }
//
////    public static void parseAirlinesData(JSONObject jsonObjectMain) {
////        // TODO for future realisation
////    }
//
////    public static void parseCitiesData(JSONObject jsonObjectMain) {
////        // TODO for future realisation
////    }
//
//    public static void parseAirportsData(String filePath) {
//        JSONObject jsonObjectMain = preParse(filePath);
//
//        /*
//         * Documentation: https://support.travelpayouts.com/hc/ru/articles/203956163
//         * in chapter "Данные об аэропортах в json формате"
//         *
//         * API: http://api.travelpayouts.com/data/airports.json
//         */
//
//        JSONArray jsonArray = (JSONArray) jsonObjectMain.get("data");
//        JSONObject jsonArrayData;
//        String locationCode;
//        String locationName;
//
//        for (int i = 0; i < jsonArray.size(); i++) {
//            jsonArrayData = (JSONObject) jsonArray.get(i);
//
//            locationCode = (String) jsonArrayData.get("code");
//            locationName = (String) jsonArrayData.get("name");
//
////            addLocationToDB(locationCode, locationName); //TODO если надо, то сделать
//
//            System.out.println("locationCode: " + locationCode + " locationName: " + locationName);
//
//            checkLocation(locationCode, locationName);
//        }
//    }
//
////    private static void addLocationToDB(String locationCode, String locationName) {
////        /*The method checks in DB existence of location with received information
////         *If there is no such location than let's add it!*/
////        //TODO реализовать
////    }
//}
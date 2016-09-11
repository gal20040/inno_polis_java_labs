//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Date;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
////import org.json.simple.parser.ParseException;
//
//public class ParserFromFile {
//
//	public static boolean readFile(String input, ArrayList arrayList) {
//		//http://goloburdin.blogspot.ru/2011/03/json-java.html
//        //https://www.mkyong.com/java/json-simple-example-read-and-write-json/
//        //http://www.tutorialspoint.com/json/json_java_example.htm
//        //https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
//
//		// Reads data from file and creates new flights
//
//		// API documentation:
//		// https://support.travelpayouts.com/hc/ru/articles/203956163
//		// Example:
//		// http://api.travelpayouts.com/v2/prices/latest?currency=rub&period_type=year&page=1&limit=30&show_to_affiliates=true&sorting=price&trip_class=0&token=d5116d5cd0bd2ef9099ace2d7e13ba7c
//
//		FileReader json = null;
//		try {
//			json = new FileReader(".\\src\\main\\java\\db\\dataForParsing.json");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		JSONParser parser = new JSONParser();
//
//		Object obj = null;
//		try {
//			obj = parser.parse(json);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		JSONObject jsonObjectMain = (JSONObject) obj;
//
//		if (jsonObjectMain.get("success") != null)
//			if ((jsonObjectMain.get("success") + "").equals("true")) {
//				// success=true Ч It takes true for successful request and false otherwise
//
//				JSONArray jsonArray = (JSONArray) jsonObjectMain.get("data");
//				JSONObject jsonArrayData;
////				SimpleDateFormat inputFormatDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
//				SimpleDateFormat inputFormatDateTime = new SimpleDateFormat("yyyy-MM-dd"); //TODO переделать на первый формат
////				SimpleDateFormat outputFormatDateTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ssXXX");
//				Date departureDateTime = null, arrivalDateTime = null;
//
//				for (int i = 0; i < jsonArray.size(); i++) {
//					jsonArrayData = (JSONObject) jsonArray.get(i);
//
//					if (jsonArrayData.get("actual") != null)
//						if ((jsonArrayData.get("actual") + "").equals("true")) {
//							// actual=true Ч It takes true if offer is relevant and false otherwise
//
//							String flightName = "sadasdasd12"; //TODO find flightName somewhere
//							String departure = (String) jsonArrayData.get("origin");
//							String arrival = (String) jsonArrayData.get("destination");
//
//							String stringDepartureDateTime = (String) jsonArrayData.get("depart_date");
//							try {
//								departureDateTime = inputFormatDateTime.parse(stringDepartureDateTime);
////								departureTime = outputFormatDateTime.format(inputFormatDateTime.parse(departureTime));
//								// TODO найти способ конвертировать в Date тип в нужном формате outputFormatDateTime
//							} catch (java.text.ParseException e) {
//								e.printStackTrace();
//							}
//
//							String stringArrivalDateTime = (String) jsonArrayData.get("return_date");
//							try {
//								arrivalDateTime = inputFormatDateTime.parse(stringArrivalDateTime);
////								arrivalTime = outputFormatDateTime.format(inputFormatDateTime.parse(stringArrivalDateTime));
//								// TODO найти способ конвертировать в Date тип в нужном формате outputFormatDateTime
//							} catch (java.text.ParseException e) {
//								e.printStackTrace();
//							}
//
//							Object cost = jsonArrayData.get("value"); //TODO найти способ конвертировать Long в int
//							// int freePlaces = Integer.parseInt((String)
//							// jsonArrayData.get("origin"));
//
//							// int distance = Integer.parseInt((String)
//							// jsonArrayData.get("distance")); //TODO найти способ конвертировать Long в int
//							Object distance = jsonArrayData.get("distance");
//
//							// int tripClass = Integer.parseInt((String)
//							// jsonArrayData.get("trip_class")); //TODO найти способ конвертировать Long в int
//							Object tripClass = jsonArrayData.get("trip_class");
//
//							// int numberOfChanges = Integer.parseInt((String)
//							// jsonArrayData.get("number_of_changes")); //TODO найти способ конвертировать Long в int
//							Object numberOfChanges = jsonArrayData.get("number_of_changes");
//
//							Flight flight = new Flight(flightName, departure, arrival, departureDateTime, arrivalDateTime, cost,
//									/* freePlaces, */distance, tripClass, numberOfChanges);
//							arrayList.add(flight);
//						}
//				}
//			} else if (jsonObjectMain.get("error") != null)
//				System.out.println("Error = " + jsonObjectMain.get("error"));
//
//		return false;
//	}
//}
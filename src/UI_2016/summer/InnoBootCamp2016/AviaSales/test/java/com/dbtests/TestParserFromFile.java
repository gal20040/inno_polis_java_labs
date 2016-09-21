//package com.dbtests;
//
//import com.entities.Flight;
//import org.json.simple.JSONObject;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import static com.db.ParserFromFile.parseFlightsData;
//import static org.junit.Assert.*;
//
//public class TestParserFromFile {
//
////    @Before
////    public void setUp() throws Exception {
////
////    }
////
////    @After
////    public void tearDown() throws Exception {
////
////    }
//
//    @Test
//    public void checkingValidData() throws Exception {
//        String testFilePath = ".\\src\\test\\java\\testFiles\\dataForParsing.json";
//        Database db = new Database();
//
//        SimpleDateFormat inputFormatDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
//        Date arrivalDateTime, departureDateTime = inputFormatDateTime.parse("2016-07-19T03:33:24+04:00");
//        int distance = 837, freePlaces = 10, cost = 1394;
//        int tripClass = 0, numberOfChanges = 0;
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(departureDateTime);
//        calendar.add(Calendar.SECOND, (distance * 6)); // 3600/600=6
//        arrivalDateTime = calendar.getTime();
//
//        Flight expectedFlight = new Flight("testName", "RIX", "OSL", departureDateTime, arrivalDateTime,
//                cost, freePlaces);
//        Flight actualFlight = db.getFlight(expectedFlight.getFlight(), expectedFlight.getDepartureTime());
//
//        parseFlightsData(testFilePath);
//
//        assertEquals(expectedFlight.getFlight(), actualFlight.getFlight());
//        assertEquals(expectedFlight.getDeparture(), actualFlight.getDeparture());
//        assertEquals(expectedFlight.getArrival(), actualFlight.getArrival());
//        assertEquals(expectedFlight.getDepartureTime(), actualFlight.getDepartureTime());
//        assertEquals(expectedFlight.getArrivalTime(), actualFlight.getArrivalTime());
//        assertEquals(expectedFlight.getCost(), actualFlight.getCost());
//    }
//}
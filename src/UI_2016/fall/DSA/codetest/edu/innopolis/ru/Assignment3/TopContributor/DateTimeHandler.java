package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.TopContributor;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateTimeHandler {
    private static SimpleDateFormat format;
    private final int rate = 1000 * 60; //1000 milliseconds in 1 second and 60 seconds in 1 minute

    /**
     * Constructs instance with default date-time format.
     */
    DateTimeHandler() {
        format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    }

    /**
     * Constructs instance with assigned date-time format.
     */
    DateTimeHandler(String dateFormat) {
        format = new SimpleDateFormat(dateFormat);
    }

    /**
     * Parses <currentString> from <beginPosition> till <endPosition> with pattern defined in class constructor.
     * Returns time stamp in minutes.
     */
    long getTimeStampInMinutes(String currentString, int beginPosition, int endPosition) {
        Date dateBegin = format.parse(currentString.substring(beginPosition, endPosition), new ParsePosition(0));
        return dateBegin.getTime() / rate;
    }

    /**
     * This method doesn't require parameter <int endPosition> - it parses <currentString> from <beginPosition> till the end.
     * Full description is in method <getTimeStampInMinutes(String currentString, int beginPosition, int endPosition)>.
     */
    long getTimeStampInMinutes(String currentString, int beginPosition) {
        return getTimeStampInMinutes(currentString, beginPosition, currentString.length());
    }

    String getFormattedDate(long timeStampInMinutes) {
        Date date = new Date(timeStampInMinutes * rate);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return format.format(date);
    }
}
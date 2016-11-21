package UI_2016.fall.ItP.UniversityInformationSystem;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHandler {
    private static SimpleDateFormat format;

    /**
     * Construct instance with default date-time format.
     */
    public DateTimeHandler() {
        format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    }

    /**
     * Construct instance with assigned date-time format.
     */
    public DateTimeHandler(String dateFormat) {
        /** This format lets to keep only hours and minutes.
         * Exact moment will be = 1970-01-01T+exact amount of hours and minutes.
         * For example input time "10:30" will be processed as 1970-01-01T10:30:00
         *
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date dateIn = format.parse("10:30", new ParsePosition(0));
        System.out.println(dateIn.getTime()); //27000000 - it is milliseconds from the begin of unix epoch
        Date dateOut = new Date(dateIn.getTime());
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(format2.format(dateOut)); //1970-01-01T10:30:00*/

        format = new SimpleDateFormat(dateFormat);
    }

    /**
     * Process input time string and return time stamp in milliseconds.
     */
    public long parseInputTimeString(String inputTimeString) {
        Date dateTime = format.parse(inputTimeString, new ParsePosition(0));
        return dateTime.getTime();
    }

    public String getFormattedTime(long timeStamp) {
        Date date = new Date(timeStamp);
        return format.format(date);
    }
}
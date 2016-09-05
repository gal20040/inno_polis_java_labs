package ItP.UniversityInformationSystem.enums;

/**
 * List of names of days in week.
 */
public enum DayOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String text;

    DayOfWeek(final String text) {this.text = text;}

    @Override
    public String toString() {return text;}
}
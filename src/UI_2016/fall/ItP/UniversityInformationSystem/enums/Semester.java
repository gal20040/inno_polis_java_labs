package UI_2016.fall.ItP.UniversityInformationSystem.enums;

public enum Semester {
    AUTUMN2015("autumn of 2015"),
    SPRING2016("spring of 2016"),
    AUTUMN2016("autumn of 2016"),
    SPRING2017("spring of 2017");

    private final String text;

    Semester(final String text) {this.text = text;}

    @Override
    public String toString() {return text;}
}
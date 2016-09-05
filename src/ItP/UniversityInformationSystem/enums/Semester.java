package ItP.UniversityInformationSystem.enums;

public enum Semester {
    AUTUMN("autumn"),
    SPRING("spring");

    private final String text;

    Semester(final String text) {this.text = text;}

    @Override
    public String toString() {return text;}
}
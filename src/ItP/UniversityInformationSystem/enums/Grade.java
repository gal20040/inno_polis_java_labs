package ItP.UniversityInformationSystem.enums;

/**
 * List of grades.
 */
public enum Grade {
    A("A"), B("B"), C("C"), D("D");

    private final String text;

    Grade(final String text) {this.text = text;}

    @Override
    public String toString() {return text;}
}
package UI_2016.fall.ItP.UniversityInformationSystem.enums;

/**
 * List of genders.
 */
public enum Gender {
    FEMALE("Female"),
    MALE("Male");

    private final String text;

    Gender(final String text) {this.text = text;}

    @Override
    public String toString() {return text;}
}
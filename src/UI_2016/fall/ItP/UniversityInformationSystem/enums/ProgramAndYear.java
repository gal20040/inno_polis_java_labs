package UI_2016.fall.ItP.UniversityInformationSystem.enums;

/**
 * List of programs with year of education.
 */
public enum ProgramAndYear {
    BS3("BS3"),
    MSIT_SE("MSIT-SE");

    private final String text;

    ProgramAndYear(final String text) {this.text = text;}

    @Override
    public String toString() {return text;}
}
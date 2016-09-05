package ItP.UniversityInformationSystem.enums;

/**
 * List of programs with year of education.
 */
public enum ProgramAndYear {
    BS1("BS1"),
    BS2("BS2"),
    BS3("BS3"),
    BS4("BS4"),
    MS1("MS1"),
    MSIT_SE("MSIT-SE"),
    MS_DS("MS-DS"),
    MS_R("MS-R");

    private final String text;

    ProgramAndYear(final String text) {this.text = text;}

    @Override
    public String toString() {return text;}
}
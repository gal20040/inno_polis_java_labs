package UI_2016.fall.ItP.UniversityInformationSystem.persons;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.Gender;

public class Assistant extends Person {
    private final static String personIDPrefix = "A_";
    private final static String personType = "Assistant";

    public Assistant(String firstName, String lastName, Gender gender) {
        super(firstName, lastName, gender, personIDPrefix);
    }
}
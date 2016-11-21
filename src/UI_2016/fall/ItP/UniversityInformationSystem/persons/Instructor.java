package UI_2016.fall.ItP.UniversityInformationSystem.persons;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.Gender;

public class Instructor extends Person {
    private final static String personIDPrefix = "I_";
    private final static String personType = "Instructor";

    public Instructor(String firstName, String lastName, Gender gender) {
        super(firstName, lastName, gender, personIDPrefix);
    }
}
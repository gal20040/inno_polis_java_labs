package UI_2016.fall.ItP.UniversityInformationSystem.persons;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.Gender;

public class Assistant extends Person {
    private static String personIDPrefix = "A_";

    public Assistant(String firstName, String lastName, Gender gender, int personID) {
        super(firstName, lastName, gender, personIDPrefix + personID);
    }

    public void setPersonID(int personID) {super.setPersonID(personIDPrefix + personID);}
}
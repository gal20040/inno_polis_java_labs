package ItP.UniversityInformationSystem.persons;

import ItP.UniversityInformationSystem.enums.Gender;

public class Instructor extends Person {
    private static String personIDPrefix = "I_";

    public Instructor(String firstName, String lastName, Gender gender, int personID) {
        super(firstName, lastName, gender, personIDPrefix + personID);
    }

    public void setPersonID(int personID) {super.setPersonID(personIDPrefix + personID);}
}
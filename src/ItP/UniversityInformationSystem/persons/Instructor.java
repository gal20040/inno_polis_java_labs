package ItP.UniversityInformationSystem.persons;

import ItP.UniversityInformationSystem.enums.Gender;

public class Instructor extends Person {
    public Instructor(String firstName, String lastName, Gender gender, int personID) {
        super(firstName, lastName, gender, personID);
    }
}
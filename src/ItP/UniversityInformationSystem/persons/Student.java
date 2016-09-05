package ItP.UniversityInformationSystem.persons;

import ItP.UniversityInformationSystem.enums.Gender;
import ItP.UniversityInformationSystem.enums.Grade;
import ItP.UniversityInformationSystem.enums.ProgramAndYear;

public class Student extends Person {
    private ProgramAndYear programAndYear;
    private Grade listOfGrades;

    public Student(String firstName, String lastName, Gender gender, ProgramAndYear programAndYear) {
        super(firstName, lastName, gender);
        this.programAndYear = programAndYear;
    }

    public ProgramAndYear   getProgramAndYear() {return programAndYear;}
    public Grade            getListOfGrades() {return listOfGrades;}
}
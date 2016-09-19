package UI_2016.fall.ItP.UniversityInformationSystem.persons;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.Gender;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.Grade;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.ProgramAndYear;

public class Student extends Person {
    private ProgramAndYear programAndYear;
    private Grade listOfGrades;
    private static String personIDPrefix = "S_";

    public Student(String firstName, String lastName, Gender gender, int personID, ProgramAndYear programAndYear) {
        super(firstName, lastName, gender, personIDPrefix + personID);
        this.programAndYear = programAndYear;
    }

    public ProgramAndYear   getProgramAndYear() {return programAndYear;}
    public Grade            getListOfGrades() {return listOfGrades;}

    public void setProgramAndYear(ProgramAndYear programAndYear) {this.programAndYear = programAndYear;}
    public void setListOfGrades(Grade listOfGrades) {this.listOfGrades = listOfGrades;}

    public void setPersonID(int personID) {super.setPersonID(personIDPrefix + personID);}
}
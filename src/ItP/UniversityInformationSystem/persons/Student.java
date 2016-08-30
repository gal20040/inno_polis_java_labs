package ItP.UniversityInformationSystem.persons;

import ItP.UniversityInformationSystem.LectureCourse;
import ItP.UniversityInformationSystem.enums.Gender;
import ItP.UniversityInformationSystem.enums.Grade;
import ItP.UniversityInformationSystem.enums.ProgramAndYear;

public class Student {
    private String firstName, lastName;
    private Gender gender;
    private ProgramAndYear programAndYear;
    private LectureCourse listOfLectures;
    private Grade listOfGrades;

    public Student(String firstName, String lastName, Gender gender, ProgramAndYear programAndYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.programAndYear = programAndYear;
    }

    public String           getFirstName() {return firstName;}
    public String           getLastName() {return lastName;}
    public Gender           getGender() {return gender;}
    public ProgramAndYear   getProgramAndYear() {return programAndYear;}
    public LectureCourse    getListOfLectures() {return listOfLectures;}
    public Grade            getListOfGrades() {return listOfGrades;}
}
package ItP.UniversityInformationSystem.persons;

import ItP.UniversityInformationSystem.LectureCourse;
import ItP.UniversityInformationSystem.enums.Gender;
import ItP.UniversityInformationSystem.enums.Grade;
import ItP.UniversityInformationSystem.enums.ProgramAndYear;

/**
 * Class for students.
 */
public class Student {
    String firstName, secondName;
    Gender gender;
    ProgramAndYear programAndYear;
    LectureCourse listOfLectures;
    Grade listOfGrades;
}
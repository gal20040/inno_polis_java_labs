package UI_2016.fall.ItP.UniversityInformationSystem;


import UI_2016.fall.ItP.UniversityInformationSystem.enums.CoreElective;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.ProgramAndYear;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Assistant;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Instructor;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Student;

import java.util.ArrayList;

public class LectureCourse {
    private String title;
    private ProgramAndYear programAndYear;
    private ArrayList<Student>      listOfStudentsInCourse = new ArrayList<>();
    private ArrayList<Instructor>   listOfInstructorsInCourse = new ArrayList<>();
    private ArrayList<Assistant>    listOfAssistantsInCourse = new ArrayList<>();
    private CoreElective coreElective;

    LectureCourse(String title, ProgramAndYear programAndYear, CoreElective coreElective) {
        this.title = title;
        this.programAndYear = programAndYear;
        this.coreElective = coreElective;
    }

    String                   getTitle() {return title;}
    ProgramAndYear           getProgramAndYear() {return programAndYear;}
    ArrayList<Student>       getListOfStudentsInCourse() {return listOfStudentsInCourse;}
    ArrayList<Instructor>    getListOfInstructorsInCourse() {return listOfInstructorsInCourse;}
    ArrayList<Assistant>     getListOfAssistantsInCourse() {return listOfAssistantsInCourse;}
    CoreElective             getCoreElective() {return coreElective;}
}
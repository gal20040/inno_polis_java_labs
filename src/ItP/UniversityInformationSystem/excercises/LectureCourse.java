package ItP.UniversityInformationSystem.excercises;

import ItP.UniversityInformationSystem.enums.CoreElective;
import ItP.UniversityInformationSystem.enums.ProgramAndYear;
import ItP.UniversityInformationSystem.enums.Semester;
import ItP.UniversityInformationSystem.persons.Assistant;
import ItP.UniversityInformationSystem.persons.Instructor;
import ItP.UniversityInformationSystem.persons.Student;

import java.util.ArrayList;

public class LectureCourse {
    private String title;
    private ProgramAndYear programAndYear;
    private CoreElective coreElective;
    private Semester semester;

    private ArrayList<Student>      listOfStudentsInCourse = new ArrayList<>();
    private ArrayList<Instructor>   listOfInstructorsInCourse = new ArrayList<>();
    private ArrayList<Assistant>    listOfAssistantsInCourse = new ArrayList<>();

    public LectureCourse(String title, ProgramAndYear programAndYear, CoreElective coreElective, Semester semester) {
        this.title = title;
        this.programAndYear = programAndYear;
        this.coreElective = coreElective;
        this.semester = semester;
    }

    public String                   getTitle() {return title;}
    public ProgramAndYear           getProgramAndYear() {return programAndYear;}
    public ArrayList<Student>       getListOfStudentsInCourse() {return listOfStudentsInCourse;}
    public ArrayList<Instructor>    getListOfInstructorsInCourse() {return listOfInstructorsInCourse;}
    public ArrayList<Assistant>     getListOfAssistantsInCourse() {return listOfAssistantsInCourse;}
    public CoreElective             getCoreElective() {return coreElective;}
    public Semester                 getSemester() {return semester;}
}
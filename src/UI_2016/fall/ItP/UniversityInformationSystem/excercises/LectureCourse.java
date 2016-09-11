package UI_2016.fall.ItP.UniversityInformationSystem.excercises;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.CoreElective;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.ProgramAndYear;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.Semester;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Assistant;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Instructor;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Student;

import java.util.ArrayList;

public class LectureCourse {
    private String lectureCourseID;
    private static String personIDPrefix = "L_";
    private String title;
    private ProgramAndYear programAndYear;
    private CoreElective coreElective;
    private Semester semester;

    private ArrayList<Student>      listOfStudentsInCourse = new ArrayList<>();
    private ArrayList<Instructor>   listOfInstructorsInCourse = new ArrayList<>();
    private ArrayList<Assistant>    listOfAssistantsInCourse = new ArrayList<>();

    public LectureCourse(int lectureCourseID, String title, ProgramAndYear programAndYear,
                         CoreElective coreElective, Semester semester) {
        this.lectureCourseID = personIDPrefix + lectureCourseID;
        this.title = title;
        this.programAndYear = programAndYear;
        this.coreElective = coreElective;
        this.semester = semester;
    }

    public String                   getLectureCourseID() {return lectureCourseID;}
    public String                   getTitle() {return title;}
    public ProgramAndYear           getProgramAndYear() {return programAndYear;}
    public ArrayList<Student>       getListOfStudentsInCourse() {return listOfStudentsInCourse;}
    public ArrayList<Instructor>    getListOfInstructorsInCourse() {return listOfInstructorsInCourse;}
    public ArrayList<Assistant>     getListOfAssistantsInCourse() {return listOfAssistantsInCourse;}
    public CoreElective             getCoreElective() {return coreElective;}
    public Semester                 getSemester() {return semester;}
}
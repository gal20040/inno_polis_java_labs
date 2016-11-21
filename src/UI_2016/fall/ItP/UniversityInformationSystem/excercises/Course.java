package UI_2016.fall.ItP.UniversityInformationSystem.excercises;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.CoreElective;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.ProgramAndYear;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.Semester;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Assistant;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Instructor;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Student;

import java.util.ArrayList;
import java.util.Random;

public class Course {
    private String courseID;
    private final static String personIDPrefix = "L_";
    private final static int IDcapacity = 99999;
    private String title;
    private ProgramAndYear programAndYear;
    private CoreElective coreElective;
    private Semester semester;

    private ArrayList<Student>      listOfStudentsInCourse = new ArrayList<>();
    private ArrayList<Instructor>   listOfInstructorsInCourse = new ArrayList<>();
    private ArrayList<Assistant>    listOfAssistantsInCourse = new ArrayList<>();

    public Course(String title, ProgramAndYear programAndYear,
                  CoreElective coreElective, Semester semester) {
        Random random = new Random();
        this.courseID = personIDPrefix + random.nextInt(IDcapacity);
        this.title = title;
        this.programAndYear = programAndYear;
        this.coreElective = coreElective;
        this.semester = semester;
    }

    public String                   getCourseID() {return courseID;}
    public String                   getTitle() {return title;}
    public ProgramAndYear           getProgramAndYear() {return programAndYear;}
    public ArrayList<Student>       getListOfStudentsInCourse() {return listOfStudentsInCourse;}
    public ArrayList<Instructor>    getListOfInstructorsInCourse() {return listOfInstructorsInCourse;}
    public ArrayList<Assistant>     getListOfAssistantsInCourse() {return listOfAssistantsInCourse;}
    public CoreElective             getCoreElective() {return coreElective;}
    public Semester                 getSemester() {return semester;}

    public void setTitle(String title) {this.title = title;}
    public void setCoreElective(CoreElective coreElective) {this.coreElective = coreElective;}

    public Course getCopy() {
        return new Course(this.title, this.programAndYear,
                this.coreElective, this.semester);
    }
}
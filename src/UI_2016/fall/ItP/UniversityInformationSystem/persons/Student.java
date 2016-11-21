package UI_2016.fall.ItP.UniversityInformationSystem.persons;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.Gender;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.Grade;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.ProgramAndYear;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.Semester;
import UI_2016.fall.ItP.UniversityInformationSystem.excercises.Course;

import java.util.TreeMap;

public class Student extends Person {
    private ProgramAndYear programAndYear;
    private Semester semester;
    private TreeMap<Course, Grade> treeOfGrades;
    private final static String personIDPrefix = "S_";
    private final static String personType = "Student";
    private String subGroup;

    public Student(String firstName, String lastName, Gender gender, ProgramAndYear programAndYear, Semester semester, String subGroup) {
        super(firstName, lastName, gender, personIDPrefix);
        this.programAndYear = programAndYear;
        this.semester = semester;
        this.subGroup = subGroup;
    }

    public ProgramAndYear   getProgramAndYear() {return programAndYear;}
    public TreeMap<Course, Grade> getGrades() {return treeOfGrades;}
    public Semester getSemester() {return semester;}
    public String getSubGroup() {return subGroup;}

    public void setSubGroup(String subGroup) {this.subGroup = subGroup;}
    public void setSemester(Semester semester) {this.semester = semester;}
    public void setProgramAndYear(ProgramAndYear programAndYear) {this.programAndYear = programAndYear;}
    public void setGrades(TreeMap<Course, Grade> treeOfGrades) {this.treeOfGrades = treeOfGrades;}
}
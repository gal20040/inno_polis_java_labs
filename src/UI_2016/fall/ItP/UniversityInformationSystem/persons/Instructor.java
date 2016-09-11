package UI_2016.fall.ItP.UniversityInformationSystem.persons;


import UI_2016.fall.ItP.UniversityInformationSystem.LectureCourse;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.Gender;

public class Instructor {
    private String firstName, lastName;
    private Gender gender;
    private LectureCourse listOfLectures;

    public Instructor(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String           getFirstName() {return firstName;}
    public String           getLastName() {return lastName;}
    public Gender           getGender() {return gender;}
    public LectureCourse    getListOfLectures() {return listOfLectures;}
}
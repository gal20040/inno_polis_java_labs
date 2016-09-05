package ItP.UniversityInformationSystem.persons;

import ItP.UniversityInformationSystem.excercises.LectureCourse;
import ItP.UniversityInformationSystem.enums.Gender;

class Person {
    private String firstName, lastName;
    private Gender gender;
    private LectureCourse listOfLectures;

    private Person() {}

    Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String           getFirstName()                                  {return firstName;}
    public String           getLastName()                                   {return lastName;}
    public Gender           getGender()                                     {return gender;}
    public LectureCourse    getListOfLectures()                             {return listOfLectures;}

    public void             setFirstName(String firstName)                  {this.firstName = firstName;}
    public void             setLastName(String lastName)                    {this.lastName = lastName;}
    public void             setGender(Gender gender)                        {this.gender = gender;}
    public void             setListOfLectures(LectureCourse listOfLectures) {this.listOfLectures = listOfLectures;}
}
package ItP.UniversityInformationSystem.persons;

//import ItP.UniversityInformationSystem.excercises.LectureCourse;
import ItP.UniversityInformationSystem.enums.Gender;

class Person {
    private String firstName, lastName;
    private Gender gender;
//    private LectureCourse listOfLectures;
    private String personID;

//    private Person() {}

    Person(String firstName, String lastName, Gender gender, String personIDString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.personID = personIDString;
    }

    public String           getFirstName()                                  {return firstName;}
    public String           getLastName()                                   {return lastName;}
    public Gender           getGender()                                     {return gender;}
////    public LectureCourse    getListOfLectures()                             {return listOfLectures;}
    public String              getPersonID()                                   {return personID;}
//
    public void             setFirstName(String firstName)                  {this.firstName = firstName;}
    public void             setLastName(String lastName)                    {this.lastName = lastName;}
    public void             setGender(Gender gender)                        {this.gender = gender;}
//    public void             setListOfLectures(LectureCourse listOfLectures) {this.listOfLectures = listOfLectures;}
    void             setPersonID(String personIDString)                       {this.personID = personIDString;}
}
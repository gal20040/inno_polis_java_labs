package UI_2016.fall.ItP.UniversityInformationSystem.persons;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.Gender;

import java.util.Random;

public abstract class Person {
    private String firstName, lastName;
    private Gender gender;
    private String personID;
    private final static int IDcapacity = 99999;
    private final static String personType = "Person";

    Person(String firstName, String lastName, Gender gender, String personIDPrefix) {
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.personID = personIDPrefix + random.nextInt(IDcapacity);
    }

    public String           getFirstName()                                  {return firstName;}
    public String           getLastName()                                   {return lastName;}
    public Gender           getGender()                                     {return gender;}
    public String           getPersonID()                                   {return personID;}

    public String getPersonType() {return personType;}
}
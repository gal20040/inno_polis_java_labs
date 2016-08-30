package ItP.UniversityInformationSystem;

import ItP.UniversityInformationSystem.enums.CoreElective;
import ItP.UniversityInformationSystem.enums.DayOfWeek;
import ItP.UniversityInformationSystem.enums.Gender;
import ItP.UniversityInformationSystem.enums.ProgramAndYear;
import ItP.UniversityInformationSystem.persons.Assistant;
import ItP.UniversityInformationSystem.persons.Instructor;
import ItP.UniversityInformationSystem.persons.Student;

import java.util.ArrayList;

public class Solution {
    private static ArrayList<LectureCourse> listOfLectureCourse = new ArrayList<>();
    private static ArrayList<Student> listOfStudents = new ArrayList<>();
    private static ArrayList<Instructor> listOfInstructors = new ArrayList<>();
    private static ArrayList<Assistant> listOfAssistants = new ArrayList<>();
    private static ArrayList<Lecture> lectureSchedule = new ArrayList<>();

    private static String templateNoDiscipline = "Discipline %s has not been found in the course list of program %s."
            + " %s %s %s has not been assigned to this course.";

    public static void main(String[] args) {

        addLectureCourses();
        addStudents();
        addAssistants();
        addInstructors();

//        for (Student student : listOfStudents) {
//            System.out.println(student.getFirstName());
//        }
//        System.out.println();
//
//        for (LectureCourse lectureCourse : listOfLectureCourse) {
//            for (Student student : lectureCourse.getListOfStudentsInCourse()) {
//                student.setFirstName(student.getFirstName() + "1");
//            }
//        }
//
//        for (Student student : listOfStudents) {
//            System.out.println(student.getFirstName());
//        }
//        System.out.println();

        printAllInfoAboutCourses();
    }

    private static void addInstructors() {
        Instructor tempInstructor;

        tempInstructor = new Instructor("Adil", "Khan", Gender.Male);
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Discrete Math/Logic", ProgramAndYear.BS1);
        assignInstructorToCourse(tempInstructor, "Data Structures and Algorithms", ProgramAndYear.BS3);

        tempInstructor = new Instructor("Nikolaos", "Mavridis", Gender.Male);
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Computer Architecture", ProgramAndYear.BS1);

        tempInstructor = new Instructor("Ales", "Zivkovic", Gender.Female);
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Computer Architecture", ProgramAndYear.BS2);
        assignInstructorToCourse(tempInstructor, "Managing Software Development", ProgramAndYear.MSIT_SE);

        tempInstructor = new Instructor("Qiang", "Qu", Gender.Male);
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Data Modelling and Databases", ProgramAndYear.BS3);

        tempInstructor = new Instructor("Eugene", "Zouev", Gender.Male);
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Introduction to Programming", ProgramAndYear.BS3);

        tempInstructor = new Instructor("Alexandr", "Klimchik", Gender.Male);
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Data Structures and Algorithms", ProgramAndYear.MS1);
        assignInstructorToCourse(tempInstructor, "Industrial Robotics", ProgramAndYear.MS_R);

        tempInstructor = new Instructor("Mohamad", "Kassab", Gender.Male);
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Data Modelling and Databases", ProgramAndYear.MS1);
    }

    private static void assignInstructorToCourse(Instructor instructor,
                                                 String disciplineName, ProgramAndYear programAndYear) {
        boolean foundCourse = false;

        for (LectureCourse lectureCourse : listOfLectureCourse) {
            if (lectureCourse.getTitle().equals(disciplineName)
                    && lectureCourse.getProgramAndYear().equals(programAndYear)
                    && !lectureCourse.getListOfInstructorsInCourse().contains(instructor)) {
                lectureCourse.getListOfInstructorsInCourse().add(instructor);
                foundCourse = true;
            }
        }
        if (!foundCourse)
            System.out.println(String.format(templateNoDiscipline, disciplineName, programAndYear,
                    "Instructor", instructor.getFirstName(), instructor.getLastName()));
    }

    private static void addAssistants() {
        Assistant tempAssistant;

        tempAssistant = new Assistant("Mansur", "Khazeev", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Introduction to Programming", ProgramAndYear.BS3);

        tempAssistant = new Assistant("Stas", "Protasov", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Structures and Algorithms", ProgramAndYear.BS3);

        tempAssistant = new Assistant("Sergey", "Gartsev", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Modelling and Databases", ProgramAndYear.BS3);

        tempAssistant = new Assistant("Sadegh", "Nobari", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Modelling and Databases", ProgramAndYear.BS3);

        tempAssistant = new Assistant("Artur", "Sagitov", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS1);

        tempAssistant = new Assistant("Ilya", "Shimshik", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS1);

        tempAssistant = new Assistant("Ahmad", "Muhammad", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS1);

        tempAssistant = new Assistant("Ramil", "Kuleev", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Discrete Math/Logic", ProgramAndYear.BS1);

        tempAssistant = new Assistant("Yunus", "Zaytaev", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS2);

        tempAssistant = new Assistant("Bulat", "Gabbasov", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS2);
        assignAssistantToCourse(tempAssistant, "Data Modelling and Databases", ProgramAndYear.MS1);

        tempAssistant = new Assistant("Roman", "Lavrenov", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Structures and Algorithms", ProgramAndYear.MS1);

        tempAssistant = new Assistant("Igor", "Danilov", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Structures and Algorithms", ProgramAndYear.MS1);

        tempAssistant = new Assistant("Albina", "Khusainova", Gender.Female);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Modelling and Databases", ProgramAndYear.MS1);

        tempAssistant = new Assistant("Alyona", "Kozlova", Gender.Female);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Managing Software Development", ProgramAndYear.MSIT_SE);

        tempAssistant = new Assistant("Albert", "Nurgaliev", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Managing Software Development", ProgramAndYear.MSIT_SE);

        tempAssistant = new Assistant("Vasilii", "Artemiev", Gender.Male);
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Managing Software Development", ProgramAndYear.MSIT_SE);
    }

    private static void assignAssistantToCourse(Assistant assistant,
                                                String disciplineName, ProgramAndYear programAndYear) {
        boolean foundCourse = false;

        for (LectureCourse lectureCourse : listOfLectureCourse) {
            if (lectureCourse.getTitle().equals(disciplineName)
                    && lectureCourse.getProgramAndYear().equals(programAndYear)
                    && !lectureCourse.getListOfAssistantsInCourse().contains(assistant)) {
                lectureCourse.getListOfAssistantsInCourse().add(assistant);
                foundCourse = true;
            }
        }

        if (!foundCourse)
            System.out.println(String.format(templateNoDiscipline, disciplineName, programAndYear,
                    "Assistant", assistant.getFirstName(), assistant.getLastName()));
    }

    private static void addStudents() {
        listOfStudents.add(new Student("Sergei", "Efron", Gender.Male, ProgramAndYear.BS1));
        listOfStudents.add(new Student("Vera", "Mukhina", Gender.Female, ProgramAndYear.BS3));
        listOfStudents.add(new Student("Leonardo", "da Vinci", Gender.Male, ProgramAndYear.MSIT_SE));
        listOfStudents.add(new Student("Marina", "Tsvetaeva", Gender.Female, ProgramAndYear.MS_R));

        for (LectureCourse lectureCourse : listOfLectureCourse) {
            for (Student student : listOfStudents) {
                if (student.getProgramAndYear().equals(lectureCourse.getProgramAndYear())) {
                    lectureCourse.getListOfStudentsInCourse().add(student);
                }
            }
        }
    }

    private static void addLectureCourses() {
        LectureCourse tempLectureCourse;
        tempLectureCourse = new LectureCourse("Computer Architecture", ProgramAndYear.BS1, CoreElective.Core);
        listOfLectureCourse.add(tempLectureCourse);
        lectureSchedule.add(new Lecture(tempLectureCourse, 101, DayOfWeek.Monday));
        listOfLectureCourse.add(new LectureCourse("Discrete Math/Logic", ProgramAndYear.BS1, CoreElective.Core));
        //TODO переделать остальные лекции
        listOfLectureCourse.add(new LectureCourse("Computer Architecture", ProgramAndYear.BS2, CoreElective.Core));

        listOfLectureCourse.add(new LectureCourse("Data Modelling and Databases", ProgramAndYear.BS3, CoreElective.Core));
        listOfLectureCourse.add(new LectureCourse("Data Structures and Algorithms", ProgramAndYear.BS3, CoreElective.Core));
        listOfLectureCourse.add(new LectureCourse("Introduction to Programming", ProgramAndYear.BS3, CoreElective.Core));

        listOfLectureCourse.add(new LectureCourse("Data Structures and Algorithms", ProgramAndYear.MS1, CoreElective.Core));
        listOfLectureCourse.add(new LectureCourse("Data Modelling and Databases", ProgramAndYear.MS1, CoreElective.Core));

        listOfLectureCourse.add(new LectureCourse("Managing Software Development", ProgramAndYear.MSIT_SE, CoreElective.Core));
        listOfLectureCourse.add(new LectureCourse("Industrial Robotics", ProgramAndYear.MS_R, CoreElective.Core));
    }

    private static void printAllInfoAboutCourses() {
        String template = "%s course \"%s\", program %s";

        for (LectureCourse lectureCourse : listOfLectureCourse) {
            System.out.println(String.format(template, lectureCourse.getCoreElective(),
                    lectureCourse.getTitle(), lectureCourse.getProgramAndYear()));
            System.out.println("Instructor:");
            for (Instructor instructor : lectureCourse.getListOfInstructorsInCourse()) {
                System.out.println("            " + instructor.getFirstName() + " " + instructor.getLastName());
            }
            System.out.println("Assistants:");
            for (Assistant assistant : lectureCourse.getListOfAssistantsInCourse()) {
                System.out.println("            " + assistant.getFirstName() + " " + assistant.getLastName());
            }
            System.out.println("Students:");
            for (Student student : lectureCourse.getListOfStudentsInCourse()) {
                System.out.println("            " + student.getFirstName() + " " + student.getLastName());
            }
            System.out.println();

        }
//        System.out.println();
    }
}
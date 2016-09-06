package ItP.UniversityInformationSystem;

import ItP.UniversityInformationSystem.enums.*;
import ItP.UniversityInformationSystem.excercises.*;
import ItP.UniversityInformationSystem.persons.Assistant;
import ItP.UniversityInformationSystem.persons.Instructor;
import ItP.UniversityInformationSystem.persons.Student;

import java.util.ArrayList;
import java.util.Random;

public class University {
    private static ArrayList<LectureCourse> listOfLectureCourse = new ArrayList<>();
    private static ArrayList<Student> listOfStudents = new ArrayList<>();
    private static ArrayList<Instructor> listOfInstructors = new ArrayList<>();
    private static ArrayList<Assistant> listOfAssistants = new ArrayList<>();
    private static ArrayList<Exercise> exerciseSchedule = new ArrayList<>();
    private static Random random = new Random();

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

        tempInstructor = new Instructor("Adil", "Khan", Gender.MALE, random.nextInt(10000));
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Discrete Math/Logic", ProgramAndYear.BS1);
        assignInstructorToCourse(tempInstructor, "Data Structures and Algorithms", ProgramAndYear.BS3);

        tempInstructor = new Instructor("Nikolaos", "Mavridis", Gender.MALE, random.nextInt(10000));
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Computer Architecture", ProgramAndYear.BS1);

        tempInstructor = new Instructor("Ales", "Zivkovic", Gender.FEMALE, random.nextInt(10000));
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Computer Architecture", ProgramAndYear.BS2);
        assignInstructorToCourse(tempInstructor, "Managing Software Development", ProgramAndYear.MSIT_SE);

        tempInstructor = new Instructor("Qiang", "Qu", Gender.MALE, random.nextInt(10000));
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Data Modelling and Databases", ProgramAndYear.BS3);

        tempInstructor = new Instructor("Eugene", "Zouev", Gender.MALE, random.nextInt(10000));
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Introduction to Programming", ProgramAndYear.BS3);

        tempInstructor = new Instructor("Alexandr", "Klimchik", Gender.MALE, random.nextInt(10000));
        listOfInstructors.add(tempInstructor);
        assignInstructorToCourse(tempInstructor, "Data Structures and Algorithms", ProgramAndYear.MS1);
        assignInstructorToCourse(tempInstructor, "Industrial Robotics", ProgramAndYear.MS_R);

        tempInstructor = new Instructor("Mohamad", "Kassab", Gender.MALE, random.nextInt(10000));
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

        tempAssistant = new Assistant("Mansur", "Khazeev", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Introduction to Programming", ProgramAndYear.BS3);

        tempAssistant = new Assistant("Stas", "Protasov", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Structures and Algorithms", ProgramAndYear.BS3);

        tempAssistant = new Assistant("Sergey", "Gartsev", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Modelling and Databases", ProgramAndYear.BS3);

        tempAssistant = new Assistant("Sadegh", "Nobari", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Modelling and Databases", ProgramAndYear.BS3);

        tempAssistant = new Assistant("Artur", "Sagitov", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS1);

        tempAssistant = new Assistant("Ilya", "Shimshik", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS1);

        tempAssistant = new Assistant("Ahmad", "Muhammad", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS1);

        tempAssistant = new Assistant("Ramil", "Kuleev", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Discrete Math/Logic", ProgramAndYear.BS1);

        tempAssistant = new Assistant("Yunus", "Zaytaev", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS2);

        tempAssistant = new Assistant("Bulat", "Gabbasov", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Computer Architecture", ProgramAndYear.BS2);
        assignAssistantToCourse(tempAssistant, "Data Modelling and Databases", ProgramAndYear.MS1);

        tempAssistant = new Assistant("Roman", "Lavrenov", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Structures and Algorithms", ProgramAndYear.MS1);

        tempAssistant = new Assistant("Igor", "Danilov", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Structures and Algorithms", ProgramAndYear.MS1);

        tempAssistant = new Assistant("Albina", "Khusainova", Gender.FEMALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Data Modelling and Databases", ProgramAndYear.MS1);

        tempAssistant = new Assistant("Alyona", "Kozlova", Gender.FEMALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Managing Software Development", ProgramAndYear.MSIT_SE);

        tempAssistant = new Assistant("Albert", "Nurgaliev", Gender.MALE, random.nextInt(10000));
        listOfAssistants.add(tempAssistant);
        assignAssistantToCourse(tempAssistant, "Managing Software Development", ProgramAndYear.MSIT_SE);

        tempAssistant = new Assistant("Vasilii", "Artemiev", Gender.MALE, random.nextInt(10000));
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
        listOfStudents.add(new Student("Sergei", "Efron", Gender.MALE, random.nextInt(10000), ProgramAndYear.BS1));
        listOfStudents.add(new Student("Vera", "Mukhina", Gender.FEMALE, random.nextInt(10000), ProgramAndYear.BS3));
        listOfStudents.add(new Student("Leonardo", "da Vinci", Gender.MALE, random.nextInt(10000), ProgramAndYear.MSIT_SE));
        listOfStudents.add(new Student("Marina", "Tsvetaeva", Gender.FEMALE, random.nextInt(10000), ProgramAndYear.MS_R));

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

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Computer Architecture", ProgramAndYear.BS1,
                CoreElective.CORE, Semester.AUTUMN);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 101, DayOfWeek.MONDAY));

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Discrete Math/Logic", ProgramAndYear.BS1,
                CoreElective.CORE, Semester.AUTUMN);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 110, DayOfWeek.TUESDAY));

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Computer Architecture", ProgramAndYear.BS2,
                CoreElective.CORE, Semester.AUTUMN);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 101, DayOfWeek.THURSDAY));

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Data Modelling and Databases", ProgramAndYear.BS3,
                CoreElective.CORE, Semester.AUTUMN);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 101, DayOfWeek.FRIDAY));
        exerciseSchedule.add(new LabSession(tempLectureCourse, 301, DayOfWeek.FRIDAY));
        exerciseSchedule.add(new Examination(tempLectureCourse, 101, DayOfWeek.FRIDAY));

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Data Structures and Algorithms", ProgramAndYear.BS3,
                CoreElective.CORE, Semester.AUTUMN);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 120, DayOfWeek.SATURDAY));
        exerciseSchedule.add(new LabSession(tempLectureCourse, 320, DayOfWeek.SATURDAY));
        exerciseSchedule.add(new Examination(tempLectureCourse, 120, DayOfWeek.SATURDAY));

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Introduction to Programming", ProgramAndYear.BS3,
                CoreElective.CORE, Semester.SPRING);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 120, DayOfWeek.MONDAY));
        exerciseSchedule.add(new LabSession(tempLectureCourse, 320, DayOfWeek.MONDAY));
        exerciseSchedule.add(new Examination(tempLectureCourse, 120, DayOfWeek.MONDAY));

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Data Structures and Algorithms", ProgramAndYear.MS1,
                CoreElective.CORE, Semester.SPRING);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 120, DayOfWeek.FRIDAY));

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Data Modelling and Databases", ProgramAndYear.MS1,
                CoreElective.CORE, Semester.SPRING);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 130, DayOfWeek.WEDNESDAY));

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Managing Software Development", ProgramAndYear.MSIT_SE,
                CoreElective.CORE, Semester.SPRING);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 130, DayOfWeek.TUESDAY));

        tempLectureCourse = new LectureCourse(random.nextInt(10000), "Industrial Robotics", ProgramAndYear.MS_R,
                CoreElective.CORE, Semester.SPRING);
        listOfLectureCourse.add(tempLectureCourse);
        exerciseSchedule.add(new Lecture(tempLectureCourse, 130, DayOfWeek.FRIDAY));
    }

    private static void printAllInfoAboutCourses() {
        String template = "%s course %s \"%s\", program %s, %s semester";

        for (LectureCourse lectureCourse : listOfLectureCourse) {
            System.out.println(String.format(template, lectureCourse.getCoreElective(),
                    lectureCourse.getLectureCourseID(), lectureCourse.getTitle(),
                    lectureCourse.getProgramAndYear(), lectureCourse.getSemester()));
            System.out.println("Instructor:");
            for (Instructor instructor : lectureCourse.getListOfInstructorsInCourse()) {
                System.out.println("            " + instructor.getFirstName() + " " + instructor.getLastName()
                        + ", personal number " + instructor.getPersonID());
            }
            System.out.println("Assistants:");
            for (Assistant assistant : lectureCourse.getListOfAssistantsInCourse()) {
                System.out.println("            " + assistant.getFirstName() + " " + assistant.getLastName()
                        + ", personal number " + assistant.getPersonID());
            }
            System.out.println("Students:");
            for (Student student : lectureCourse.getListOfStudentsInCourse()) {
                System.out.println("            " + student.getFirstName() + " " + student.getLastName()
                        + ", personal number " + student.getPersonID());
            }
            System.out.println();

        }
//        System.out.println();
    }
}
package UI_2016.fall.ItP.UniversityInformationSystem;

import UI_2016.fall.ItP.UniversityInformationSystem.excercises.Course;
import UI_2016.fall.ItP.UniversityInformationSystem.excercises.Exercise;
import UI_2016.fall.ItP.UniversityInformationSystem.excercises.LabSession;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Assistant;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Instructor;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Student;

abstract class InfoPrinter {
    private final static String templateCourse = "%s course %s \"%s\", program %s, %s semester";
    private final static String templatePerson = "            %s %s, personal number %s";
    private final static String templateStudent = templatePerson + ", program %s, semester: %s";
    private final static String templateInstructor = "                         course: %s, course program: %s, course semester: %s";
    private final static String templateTimeAndDay = " - lab session on %s at %s";



    static void printAllInfoAboutCourses() {
        Assistant labAssistant;
        for (Course course : University.getListOfCourse()) {
            System.out.println(String.format(templateCourse, course.getCoreElective(),
                    course.getCourseID(), course.getTitle(),
                    course.getProgramAndYear(), course.getSemester()));
            System.out.println("Instructor:");
            for (Instructor instructor : course.getListOfInstructorsInCourse()) {
                System.out.println(String.format(templatePerson, instructor.getFirstName(),
                        instructor.getLastName(), instructor.getPersonID()));
            }
            System.out.println("Assistants:");
            for (Exercise exercise : University.getExerciseSchedule()) {
                if (exercise.getCourse().getTitle().equals(course.getTitle())
                        && exercise.getCourse().getProgramAndYear() == course.getProgramAndYear()
                        && exercise.getCourse().getSemester() == course.getSemester()
                        && exercise instanceof LabSession){
                    labAssistant = ((LabSession) exercise).getAssistant();
                    System.out.print(String.format(templatePerson, labAssistant.getFirstName(),
                            labAssistant.getLastName(), labAssistant.getPersonID()));
                    System.out.println(String.format(templateTimeAndDay, exercise.getDayOfWeek(), exercise.getBeginTimeAsString()));
                }
            }
            getStudentsInfoOnCertainCourse(course);
            System.out.println("----------------------");
            System.out.println();
        }
    }

    static void getStudentsInfoOnCertainCourse(Course course) {
        System.out.println("Students:");
        for (Student student : course.getListOfStudentsInCourse()) {
            System.out.println(String.format(templatePerson, student.getFirstName(),
                    student.getLastName(), student.getPersonID()));
        }
    }

    static void getAllStudentsInfo() {
        System.out.println("----------------------");
        System.out.println();
        System.out.println("All students:");
        for (Student student : University.getListOfStudents()) {
            System.out.println(String.format(templateStudent, student.getFirstName(),
                    student.getLastName(), student.getPersonID(), student.getProgramAndYear(), student.getSemester()));
        }
    }

    static void getAllInstructorsInfo() {
        System.out.println("----------------------");
        System.out.println();
        System.out.println("All instructors:");
        for (Instructor instructor : University.getListOfInstructors()) {
            System.out.println(String.format(templatePerson, instructor.getFirstName(),
                    instructor.getLastName(), instructor.getPersonID()));
            for (Course course : University.getListOfCourse()) {
                for (Instructor courseInstructor : course.getListOfInstructorsInCourse()) {
                    if (instructor.getFirstName().equals(courseInstructor.getFirstName())
                            && instructor.getLastName().equals(courseInstructor.getLastName()))
                        System.out.println(String.format(templateInstructor, course.getTitle(), course.getProgramAndYear(),
                                course.getSemester()));
                }
            }
        }
    }
}
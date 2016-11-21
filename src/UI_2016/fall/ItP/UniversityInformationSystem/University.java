package UI_2016.fall.ItP.UniversityInformationSystem;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.*;
import UI_2016.fall.ItP.UniversityInformationSystem.excercises.*;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Assistant;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Instructor;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Person;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Student;

import java.util.*;

public class University {
    private static ArrayList<Course> listOfCourse = new ArrayList<>();
    private static ArrayList<Student> listOfStudents = new ArrayList<>();
    private static ArrayList<Instructor> listOfInstructors = new ArrayList<>();
    private static ArrayList<Assistant> listOfAssistants = new ArrayList<>();
    private static ArrayList<Exercise> exerciseSchedule = new ArrayList<>();

    static ArrayList<Course> getListOfCourse() {return listOfCourse;}
    static ArrayList<Student> getListOfStudents() {return listOfStudents;}
    static ArrayList<Instructor> getListOfInstructors() {return listOfInstructors;}
    static ArrayList<Assistant> getListOfAssistants() {return listOfAssistants;}
    static ArrayList<Exercise> getExerciseSchedule() {return exerciseSchedule;}

    private final static String templateNoDiscipline = "Discipline \"%s\" has not been found in the course list of program %s."
            + " %s %s %s has not been assigned to this course.";

    public static void main(String[] args) {
        initializeCourses();
        initializeStudents();
        initializeInstructors();
        initializeAssistants();
        createSchedule();
        InfoPrinter.printAllInfoAboutCourses();
        InfoPrinter.getAllStudentsInfo();
        InfoPrinter.getAllInstructorsInfo();
    }

    private static void createSchedule() {
        DayOfWeek dayOfWeek;
        String courseTitle;
        Course course;
        Semester semester;
        ProgramAndYear programAndYear;
        LabSession labSession;
        Lecture lecture;


        semester = Semester.AUTUMN2016;
        {


            programAndYear = ProgramAndYear.BS3;
            {


                dayOfWeek = DayOfWeek.MONDAY;
                {


                    courseTitle = "Data Modelling and Databases";
                    course = searchForCourse(courseTitle, programAndYear, semester);
                    {
                        exerciseSchedule.add(new Lecture(course, "107", dayOfWeek, "09:00"));
                        labSession = new LabSession(course, "1", "308", dayOfWeek, "17:10", searchAssistant("Sadegh", "Nobari"));
                        exerciseSchedule.add(labSession);

                        labSession = labSession.getCopy();
                        labSession.setSubGroup("2");
                        labSession.setBeginTime("15:30");
                        labSession.setAssistant(searchAssistant("Sergey", "Gartsev"));
                        exerciseSchedule.add(labSession);
                    }
                }

                dayOfWeek = DayOfWeek.TUESDAY;
                {

                    courseTitle = "Data Structures and Algorithms";
                    course = searchForCourse(courseTitle, programAndYear, semester);
                    {
                        exerciseSchedule.add(new Lecture(course, "107", dayOfWeek, "09:00"));

                        labSession = new LabSession(course, "1", "307", dayOfWeek, "13:50", searchAssistant("Stas", "Protasov"));
                        exerciseSchedule.add(labSession);

                        labSession = labSession.getCopy();
                        labSession.setSubGroup("2");
                        labSession.setBeginTime("15:30");
                        exerciseSchedule.add(labSession);
                    }
                }

                dayOfWeek = DayOfWeek.WEDNESDAY;
                {

                    courseTitle = "Introduction to Programming";
                    course = searchForCourse(courseTitle, programAndYear, semester);
                    {
                        exerciseSchedule.add(new Lecture(course, "107", dayOfWeek, "09:00"));

                        labSession = new LabSession(course, "1", "308", dayOfWeek, "15:30", searchAssistant("Mansur", "Khazeev"));
                        exerciseSchedule.add(labSession);

                        labSession = labSession.getCopy();
                        labSession.setSubGroup("2");
                        labSession.setBeginTime("17:10");
                        exerciseSchedule.add(labSession);
                    }
                }

                dayOfWeek = DayOfWeek.THURSDAY;
                {

                    courseTitle = "Philosophy";
                    course = searchForCourse(courseTitle, programAndYear, semester);
                    {
                        lecture = new Lecture(course, "107", dayOfWeek, "09:00");
                        exerciseSchedule.add(lecture);

                        lecture = lecture.getCopy();
                        lecture.setBeginTime("10:40");
                        exerciseSchedule.add(lecture);
                    }
                }

            }

        }

        semester = Semester.AUTUMN2015;
        {


            programAndYear = ProgramAndYear.BS3;
            {


                dayOfWeek = DayOfWeek.MONDAY;
                {


                    courseTitle = "Data Modelling and Databases";
                    course = searchForCourse(courseTitle, programAndYear, semester);
                    {
                        exerciseSchedule.add(new Lecture(course, "108", dayOfWeek, "09:00"));
                        labSession = new LabSession(course, "1", "307", dayOfWeek, "10:40", searchAssistant("Sadegh", "Nobari"));
                        exerciseSchedule.add(labSession);

                        labSession = labSession.getCopy();
                        labSession.setSubGroup("5");
                        labSession.setRoom("308");
                        labSession.setBeginTime("13:20");
                        labSession.setAssistant(searchAssistant("Waqas", "Waqas"));
                        exerciseSchedule.add(labSession);
                    }
                }

                dayOfWeek = DayOfWeek.TUESDAY;
                {

                    courseTitle = "Data Structures and Algorithms";
                    course = searchForCourse(courseTitle, programAndYear, semester);
                    {
                        exerciseSchedule.add(new Lecture(course, "108", dayOfWeek, "09:00"));

                        labSession = new LabSession(course, "1", "318", dayOfWeek, "10:40", searchAssistant("Adel", "Adel"));
                        exerciseSchedule.add(labSession);

                        labSession = labSession.getCopy();
                        labSession.setSubGroup("5");
                        labSession.setRoom("308");
                        labSession.setBeginTime("13:20");
                        labSession.setAssistant(searchAssistant("Ahmed", "Kamil"));
                        exerciseSchedule.add(labSession);
                    }
                }

                dayOfWeek = DayOfWeek.WEDNESDAY;
                {

                    courseTitle = "Introduction to Programming";
                    course = searchForCourse(courseTitle, programAndYear, semester);
                    {
                        exerciseSchedule.add(new Lecture(course, "108", dayOfWeek, "09:00"));

                        labSession = new LabSession(course, "1", "307", dayOfWeek, "10:40", searchAssistant("Victor", "Rivera"));
                        exerciseSchedule.add(labSession);

                        labSession = labSession.getCopy();
                        labSession.setSubGroup("5");
                        labSession.setRoom("318");
                        labSession.setBeginTime("13:20");
                        labSession.setAssistant(searchAssistant("D.de", "Carvalho"));
                        exerciseSchedule.add(labSession);
                    }
                }

                dayOfWeek = DayOfWeek.THURSDAY;
                {

                    courseTitle = "Philosophy";
                    course = searchForCourse(courseTitle, programAndYear, semester);
                    {
                        lecture = new Lecture(course, "108", dayOfWeek, "09:00");
                        exerciseSchedule.add(lecture);

                        lecture = lecture.getCopy();
                        lecture.setBeginTime("10:40");
                        exerciseSchedule.add(lecture);
                    }
                }

            }
        }
    }

    private static Assistant searchAssistant(String firstName, String lastName) {
        Assistant assistant = null;
        for (int i = 0; i < listOfAssistants.size(); i++) {
            assistant = listOfAssistants.get(i);
            if (assistant.getFirstName().equals(firstName)
                    && assistant.getLastName().equals(lastName))
                break;
        }

        return assistant;
    }

    private static void initializeCourses() {
        String courseTitle;
        ProgramAndYear programAndYear;
        CoreElective coreElective;
        Semester semester;
        List<String> stringList;
        List<ProgramAndYear> programAndYearList;

        semester = Semester.AUTUMN2016; {

            coreElective = CoreElective.CORE; {


                programAndYear = ProgramAndYear.BS3;
                stringList = Arrays.asList(
                        "Data Modelling and Databases",
                        "Data Structures and Algorithms",
                        "Introduction to Programming",
                        "Philosophy");
                addCoursesToList(stringList, programAndYear, coreElective, semester);


                programAndYear = ProgramAndYear.MSIT_SE;
                stringList = Arrays.asList(
                        "Managing Software Development",
                        "Models of Software Systems",
                        "Introduction to Personal Software Process",
                        "Communication for Software Engineers",
                        "Methods: Deciding What to Design",
                        "User Experience and User Interface Design Fundamentals");
                addCoursesToList(stringList, programAndYear, coreElective, semester);



            }


            coreElective = CoreElective.ELECTIVE; {
                courseTitle = "English";
                programAndYearList = Arrays.asList(
                        ProgramAndYear.BS3,
                        ProgramAndYear.MSIT_SE);
                addCoursesToList(programAndYearList, courseTitle, coreElective, semester);
            }

        }

        semester = Semester.AUTUMN2015; {

            coreElective = CoreElective.CORE; {


                programAndYearList = Arrays.asList(
                        ProgramAndYear.BS3,
                        ProgramAndYear.MSIT_SE);
                courseTitle = "Data Modelling and Databases";
                addCoursesToList(programAndYearList, courseTitle, coreElective, semester);
                courseTitle = "Data Structures and Algorithms";
                addCoursesToList(programAndYearList, courseTitle, coreElective, semester);
                courseTitle = "Introduction to Programming";
                addCoursesToList(programAndYearList, courseTitle, coreElective, semester);


                programAndYearList = Arrays.asList(
                        ProgramAndYear.BS3);
                courseTitle = "Philosophy";
                addCoursesToList(programAndYearList, courseTitle, coreElective, semester);


            }

            coreElective = CoreElective.ELECTIVE; {
                courseTitle = "English";
                programAndYearList = Arrays.asList(
                        ProgramAndYear.BS3,
                        ProgramAndYear.MSIT_SE);
                addCoursesToList(programAndYearList, courseTitle, coreElective, semester);
            }

        }
    }

    private static void addCoursesToList(List<String> list, ProgramAndYear programAndYear,
                                         CoreElective coreElective, Semester semester) {
        Course course;
        for(String courseTitle: list) {
            course = createCourse(courseTitle, programAndYear, coreElective, semester);
            listOfCourse.add(course);
        }
    }

    private static void addCoursesToList(List<ProgramAndYear> list, String courseTitle,
                                         CoreElective coreElective, Semester semester) {
        Course course;
        for(ProgramAndYear programAndYearMember : list) {
            course = createCourse(courseTitle, programAndYearMember, coreElective, semester);
            listOfCourse.add(course);
        }
    }

    private static Course createCourse(String title, ProgramAndYear programAndYear,
                                       CoreElective coreElective, Semester semester) {
        Course newCourse = new Course(title, programAndYear, coreElective, semester);

        return newCourse;
    }

    private static void initializeStudents() {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<String> stringArrayList = fileReaderWriter.readFromInputFile("studentsList.txt");
        String personFirstName, personLastName;
        Random random = new Random(new Date().getTime());
        Semester semester;
        ProgramAndYear programAndYear;
        String subGroup;
        Gender gender;
        String[] array;

        for(String personString: stringArrayList) {
            array = parsePersonString(personString);
            personFirstName = array[0];
            personLastName = array[1];
            gender = array[2].equals("MALE") ? Gender.MALE : Gender.FEMALE;

            if (random.nextInt(2) == 0)
                semester = Semester.AUTUMN2015;
            else
                semester = Semester.AUTUMN2016;

            subGroup = "" + (random.nextInt(2) + 1);

            switch (random.nextInt(2)) {
                case 0:
                    programAndYear = ProgramAndYear.BS3;
                    break;
                default:
                    programAndYear = ProgramAndYear.MSIT_SE;
                    break;
            }

            listOfStudents.add(new Student(personFirstName, personLastName, gender, programAndYear, semester, subGroup));
        }

        for (Course course : listOfCourse) {
            for (Student student : listOfStudents) {
                if (student.getProgramAndYear().equals(course.getProgramAndYear())) {
                    course.getListOfStudentsInCourse().add(student);
                }
            }
        }
    }

    private static void initializeInstructors() {
        Instructor instructor;
        ProgramAndYear programAndYear;
        Gender gender;
        Semester semester;
        String courseTitle;

        gender = Gender.MALE;{

            semester = Semester.AUTUMN2016; {


                instructor = createInstructor("Adil", "Khan", gender);
                assignPersonToCourse(instructor, "Data Structures and Algorithms", ProgramAndYear.BS3, semester);


                programAndYear = ProgramAndYear.BS3;
                {

                    instructor = createInstructor("Eugene", "Zouev", gender);
                    assignPersonToCourse(instructor, "Introduction to Programming", programAndYear, semester);

                    instructor = createInstructor("Rustem", "Tsiunchuk", gender);
                    assignPersonToCourse(instructor, "Philosophy", programAndYear, semester);

                    instructor = createInstructor("Qiang", "Qu", gender);
                    assignPersonToCourse(instructor, "Data Modelling and Databases", programAndYear, semester);


                }


                programAndYear = ProgramAndYear.MSIT_SE;
                {

                    instructor = createInstructor("Ales", "Zivkovic", gender);
                    assignPersonToCourse(instructor, "Managing Software Development", programAndYear, semester);

                    instructor = createInstructor("Nestor", "Catano", gender);
                    assignPersonToCourse(instructor, "Models of Software Systems", programAndYear, semester);

                    instructor = createInstructor("Vasilii", "Artemiev", gender);
                    assignPersonToCourse(instructor, "Introduction to Personal Software Process", programAndYear, semester);

                    instructor = createInstructor("Daniel", "Johnston", gender);
                    assignPersonToCourse(instructor, "Communication for Software Engineers", programAndYear, semester);

                    instructor = createInstructor("Alberto", "Sillitti", gender);
                    assignPersonToCourse(instructor, "Methods: Deciding What to Design", programAndYear, semester);

                    instructor = createInstructor("Daniel", "Johnston", gender);
                    assignPersonToCourse(instructor, "English", programAndYear, semester);

                    instructor = createInstructor("Said", "Kadyrov", gender);
                    assignPersonToCourse(instructor, "User Experience and User Interface Design Fundamentals", programAndYear, semester);


                }


            }

            semester = Semester.AUTUMN2015; {

                instructor = createInstructor("Rustem", "Tsiunchuk", gender);
                assignPersonToCourse(instructor, "Philosophy", ProgramAndYear.BS3, semester);

                courseTitle = "Data Modelling and Databases";
                instructor = createInstructor("Qiang", "Qu", gender);
                assignPersonToCourse(instructor, courseTitle, ProgramAndYear.BS3, semester);
                assignPersonToCourse(instructor, courseTitle, ProgramAndYear.MSIT_SE, semester);

                courseTitle = "Data Structures and Algorithms";
                instructor = createInstructor("Adil", "Khan", gender);
                assignPersonToCourse(instructor, courseTitle, ProgramAndYear.BS3, semester);
                assignPersonToCourse(instructor, courseTitle, ProgramAndYear.MSIT_SE, semester);


                courseTitle = "Introduction to Programming";
                instructor = createInstructor("M", "Mazzara", gender);
                assignPersonToCourse(instructor, courseTitle, ProgramAndYear.BS3, semester);
                assignPersonToCourse(instructor, courseTitle, ProgramAndYear.MSIT_SE, semester);


            }
        }
    }

    private static Instructor createInstructor(String firstName, String lastName, Gender gender) {
        Instructor instructor = new Instructor(firstName, lastName, gender);
        listOfInstructors.add(instructor);
        return instructor;
    }

    private static String[] parsePersonString(String personString) {
        String[] array = new String[3];
        int commaPosition = personString.indexOf(",");
        int colonPosition = personString.indexOf(":");
        array[0] = personString.substring(0, commaPosition);
        array[1] = personString.substring(commaPosition + 1, colonPosition);
        array[2] = personString.substring(colonPosition + 1).toUpperCase();
        return array;
    }

    private static void initializeAssistants() {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<String> stringArrayList = fileReaderWriter.readFromInputFile("assistantList.txt");
        String personFirstName, personLastName;
        Gender gender;
        String[] array;

        for(String personString: stringArrayList) {
            array = parsePersonString(personString);
            personFirstName = array[0];
            personLastName = array[1];
            gender = array[2].equals("MALE") ? Gender.MALE : Gender.FEMALE;

            listOfAssistants.add(new Assistant(personFirstName, personLastName, gender));
        }
    }

    private static void assignPersonToCourse(Person person, String disciplineName, ProgramAndYear programAndYear, Semester semester) {
        boolean foundCourse = false;

        for (Course course : listOfCourse) {
            if (course.getTitle().equals(disciplineName)
                    && course.getProgramAndYear().equals(programAndYear)
                    && course.getSemester().equals(semester)) {
                if (person instanceof Instructor
                        && !course.getListOfInstructorsInCourse().contains(person)) {
                    course.getListOfInstructorsInCourse().add((Instructor) person);
                    foundCourse = true;
                    break;
                }
                else if (person instanceof Assistant
                        && !course.getListOfAssistantsInCourse().contains(person)) {
                    course.getListOfAssistantsInCourse().add((Assistant) person);
                    foundCourse = true;
                    break;
                }
            }
        }

        if (!foundCourse)
            System.out.println(String.format(templateNoDiscipline, disciplineName, programAndYear,
                    person.getPersonType(), person.getFirstName(), person.getLastName()));
    }

    private static Course searchForCourse(String courseTitle, ProgramAndYear programAndYear, Semester semester) {
        Course course = null;
        for (int i = 0; i < listOfCourse.size(); i++) {
            course = listOfCourse.get(i);
            if (course.getTitle().equals(courseTitle)
                    && course.getProgramAndYear().equals(programAndYear)
                    && course.getSemester().equals(semester))
                break;
        }

        return course;
    }
}
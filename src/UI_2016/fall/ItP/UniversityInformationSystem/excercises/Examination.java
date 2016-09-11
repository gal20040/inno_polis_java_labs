package UI_2016.fall.ItP.UniversityInformationSystem.excercises;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.DayOfWeek;

public class Examination extends Exercise {
    public Examination(LectureCourse lectureCourse, int room, DayOfWeek dayOfWeek) {
        super(lectureCourse, room, dayOfWeek);
        //TODO сделать, чтобы экзамен можно было назначать на определённое число в году, а не на день недели
    }
}
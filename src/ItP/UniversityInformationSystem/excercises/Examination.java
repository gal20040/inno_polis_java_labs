package ItP.UniversityInformationSystem.excercises;

import ItP.UniversityInformationSystem.enums.DayOfWeek;

public class Examination extends Exercise {
    public Examination(LectureCourse lectureCourse, int room, DayOfWeek dayOfWeek) {
        super(lectureCourse, room, dayOfWeek);
        //TODO сделать, чтобы экзамен можно было назначать на определённое число в году, а не на день недели
    }
}
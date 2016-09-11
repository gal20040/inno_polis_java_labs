package UI_2016.fall.ItP.UniversityInformationSystem.excercises;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.DayOfWeek;

public class Exercise {
    private LectureCourse lectureCourse;
    private int room;
    private DayOfWeek dayOfWeek;

    Exercise(LectureCourse lectureCourse, int room, DayOfWeek dayOfWeek) {
        this.lectureCourse = lectureCourse;
        this.room = room;
        this.dayOfWeek = dayOfWeek;
    }

    LectureCourse getLectureCourse() {return lectureCourse;}
    int           getRoom() {return room;}
    DayOfWeek     getDayOfWeek() {return dayOfWeek;}

    void setLectureCourse(LectureCourse lectureCourse)   {this.lectureCourse = lectureCourse;}
    void setRoom(int room)                               {this.room = room;}
    void setDayOfWeek(DayOfWeek dayOfWeek)               {this.dayOfWeek = dayOfWeek;}
}
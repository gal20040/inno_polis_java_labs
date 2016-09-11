package UI_2016.fall.ItP.UniversityInformationSystem;


import UI_2016.fall.ItP.UniversityInformationSystem.enums.DayOfWeek;

class Lecture {
    private LectureCourse lectureCourse;
    private int room;
    private DayOfWeek dayOfWeek;

    Lecture(LectureCourse lectureCourse, int room, DayOfWeek dayOfWeek) {
        this.lectureCourse = lectureCourse;
        this.room = room;
        this.dayOfWeek = dayOfWeek;
    }

    public LectureCourse getLectureCourse() {return lectureCourse;}
    public int           getRoom() {return room;}
    public DayOfWeek     getDayOfWeek() {return dayOfWeek;}

    public void setLectureCourse(LectureCourse lectureCourse)   {this.lectureCourse = lectureCourse;}
    public void setRoom(int room)                               {this.room = room;}
    public void setDayOfWeek(DayOfWeek dayOfWeek)               {this.dayOfWeek = dayOfWeek;}
}
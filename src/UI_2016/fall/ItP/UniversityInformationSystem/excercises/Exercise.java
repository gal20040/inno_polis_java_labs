package UI_2016.fall.ItP.UniversityInformationSystem.excercises;

import UI_2016.fall.ItP.UniversityInformationSystem.DateTimeHandler;
import UI_2016.fall.ItP.UniversityInformationSystem.enums.DayOfWeek;

public abstract class Exercise {
    private Course course;
    private String room;
    private DayOfWeek dayOfWeek;
    private long beginTime;

    Exercise(Course course, String room, DayOfWeek dayOfWeek, String beginTime) {
        this.course = course;
        this.room = room;
        this.dayOfWeek = dayOfWeek;

        DateTimeHandler dateTimeHandler = new DateTimeHandler("HH:mm");
        this.beginTime = dateTimeHandler.parseInputTimeString(beginTime);
    }

    public Course getCourse() {return course;}
    public String getRoom() {return room;}
    public DayOfWeek getDayOfWeek() {return dayOfWeek;}

    public long getBeginTimeAsLong() {return beginTime;}
    public String getBeginTimeAsString() {
        DateTimeHandler dateTimeHandler = new DateTimeHandler("HH:mm");
        return dateTimeHandler.getFormattedTime(beginTime);
    }


    public void setCourse(Course course)   {this.course = course;}
    public void setRoom(String room)                               {this.room = room;}
    public void setDayOfWeek(DayOfWeek dayOfWeek)               {this.dayOfWeek = dayOfWeek;}
    public void setBeginTime(String beginTime) {
        DateTimeHandler dateTimeHandler = new DateTimeHandler("HH:mm");
        this.beginTime = dateTimeHandler.parseInputTimeString(beginTime);
    }
    public abstract Exercise getCopy();
}
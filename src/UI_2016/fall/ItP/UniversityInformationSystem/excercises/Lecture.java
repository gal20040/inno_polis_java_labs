package UI_2016.fall.ItP.UniversityInformationSystem.excercises;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.DayOfWeek;

public class Lecture extends Exercise {
    public Lecture(Course course, String room, DayOfWeek dayOfWeek, String beginTime) {
        super(course, room, dayOfWeek, beginTime);
    }

    @Override
    public Lecture getCopy() {
        return new Lecture(this.getCourse(), this.getRoom(),
                this.getDayOfWeek(), this.getBeginTimeAsString());
    }
}
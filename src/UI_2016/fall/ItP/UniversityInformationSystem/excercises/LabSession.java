package UI_2016.fall.ItP.UniversityInformationSystem.excercises;

import UI_2016.fall.ItP.UniversityInformationSystem.enums.DayOfWeek;
import UI_2016.fall.ItP.UniversityInformationSystem.persons.Assistant;

public class LabSession extends Exercise {
    private String subGroup;
    private Assistant assistant;

    public LabSession(Course course, String subGroup, String room, DayOfWeek dayOfWeek, String beginTime, Assistant assistant) {
        super(course, room, dayOfWeek, beginTime);
        this.subGroup = subGroup;

        assert (assistant != null) : "We need assistant!";
        this.assistant = assistant;
    }

    public String getSubGroup() {return subGroup;}
    public void setSubGroup(String subGroup) {
        assert (subGroup != null) : "We need subGroup!";
        this.subGroup = subGroup;}

    public Assistant getAssistant() {return assistant;}
    public void setAssistant(Assistant assistant) {
        assert (assistant != null) : "We need assistant!";
        this.assistant = assistant;}

    @Override
    public LabSession getCopy() {
        return new LabSession(this.getCourse(), this.subGroup, this.getRoom(),
                this.getDayOfWeek(), this.getBeginTimeAsString(), this.assistant);
    }
}
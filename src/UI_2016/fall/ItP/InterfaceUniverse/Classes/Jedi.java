package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Jump;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Run;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Walk;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.UseLightSaber;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Person;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.UseForce;

public class Jedi extends Person implements UseForce, UseLightSaber, Jump, Run, Walk {
    public Jedi(String name, String typeOfIntelligence, Person master, String famousPhrase) {
        super(name, typeOfIntelligence, master, famousPhrase);
    }
}
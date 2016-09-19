package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Ride;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Fly.FlyUsingRocketEngines;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Walk;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Droid;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Person;

public class DroidR2Series extends Droid implements Walk, Ride, FlyUsingRocketEngines {
    public DroidR2Series(String name, String typeOfIntelligence, Person master, String famousPhrase) {
        super(name, typeOfIntelligence, master, famousPhrase);
    }
}
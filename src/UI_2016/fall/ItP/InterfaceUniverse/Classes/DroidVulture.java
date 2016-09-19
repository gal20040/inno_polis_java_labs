package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Fly.FlyInSpace;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Walk;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Droid;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.ShootOutOfBlasterCannon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.Torpedo;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Person;

public class DroidVulture extends Droid implements Walk, FlyInSpace, ShootOutOfBlasterCannon, Torpedo {
    public DroidVulture(String name, String typeOfIntelligence, Person master, String famousPhrase) {
        super(name, typeOfIntelligence, master, famousPhrase);
    }
}
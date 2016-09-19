package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Roll;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Walk;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Droid;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.ShootOutOfBlasterCannon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.UseDeflectorShield;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Person;

public class Droideka extends Droid implements Walk, Roll, UseDeflectorShield, ShootOutOfBlasterCannon {
    public Droideka(String name, String typeOfIntelligence, Person master, String famousPhrase) {
        super(name, typeOfIntelligence, master, famousPhrase);
    }
}
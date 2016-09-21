package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Fly.FlyUsingWings;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Jump;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Run;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Walk;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.LivingOrganism;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Person;

public class Toydarian extends LivingOrganism implements FlyUsingWings, Jump, Run, Walk {
    private String className = "тойдарианец";
    @Override
    public void demonstrateOneself() {System.out.println("Я - " + this.className + ".");}

    public Toydarian(String name, String typeOfIntelligence, Person master, String famousPhrase) {
        super(name, typeOfIntelligence, master, famousPhrase);
    }
}
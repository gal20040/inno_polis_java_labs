package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Jump;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Run;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Walk;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.SomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.UseSomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Person;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Defending.UseForce;
import java.util.ArrayList;

public class Jedi extends Person implements UseForce, Jump, Run, Walk, UseSomeWeapon {
    private final String className = "джедай";
    private ArrayList<SomeWeapon> weaponList;

    @Override
    public ArrayList<SomeWeapon> getWeapon() {return weaponList;}
    @Override
    public void setWeapon(ArrayList<SomeWeapon> weaponList) {this.weaponList = weaponList;}

    @Override
    public void demonstrateOneself() {
        System.out.println("Я - " + this.className + ".");
        for (SomeWeapon weapon : weaponList) {
            weapon.printOutWeaponDescription();
        }

        moveSomeObjectUsingForce();
    }

    public Jedi(String name, String typeOfIntelligence, Person master,
                String famousPhrase, ArrayList<SomeWeapon> weaponList) {
        super(name, typeOfIntelligence, master, famousPhrase);
        this.weaponList = weaponList;
    }

    @Override
    public void moveSomeObjectUsingForce() {
        System.out.println("Я могу передвигать предметы силой мысли! Да пребудет с тобой сила!");
    }
}
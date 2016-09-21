package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Roll;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Walk;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.SomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.UseSomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Droid;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Defending.UseDeflectorShield;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Person;
import java.util.ArrayList;

public class Droideka extends Droid implements Walk, Roll, UseDeflectorShield, UseSomeWeapon {
    private String className = "боевой дроид дроидека, дроид-колесо или «перекати-смерть»";
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
    }

    public Droideka(String name, String typeOfIntelligence, Person master,
                    String famousPhrase, ArrayList<SomeWeapon> weaponList) {
        super(name, typeOfIntelligence, master, famousPhrase);
        this.weaponList = weaponList;
    }

    @Override
    public int absorbSomeDamage() {return 80;}

    @Override
    public String printOutNameOfArmorOrShield() {return this.nameOfArmorOrShield;}
}
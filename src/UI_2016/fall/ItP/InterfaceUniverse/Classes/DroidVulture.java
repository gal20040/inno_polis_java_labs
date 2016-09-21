package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Fly.FlyInSpace;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Walk;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.SomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.UseSomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Droid;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons.Person;
import java.util.ArrayList;

public class DroidVulture extends Droid
        implements Walk, FlyInSpace, UseSomeWeapon { //ShootOutOfBlasterCannon, LaunchTorpedo
    private String correctClassName = "боевой дроид-истребитель с изменяемой геометрией модели I, или истребитель «Cтервятник»";
    private ArrayList<SomeWeapon> weaponList;

    @Override
    public ArrayList<SomeWeapon> getWeapon() {return weaponList;}
    @Override
    public void setWeapon(ArrayList<SomeWeapon> weaponList) {this.weaponList = weaponList;}

    @Override
    public void demonstrateOneself() {
        System.out.println("Я - " + this.correctClassName + ".");
        for (SomeWeapon weapon : weaponList) {
            weapon.printOutWeaponDescription();
        }
    }

    public DroidVulture(String name, String typeOfIntelligence, Person master,
                        String famousPhrase, ArrayList<SomeWeapon> weaponList) {
        super(name, typeOfIntelligence, master, famousPhrase);
        this.weaponList = weaponList;
    }
}
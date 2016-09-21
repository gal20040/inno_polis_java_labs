package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Fly.FlyNearGround;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.SomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.UseSomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle.CanTransportPassangers;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle.SpeederBike;

import java.util.ArrayList;

public class SpeederBike74_Z extends SpeederBike implements CanTransportPassangers, FlyNearGround, UseSomeWeapon {
    private final String className = "лёгкий одноместный скоростной транспорт";
    private ArrayList<SomeWeapon> weaponList;

    public SpeederBike74_Z(String name, ArrayList<SomeWeapon> weaponList) {
        super(name);
        this.weaponList = weaponList;
    }

    @Override
    public ArrayList<SomeWeapon> getWeapon() {return weaponList;}
    @Override
    public void setWeapon(ArrayList<SomeWeapon> weaponList) {this.weaponList = weaponList;}

    @Override
    public void demonstrateOneself() {
        System.out.println(this.className + ".");
        for (SomeWeapon weapon : weaponList) {
            weapon.printOutWeaponDescription();
        }
    }
}
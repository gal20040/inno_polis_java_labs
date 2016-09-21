package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.SomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.UseSomeWeapon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle.CanTransportPassangers;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle.CanTransportVehicles;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle.Walker;
import java.util.ArrayList;

public class WalkerATAT extends Walker
        implements UseSomeWeapon, CanTransportVehicles, CanTransportPassangers {
    private final String className = "бронированный транспортный вездеход";
    private ArrayList<SomeWeapon> weaponList;

    public WalkerATAT(String name, ArrayList<SomeWeapon> weaponList) {
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
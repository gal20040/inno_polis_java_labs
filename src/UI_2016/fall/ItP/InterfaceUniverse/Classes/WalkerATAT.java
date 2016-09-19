package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle.CanTransport;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.ShootOutOfBlasterCannon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.ShootOutOfLaserCannon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle.Walker;

public class WalkerATAT extends Walker implements ShootOutOfLaserCannon, ShootOutOfBlasterCannon, CanTransport {
    public WalkerATAT(String name) {super(name);}
}
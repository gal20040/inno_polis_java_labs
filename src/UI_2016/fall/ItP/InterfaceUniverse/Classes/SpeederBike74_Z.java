package UI_2016.fall.ItP.InterfaceUniverse.Classes;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.ByTheMannerOfMoving.Fly.FlyNearGround;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle.CanTransport;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.ShootOutOfBlasterCannon;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle.SpeederBike;

public class SpeederBike74_Z extends SpeederBike implements ShootOutOfBlasterCannon, CanTransport, FlyNearGround {
    public SpeederBike74_Z(String name) {super(name);}
}
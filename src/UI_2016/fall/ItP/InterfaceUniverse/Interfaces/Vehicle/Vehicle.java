package UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Vehicle;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Base.HasDescription;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Base.HasName;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Base.DemonstrateOneself;

abstract class Vehicle implements DemonstrateOneself, HasName, HasDescription, HasCrew {
    private String name;
    //TODO сделать описание команды

    Vehicle(String name) {
        checkNameForCorrectness(name);
        this.name = name;
    }

    private void checkNameForCorrectness(String name) {
        assert !(name.equals("")
                || (name == null)) : "Параметр name не задан.";
    }

    @Override
    public String getName() {return name;}
    @Override
    public void setName(String name) {
        checkNameForCorrectness(name);
        this.name = name;}

    @Override
    public void printOutDescription() {
        System.out.print("Название: " + getName() + " - ");
        demonstrateOneself();

        System.out.println();
    }
}
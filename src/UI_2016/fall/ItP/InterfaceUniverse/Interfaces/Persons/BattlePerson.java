//package UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons;
//
//import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.SomeWeapon;
//import java.util.ArrayList;
//
//public abstract class BattlePerson extends Person implements iBattlePerson {
//    public BattlePerson(String name, String typeOfIntelligence, Person master, String famousPhrase) {
//        super(name, typeOfIntelligence, master, famousPhrase);
//    }
//    private BattlePerson determinedObject = getDeterminedObject();
//
//    @Override
//    public ArrayList<SomeWeapon> getWeapon() {return determinedObject.getWeapon();}
//    @Override
//    public void setWeapon(ArrayList<SomeWeapon> weaponList) {this.weaponList = weaponList;}
//
//    @Override
//    public void demonstrateOneself() {
////        determinedObject = getDeterminedObject();
//        System.out.println("Я - " + determinedObject.weaponList + ".");
//        for (SomeWeapon weapon : weaponList) {
//            weapon.printOutWeaponDescription();
//        }
//    }
//
//    abstract BattlePerson getDeterminedObject();
//}
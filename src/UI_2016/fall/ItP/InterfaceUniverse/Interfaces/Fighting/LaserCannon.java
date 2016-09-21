package UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting;

public class LaserCannon implements SetWeaponCharacteristics, SomeWeapon {
    private int damageRate = 200;
    private String nameOfWeapon = "Laser cannon";

    @Override
    public int getDamageRate() {return damageRate;}
    @Override
    public void setDamageRate(int damageRate) {this.damageRate = damageRate;}
    @Override
    public String getNameOfWeapon() {return nameOfWeapon;}
    @Override
    public void setNameOfWeapon(String nameOfWeapon) {this.nameOfWeapon = nameOfWeapon;}

    @Override
    public void printOutWeaponDescription() {
        System.out.println(String.format(outputStringTemplate, getNameOfWeapon(), getDamageRate()));
    }
}
//package UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting;
//
//abstract class AbstractWeapon implements SetWeaponCharacteristics, SomeWeapon /*HasDescription, */{
//    private int damageRate = getDefaultDamageRate();
//    private String nameOfWeapon = getDefaultNameOfWeapon();
//
//    abstract int getDefaultDamageRate();
//    abstract String getDefaultNameOfWeapon();
//
//    @Override
//    public int getDamageRate() {return damageRate;}
//    @Override
//    public void setDamageRate(int damageRate) {this.damageRate = damageRate;}
//    @Override
//    public String getNameOfWeapon() {return nameOfWeapon;}
//    @Override
//    public void setNameOfWeapon(String nameOfWeapon) {this.nameOfWeapon = nameOfWeapon;}
//
//    @Override
//    public void printOutWeaponDescription() {
//        System.out.println(String.format(outputStringTemplate, getNameOfWeapon(), getDamageRate()));
//    }
//}
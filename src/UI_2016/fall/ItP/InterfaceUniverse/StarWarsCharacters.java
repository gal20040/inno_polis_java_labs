package UI_2016.fall.ItP.InterfaceUniverse;

import UI_2016.fall.ItP.InterfaceUniverse.Classes.*;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Fighting.*;
import java.util.ArrayList;

public class StarWarsCharacters {
    public static void main(String[] args) {
        ArrayList<SomeWeapon> weaponList = new ArrayList<>();

        //http://ru.starwars.wikia.com/wiki/Энакин Скайуокер
        weaponList.add(new LightSaber());
        Jedi anakin_Skywalker = new Jedi("Anakin Skywalker", "NI", null,
                "Я человек, и моё имя — Энакин!", weaponList);
        anakin_Skywalker.introduceItself();
        weaponList.clear();

        //http://ru.starwars.wikia.com/wiki/C-3PO
        Droid3POSeries c_3PO = new Droid3POSeries("C-3PO", "AI", anakin_Skywalker, "Кто-нибудь! Помогите! Пожалуйста, помогите! Мы обречены!");
        c_3PO.introduceItself();

        //Я хозяин магазина запчастей в Мос Эспа на планете Татуин.
        //http://ru.starwars.wikia.com/wiki/Уотто
        Toydarian watto = new Toydarian("Watto", "NI", null,
                "И что это Вы рукой машете, словно джедай какой-нибудь?"
                        + " Я — тойдарианец, и ваши штучки на меня не действуют, только деньги.");
        watto.introduceItself();

        //http://ru.starwars.wikia.com/wiki/R2-D2
        DroidR2Series r2d2 = new DroidR2Series("R2-D2", "AI", anakin_Skywalker, "zzz-zz-zz---zzz-zz--z-z-z--z"); //TODO найти хорошую фразу
        r2d2.introduceItself();

        //http://ru.starwars.wikia.com/wiki/Дроидека
        weaponList.add(new BlasterCannon());
        Droideka droideka1 = new Droideka("droideka1", "AI", null, "Пиу-пиу!", weaponList);
        droideka1.introduceItself();
        weaponList.clear();

        //http://ru.starwars.wikia.com/wiki/Боевой дроид-истребитель с изменяемой геометрией
        weaponList.add(new BlasterCannon());
        weaponList.add(new Torpedo());
        DroidVulture vulture1 = new DroidVulture("vulture1", "AI", null, "Пиу-пиу! Бдыщь!", weaponList);
        vulture1.introduceItself();
        weaponList.clear();

        //http://ru.starwars.wikia.com/wiki/AT-AT
        weaponList.add(new LaserCannon());
        weaponList.add(new BlasterCannon());
        WalkerATAT walkerATAT = new WalkerATAT("walkerATAT", weaponList);
        walkerATAT.printOutDescription();
        weaponList.clear();

        //http://ru.starwars.wikia.com/wiki/Спидербайк_74-Z
        weaponList.add(new BlasterCannon());
        SpeederBike74_Z speederBike74_Z = new SpeederBike74_Z("SpeederBike74-Z", weaponList);
        speederBike74_Z.printOutDescription();
        weaponList.clear();
    }
}
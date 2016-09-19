package UI_2016.fall.ItP.InterfaceUniverse;

import UI_2016.fall.ItP.InterfaceUniverse.Classes.*;

public class StarWarsCharacters {
    public static void main(String[] args) {
        //http://ru.starwars.wikia.com/wiki/Энакин Скайуокер
        Jedi anakin_Skywalker = new Jedi("Anakin Skywalker", "NI", null, "Я человек, и моё имя — Энакин!");
        anakin_Skywalker.introduceItself();

        ////http://ru.starwars.wikia.com/wiki/C-3PO
        Droid3POSeries c_3PO = new Droid3POSeries("C-3PO", "AI", anakin_Skywalker, "Кто-нибудь! Помогите! Пожалуйста, помогите! Мы обречены!");
        c_3PO.introduceItself();

        //Я хозяин магазина запчастей в Мос Эспа на планете Татуин.
        ////http://ru.starwars.wikia.com/wiki/Уотто
        Toydarian watto = new Toydarian("Watto", "NI", null,
                "И что это Вы рукой машете, словно джедай какой-нибудь?"
                        + " Я — тойдарианец, и ваши штучки на меня не действуют, только деньги.");
        watto.introduceItself();

        ////http://ru.starwars.wikia.com/wiki/R2-D2
        DroidR2Series r2d2 = new DroidR2Series("R2-D2", "AI", anakin_Skywalker, "zzz-zz-zz---zzz-zz--z-z-z--z"); //TODO найти фразу
        r2d2.introduceItself();

        //http://ru.starwars.wikia.com/wiki/Дроидека
        Droideka droideka1 = new Droideka("droideka1", "AI", null, "Пиу-пиу!");
        droideka1.introduceItself();

        //http://ru.starwars.wikia.com/wiki/Боевой дроид-истребитель с изменяемой геометрией
        DroidVulture vulture1 = new DroidVulture("vulture1", "AI", null, "Пиу-пиу! Бдыщь!");
        vulture1.introduceItself();

        //http://ru.starwars.wikia.com/wiki/AT-AT
        WalkerATAT walkerATAT = new WalkerATAT("walkerATAT");
        walkerATAT.printOutDescription();

        //http://ru.starwars.wikia.com/wiki/Спидербайк_74-Z
        SpeederBike74_Z speederBike74_Z = new SpeederBike74_Z("SpeederBike74-Z");
        speederBike74_Z.printOutDescription();
    }
}
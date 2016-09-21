package UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Persons;

import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Base.HasName;
import UI_2016.fall.ItP.InterfaceUniverse.Interfaces.Base.demonstrateOneself;

public abstract class Person implements demonstrateOneself, Intelligence, HasName, HasFamousPhrase, HasMaster {
    private String name;
    private Person master;
    private String famousPhrase;
    private String typeOfIntelligence;

    public Person(String name, String typeOfIntelligence, Person master, String famousPhrase) {
        checkNameForCorrectness(name);
        this.name = name;
        assert !(typeOfIntelligence.equals("")
                || (typeOfIntelligence == null)
                || !typeOfIntelligence.equals("NI")
                && !typeOfIntelligence.equals("AI")) : "Параметр typeOfIntelligence задан не правильно.";
        this.typeOfIntelligence = typeOfIntelligence;
        this.master = master;
        this.famousPhrase = famousPhrase;
    }

    private void checkNameForCorrectness(String name) {
        assert !(name.equals("")
                || (name == null)) : "Параметр name не задан.";
    }

    @Override
    public String getTypeOfIntelligence() {return typeOfIntelligence;}

    @Override
    public String getName() {return name;}
    @Override
    public void setName(String name) {
        checkNameForCorrectness(name);
        this.name = name;}

    @Override
    public void introduceItself() {
        System.out.println("Меня зовут " + getName() + ".");

        demonstrateOneself();

        if (!(getMaster() == null))
            System.out.println("Моего хозяина зовут " + getMaster().getName());
        if (getTypeOfIntelligence().equals("AI"))
            System.out.println("У меня искуственный интеллект.");

        if (!(getFamousPhrase() == null)
                && !getFamousPhrase().equals(""))
            System.out.println(getFamousPhrase());

        System.out.println();
    }

    @Override
    public String getFamousPhrase() {return famousPhrase;}
    @Override
    public void setFamousPhrase(String famousPhrase) {this.famousPhrase = famousPhrase;}

    @Override
    public Person getMaster() {return master;}
    @Override
    public void setMaster(Person master) {this.master = master;}
}
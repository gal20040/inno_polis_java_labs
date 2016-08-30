package InnoBootCamp2016.homework2;

class Book {
    String title;
    String author;
    private int year;
    int numberPages;
    int overdueFine;
    float value;
    boolean status = false; //true = read

    Book(String title, String author, int year, int numberPages, int overdueFine) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.numberPages = numberPages;
        this.overdueFine = overdueFine;
        this.value = (float) (overdueFine) / (float) (numberPages);
    }
}
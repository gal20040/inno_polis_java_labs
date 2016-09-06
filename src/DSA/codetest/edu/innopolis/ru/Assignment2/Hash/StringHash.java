package DSA.codetest.edu.innopolis.ru.Assignment2.Hash;

//https://www.google.ru/search?q=Linear+probing&oq=Linear+probing&aqs=chrome..69i57&sourceid=chrome&ie=UTF-8#newwindow=1&safe=strict&q=Linear+probing+Open+addressing
//http://www.algolist.net/Data_structures/Hash_table/Open_addressing
//https://en.wikipedia.org/wiki/Linear_probing
//https://en.wikipedia.org/wiki/Open_addressing
//http://www.seostella.com/ru/article/2012/08/09/kollekcii-collections-v-java-map.html

public class StringHash {
    public static void main(String[] args) {
        // Java uses polynomial function with base 31
// for string hashing
        String a = "A Test";
        String b = "B Test";
        String c = "C Test";
        long power4 = 31 * 31 * 31 * 31;
        System.out.println(a.hashCode() % power4);
        System.out.println(b.hashCode() % power4);
        System.out.println(c.hashCode() % power4);
        a = "Question.";
        b = "Question!";
        System.out.println(a.hashCode() / 31);
        System.out.println(b.hashCode() / 31);
    }
}

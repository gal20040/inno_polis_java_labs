package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.TopContributor;

import java.util.ArrayList;

/**
 * Statement
 * Company HEAPSOFT runs charity maraphon and wants to publish the most generous client at the website.
 * Their website have no caching, so each time someone opens the page, the data is requested directly from server.
 * Senior programmer Arkeap says that the best way to implement storage of contributions is to use priority queue.
 * His boss has no idea what is this, so the implementation is up to junior programmer (you).
 * Arkheap hints you that writing your own heap is a good idea.
 * Boss checks website each one hour withing some interval (including margins). What will he see?
 *
 * In the first line of input.txt you are given the interval of boss checking website.
 * In other lines - personal payments: NAME: SUM at TIME.
 *
 * output.txt should contain lines with TIME: NAME_OF_THE_GENEROUS.

 Example
  input.txt
Boss: 2016-10-18T12:00 - 2016-10-18T14:00
Cathi Gratz: 100 at 2016-10-18T11:15
Shaquita Lobb: 1000 at 2016-10-18T11:38
Isabelle Nicoletti: 100 at 2016-10-18T12:31
Willian Mcnett: 1001 at 2016-10-18T12:32
Rutha Mucci: 1000 at 2016-10-18T13:31
Mariela Caples: 1002 at 2016-10-18T13:50
Miyoko Brodbeck: 10000 at 2016-10-18T14:10

 output.txt
 2016-10-18T12:00: Shaquita Lobb
 2016-10-18T13:00: Willian Mcnett
 2016-10-18T14:00: Mariela Caples

Boss: 2016-10-18T12:00 - 2016-10-18T23:00
Cathi Gratz: 100 at 2016-10-18T11:15
Shaquita Lobb: 1000 at 2016-10-18T11:38
Isabelle Nicoletti: 100 at 2016-10-18T12:31
Willian Mcnett: 1001 at 2016-10-18T12:32
Rutha Mucci: 1000 at 2016-10-18T13:31
Mariela Caples: 1002 at 2016-10-18T13:50
Miyoko Brodbeck: 10000 at 2016-10-18T14:10
Spring Ferrari: 10001 at 2016-10-18T14:34
Hope Purpura: 100 at 2016-10-18T15:29
Georgianna Skoog: 50000 at 2016-10-18T15:31
Derrick Deslauriers: 55000 at 2016-10-18T16:15
Shayna Ovalle: 55001 at 2016-10-18T16:40
Marge Pollack: 55000 at 2016-10-18T17:10
Corrie Fern: 100 at 2016-10-18T17:40
Trish Badilla: 70 at 2016-10-18T18:38
Donya Bozarth: 1 at 2016-10-18T19:00
Dominga Leaton: 55002 at 2016-10-18T19:40
Dawn Hyde: 100000 at 2016-10-18T20:30
Ginette Norville: 100001 at 2016-10-18T23:50
Twanda Disney: 100003 at 2016-10-19T03:09


Boss: 2016-10-18T16:00 - 2016-10-19T04:00
Cathi Gratz: 100 at 2016-10-18T11:15
Shaquita Lobb: 1000 at 2016-10-18T11:38
Isabelle Nicoletti: 100 at 2016-10-18T12:31
Willian Mcnett: 1001 at 2016-10-18T12:32
Rutha Mucci: 1000 at 2016-10-18T13:31
Mariela Caples: 1002 at 2016-10-18T13:50
Miyoko Brodbeck: 10000 at 2016-10-18T14:10
Spring Ferrari: 10001 at 2016-10-18T14:34
Hope Purpura: 100 at 2016-10-18T15:29
Georgianna Skoog: 50000 at 2016-10-18T15:31
Derrick Deslauriers: 55000 at 2016-10-18T16:15
Shayna Ovalle: 55001 at 2016-10-18T16:40
Marge Pollack: 55000 at 2016-10-18T17:10
Corrie Fern: 100 at 2016-10-18T17:40
Trish Badilla: 70 at 2016-10-18T18:38
Donya Bozarth: 1 at 2016-10-18T19:00
Dominga Leaton: 55002 at 2016-10-18T19:40
Dawn Hyde: 100000 at 2016-10-18T20:30
Ginette Norville: 100001 at 2016-10-18T23:50
Twanda Disney: 100003 at 2016-10-19T03:09
 */


class TopContributor {
    public static void main(String[] args) {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<String> inputList = fileReaderWriter.readFromInputFile();

        InputParser inputParser = new InputParser();
        String outputString = inputParser.parse(inputList);

        fileReaderWriter.writeToOutputFile(outputString);
    }
}
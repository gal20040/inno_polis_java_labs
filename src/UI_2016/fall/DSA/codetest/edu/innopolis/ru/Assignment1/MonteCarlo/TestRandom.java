//package DSA.codetest.edu.innopolis.ru.Assignment1.MonteCarlo;
//
//import java.util.Date;
//import java.util.Random;
//
//public class TestRandom {
//    public static void main(String[] args) {
//        double minXY = -1, maxXY = 1, average = 0, newNumber, summ = 0;
//        long date, oldDate = 0, newSeed;
//        int counter = 0, i = 0, count_1 = 0, count1 = 0, count0 = 0;
//        Random r;
//        newSeed = new Date().getTime();
//        while (counter < 500000) {
//            r = new Random(newSeed);
//            r.nextDouble();
////            if (date != oldDate) {
//                System.out.print(newSeed + " ");
//
////                System.out.print(r.nextDouble() + " ");
//                counter++;
//                newNumber = minXY + (maxXY - minXY) * r.nextDouble();
//            newSeed = (long) (newNumber * Math.pow(10, 12))/1;
//
//                summ += newNumber;
//                average = summ / counter;
//                System.out.print(newNumber + " ");
//                System.out.print(average + " ");
//                System.out.print(summ + " ");
//                System.out.print(counter + " ");
//                if (newNumber < 0)
//                    count_1++;
//                else if (newNumber > 0)
//                    count1++;
//                else if (newNumber == 0)
//                    count0++;
//
//                System.out.print(count_1 + " ");
//                System.out.print(count0 + " ");
//                System.out.println(count1 + " ");
////            }
////            oldDate = date;
//        }
//    }
//}
package codetest.edu.innopolis.ru.DoubleMess;

import java.lang.Math;

/**Statement
 * You found the data in a very strange format.
 * Then you understood, that previous developer mixed sign S, significand M and exponent E in a double!
 * Now they are in the following order: MES. Fix it. Read input.txt file. Write fixed result to output.txt.

 * Example:

 input.txt
 1.0207E-320

 output.txt
 1024.0

 https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%BE_%D1%81_%D0%BF%D0%BB%D0%B0%D0%B2%D0%B0%D1%8E%D1%89%D0%B5%D0%B9_%D0%B7%D0%B0%D0%BF%D1%8F%D1%82%D0%BE%D0%B9
 https://habrahabr.ru/post/112953/
 */
public class Solution {
    public static void main(String[] args) {
        double d = 1.0207e-320, min = d;
//        d = 0.010e3;

//        while (true) {
//            d = d / 10;
//            System.out.println(d);
//            if (min > d) {
//                min = d;
//            } else break;
//        }
//        System.out.println(d * 1.0E+308 * 1.0E+15);
        System.out.println(d);
        float f = 0.2f;
        System.out.println(f + f);

        Double x;
        int power = 3;
        int B = 10;
        x = 1*Math.pow(B, power) + 0*Math.pow(B, power-1) + 2*Math.pow(B, power-2) + 0*Math.pow(B, power-3)
                + 7*Math.pow(B, power-4);
        System.out.println(x);

        power = 3;
        B = 10;
        x = 1*Math.pow(B, power) + 2*Math.pow(B, power-2) + 7*Math.pow(B, power-4);
        System.out.println(x);
    }
}
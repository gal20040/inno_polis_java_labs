package UI_2016.fall.ru.Assignment1.MonteCarlo;

import java.util.Date;
import java.util.Random;

/**
 * Statement
 4 points
 1. Implement your own ArrayList class with extension.
 2. Use Monte Carlo method of integration to calculate the area of the polygon. This require previously implemented method "point in polygon". Set integration accuracy to 1E-4 (if next iteration change the value less than for 1E-4 - you are done).
 3. Write result rounded to 2 decimal digits after the point.

 Inside input.txt there are double coordinates of polygon like x1 y1 x2 y2 x3 y3.... Write area to output.txt.
 Example #1
 input.txt
 1.0 1.0 2.0 1.0 2.0 2.0 1.0 2.0
 output.txt
 1.00

 Example #2
 input.txt
 -0.5 0.0 0.0 0.86602540378444 0.5 0.0
 output.txt
 0.43

 Example #3
 input.txt
 -1.0 -1.0 2.0 -1.0 2.0 3.0 -1.0 2.0
 output.txt
 10.50

 Example #4
 input.txt
 0.99240 0.12309 0.38960 0.92098 -0.60279 0.79790 -0.99240 -0.12309 -0.38960 -0.92098 0.60279 -0.79790
 output.txt
 2.60
 */

class MonteCarlo {
    private static Random r = new Random(new Date().getTime());

    public static void main(String[] args) {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        MyArrayList<Integer> inputArray = fileReaderWriter.readFromInputFile();
        Polygon polygon = new Polygon();

        MyArrayList<Double> doubleArray = parseInput(inputArray);
        inputArray = null; //we dont' need it anymore
        for (int i = 0; i < doubleArray.getSize(); ) {
            polygon.addPointInArray(new Point2D(doubleArray.get(i), doubleArray.get(i+1)));
            doubleArray.remove(i);
            doubleArray.remove(i);
        }
        doubleArray = null; //we dont' need it anymore

        OuterFoursquare outerFoursquare = new OuterFoursquare();
        outerFoursquare.initialiseOuterFoursquare(polygon);

        double areaOfPolygon = evaluateAreaOfPolygon(polygon, outerFoursquare.getArea());

        fileReaderWriter.writeToOutputFile(String.format("%.2f", areaOfPolygon));
    }

    private static MyArrayList<Double> parseInput(MyArrayList<Integer> inputArray) {
        MyArrayList<Double> doubleArray = new MyArrayList<>();
        double d, tempDouble;
        boolean nowWeAreProcessingNumber = false, nowWeAreProcessingFractionalPart = false;
        boolean negativeNumber = false;
        int rate = 1;

        for (int i = 0; i < inputArray.getSize(); i++) {
            char sign = (char) (inputArray.get(i) + 0); //without '+ 0' compiler refuses to cast Integer into char

            switch (sign) {
                case ' ':
                    negativeNumber = false;
                    nowWeAreProcessingNumber = false;
                    nowWeAreProcessingFractionalPart = false;
                    rate = 1;
                    break;
                case '.':
                    nowWeAreProcessingFractionalPart = true;
                    rate = 1;
                    break;
                case '-':
                    negativeNumber = true;
                    break;
                default: {
                    if (isNumeric(sign + "")) {
                        // if it's a number
                        tempDouble = 0;
                        if (nowWeAreProcessingNumber) {
                            if (nowWeAreProcessingFractionalPart) {
                                tempDouble = Math.abs(doubleArray.getLast());
                                rate = rate * 10;
                            } else {
                                tempDouble = Math.abs(doubleArray.getLast() * 10);
                            }
                            doubleArray.remove(doubleArray.getSize() - 1);
                        }
                        d = tempDouble + Double.parseDouble(sign + "") / rate;
                        if (negativeNumber)
                            d = d * (-1);
                        doubleArray.add(d);
                        nowWeAreProcessingNumber = true;
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < doubleArray.getSize(); i++) {
            System.out.println(doubleArray.get(i));
        }

        return doubleArray;
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
        // '-' and decimal.
    }

    private static double evaluateAreaOfPolygon(Polygon polygon, double areaOfOuterFoursquare) {
        double areaOfPolygon = -1.0;

        int i = 0;
        int counterOfInsidePoints = 0;

        while (counterOfInsidePoints <= 1000000) {
            if (polygon.isPointInside(new Point2D(getRandomDouble(), getRandomDouble())))
                counterOfInsidePoints++;
            if (i > 0) {
                areaOfPolygon = areaOfOuterFoursquare * counterOfInsidePoints / i;

//                if (counterOfInsidePoints % 50000 == 0)
//                    System.out.println(i + " " + counterOfInsidePoints
//                            + " " + String.format("%.7f", (double) (counterOfInsidePoints / (i+1.0-1.0)))
////                        + " " + prevAreaValue + " " + !String.format("%.5f", areaOfPolygon).equals(prevAreaValue)
////                        + " " + lastAreaValue + " " + !String.format("%.5f", areaOfPolygon).equals(lastAreaValue)
////                        + " " + (!String.format("%.5f", areaOfPolygon).equals(prevAreaValue) || !String.format("%.5f", areaOfPolygon).equals(lastAreaValue))
//                            + " " + String.format("%.7f", areaOfPolygon)
//                            + " " + String.format("%.2f", areaOfPolygon));
            }
            i++;
        }

        return areaOfPolygon;
    }

    private static Double getRandomDouble() {
        return (OuterFoursquare.minXY + (OuterFoursquare.maxXY - OuterFoursquare.minXY) * r.nextDouble());
    }
}
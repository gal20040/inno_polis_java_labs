package DSA.codetest.edu.innopolis.ru.Assignment1.MonteCarlo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

class MonteCarlo {
//    private static double minXY = 0;
//    private static double maxXY = 0;
    private static Random r = new Random(new Date().getTime());

    public static void main(String[] args) {
        Polygon polygon = createPolygon();
        OuterFoursquare outerFoursquare = new OuterFoursquare();
//        createOuterRectangle(polygon);
        double areaOfOuterFoursquare = outerFoursquare.getArea();
        double areaOfPolygon = -1.0;
        double summaryAreaOfPolygon = 0.0;
        double averageAreaOfPolygon;
        int counterOfInsidePoints = 0;
        String lastAreaValue = "", prevAreaValue = "";

        int i = 0;
        while (counterOfInsidePoints <= 1000000
                || (!String.format("%.5f", areaOfPolygon).equals(lastAreaValue)
                && !String.format("%.5f", areaOfPolygon).equals(prevAreaValue))) {
            prevAreaValue = lastAreaValue;
            lastAreaValue = String.format("%.5f", areaOfPolygon);
            if (isInside(polygon, new Point2D(getRandomDouble(), getRandomDouble())))
                counterOfInsidePoints++;
            if (i > 0) {
                areaOfPolygon = areaOfOuterFoursquare * counterOfInsidePoints / i;

                if (counterOfInsidePoints % 50000 == 0)
                    System.out.println(i + " " + counterOfInsidePoints
                            + " " + String.format("%.7f", (double) (counterOfInsidePoints / (i+1.0-1.0)))
//                        + " " + prevAreaValue + " " + !String.format("%.5f", areaOfPolygon).equals(prevAreaValue)
//                        + " " + lastAreaValue + " " + !String.format("%.5f", areaOfPolygon).equals(lastAreaValue)
//                        + " " + (!String.format("%.5f", areaOfPolygon).equals(prevAreaValue) || !String.format("%.5f", areaOfPolygon).equals(lastAreaValue))
                            + " " + String.format("%.7f", areaOfPolygon)
                            + " " + String.format("%.2f", areaOfPolygon));
            }
            i++;
        }

//        System.out.println(counterOfInsidePoints + " " + areaOfPolygon + " " + prevAreaValue
//        + " " + lastAreaValue + " " + String.format("%.2f", areaOfPolygon));
    }

//    private static double getArea() {
//        return Math.pow(maxXY - minXY, 2);
//    }

    private static Polygon createPolygon() {
        Polygon polygon = new Polygon();

//        Point2D p0 = new Point2D(1.0, 1.0);
//        Point2D p1 = new Point2D(2.0, 1.0);
//        Point2D p2 = new Point2D(2.0, 2.0);
//        Point2D p3 = new Point2D(1.0, 2.0);
//        polygon.addPointInArray(p0);
//        polygon.addPointInArray(p1);
//        polygon.addPointInArray(p2);
//        polygon.addPointInArray(p3);
        /*1*/

//        Point2D p0 = new Point2D(-0.5, 0.0);
//        Point2D p1 = new Point2D(0.0, 0.86602540378444);
//        Point2D p2 = new Point2D(0.5, 0.0);
//        polygon.addPointInArray(p0);
//        polygon.addPointInArray(p1);
//        polygon.addPointInArray(p2);
        /*0.43*/

//        Point2D p0 = new Point2D(-1.0, -1.0);
//        Point2D p1 = new Point2D(2.0, -1.0);
//        Point2D p2 = new Point2D(2.0, 3.0);
//        Point2D p3 = new Point2D(-1.0, 2.0);
//        polygon.addPointInArray(p0);
//        polygon.addPointInArray(p1);
//        polygon.addPointInArray(p2);
//        polygon.addPointInArray(p3);
        /*10.50*/

        Point2D p0 = new Point2D(-1.0, -1.0);
        Point2D p1 = new Point2D(2.0, -1.0);
        Point2D p2 = new Point2D(0.5, 2.0);
        polygon.addPointInArray(p0);
        polygon.addPointInArray(p1);
        polygon.addPointInArray(p2);
        /*4.5*/

//        Point2D p0 = new Point2D(1.0, 1.0);
//        Point2D p1 = new Point2D(4.0, 1.0);
//        Point2D p2 = new Point2D(2.5, 4.0);
//        polygon.getPointsArray().add(p0);
//        polygon.getPointsArray().add(p1);
//        polygon.getPointsArray().add(p2);

        return polygon;
    }

//    /**
//     * Create auxiliary outer rectangle
//     * @input Polygon polygon - measuring polygon.
//     * @return Polygon outerRectangle - auxiliary outer rectangle
//     */
//    private static Polygon createOuterRectangle(Polygon polygon) {
////        double  minX = polygon.getPointsArray().get(0).getX() - 1.0,
////                maxX = polygon.getPointsArray().get(0).getX() + 1.0,
////                minY = polygon.getPointsArray().get(0).getY() - 1.0,
////                maxY = polygon.getPointsArray().get(0).getY() + 1.0;
//
////        for (int i = 1; i < polygon.getEdgeNumber(); i++) {
////            if (minX > polygon.getPointsArray().get(i).getX() - 1.0)
////                minX = polygon.getPointsArray().get(i).getX() - 1.0;
////            if (maxX < polygon.getPointsArray().get(i).getX() + 1.0)
////                maxX = polygon.getPointsArray().get(i).getX() + 1.0;
////            if (minY > polygon.getPointsArray().get(i).getY() - 1.0)
////                minY = polygon.getPointsArray().get(i).getY() - 1.0;
////            if (maxY < polygon.getPointsArray().get(i).getY() + 1.0)
////                maxY = polygon.getPointsArray().get(i).getY() + 1.0;
////        }
//        double margin = 0;
//        for (int i = 0; i < polygon.getEdgeNumber(); i++) {
//            if (minXY > polygon.getPointsArray().get(i).getX() - margin)
//                minXY = polygon.getPointsArray().get(i).getX() - margin;
//            if (minXY > polygon.getPointsArray().get(i).getY() - margin)
//                minXY = polygon.getPointsArray().get(i).getY() - margin;
//
//            if (maxXY < polygon.getPointsArray().get(i).getX() + margin)
//                maxXY = polygon.getPointsArray().get(i).getX() + margin;
//            if (maxXY < polygon.getPointsArray().get(i).getY() + margin)
//                maxXY = polygon.getPointsArray().get(i).getY() + margin;
//        }
//
//        Polygon outerFoursquare = new Polygon();
//        outerFoursquare.getPointsArray().add(new Point2D(minXY, minXY));
//        outerFoursquare.getPointsArray().add(new Point2D(maxXY, minXY));
//        outerFoursquare.getPointsArray().add(new Point2D(maxXY, maxXY));
//        outerFoursquare.getPointsArray().add(new Point2D(minXY, maxXY));
//
//        return outerFoursquare;
//    }

    /**
     * @return true if the point is inside the polygon; false otherwise
     * */
    static boolean isInside(Polygon polygon, Point2D point) {
        ArrayList<Point2D> pointsArray = polygon.getPointsArray();
        int edgeNumber = polygon.getEdgeNumber();
        int counter = 0;
        double ix, i1x, iy, i1y, px = point.getX(), py = point.getY();

        for (int i=0; i<edgeNumber; i++) {
            ix = pointsArray.get(i).getX();
            iy = pointsArray.get(i).getY();
            if (i + 1 < edgeNumber) {
                i1x = pointsArray.get(i+1).getX();
                i1y = pointsArray.get(i+1).getY();
            } else {
                i1x = pointsArray.get(0).getX();
                i1y = pointsArray.get(0).getY();
            }

            if (isLyingOnEdge(pointsArray.get(i), new Point2D(i1x, i1y), point)) {
                return false;
            }

            if (((iy <= py) && (i1y > py)) /*an upward crossing*/
                    || ((iy > py) && (i1y <=  py))) { /*a downward crossing*/
                // compute the actual edge-ray intersect x-coordinate
                double vt = (float)(py  - iy) / (i1y - iy);
                if (px <  ix + vt * (i1x - ix)) /*point.getX() < intersect*/
                    counter++; /*a valid crossing of y=point.getY()// right of point.getX()*/
            }
        }

        return (counter%2 != 0);
    }

    static Double getRandomDouble() {
        return (minXY + (maxXY - minXY) * r.nextDouble());
    }

    /**isLeft(): test if a point is Left|On|Right of an infinite 2D line.
     Input:  three points P0, P1, and P2
     Return: >0 for P2 left of the line through P0 to P1
     =0 for P2 on the line
     <0 for P2 right of the line
     inline int*/
    static boolean isLyingOnEdge(Point2D p0, Point2D p1, Point2D p2) {
        return 0 == (p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) - (p2.getX() - p0.getX()) * (p1.getY() - p0.getY());
    }
}
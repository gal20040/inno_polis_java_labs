package DSA.codetest.edu.innopolis.ru.Assignment1.MonteCarlo;

class OuterFoursquare extends Polygon {
    static double minXY, maxXY;

    OuterFoursquare() {}

    void initialiseOuterFoursquare(Polygon polygon) {
        double margin = 0;
        minXY = polygon.getPointsArray().get(0).getX() - margin;
        maxXY = polygon.getPointsArray().get(0).getX() + margin;
        for (int i = 0; i < polygon.getEdgeNumber(); i++) {
            if (minXY > polygon.getPointsArray().get(i).getX() - margin)
                minXY = polygon.getPointsArray().get(i).getX() - margin;
            if (minXY > polygon.getPointsArray().get(i).getY() - margin)
                minXY = polygon.getPointsArray().get(i).getY() - margin;

            if (maxXY < polygon.getPointsArray().get(i).getX() + margin)
                maxXY = polygon.getPointsArray().get(i).getX() + margin;
            if (maxXY < polygon.getPointsArray().get(i).getY() + margin)
                maxXY = polygon.getPointsArray().get(i).getY() + margin;
        }

        addPointInArray(new Point2D(minXY, minXY));
        addPointInArray(new Point2D(maxXY, minXY));
        addPointInArray(new Point2D(maxXY, maxXY));
        addPointInArray(new Point2D(minXY, maxXY));
    }

    double getArea() {return Math.pow(maxXY - minXY, 2);}
}
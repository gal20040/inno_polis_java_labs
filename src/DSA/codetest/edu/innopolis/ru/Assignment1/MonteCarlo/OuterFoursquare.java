package DSA.codetest.edu.innopolis.ru.Assignment1.MonteCarlo;

class OuterFoursquare extends Polygon {
    double minXY, maxXY;

    /**
     * Create auxiliary outer rectangle
     * @input Polygon polygon - measuring polygon.
     * @return Polygon outerRectangle - auxiliary outer rectangle
     */
    OuterFoursquare(Polygon polygon) {
//        double  minX = polygon.getPointsArray().get(0).getX() - 1.0,
//                maxX = polygon.getPointsArray().get(0).getX() + 1.0,
//                minY = polygon.getPointsArray().get(0).getY() - 1.0,
//                maxY = polygon.getPointsArray().get(0).getY() + 1.0;

//        for (int i = 1; i < polygon.getEdgeNumber(); i++) {
//            if (minX > polygon.getPointsArray().get(i).getX() - 1.0)
//                minX = polygon.getPointsArray().get(i).getX() - 1.0;
//            if (maxX < polygon.getPointsArray().get(i).getX() + 1.0)
//                maxX = polygon.getPointsArray().get(i).getX() + 1.0;
//            if (minY > polygon.getPointsArray().get(i).getY() - 1.0)
//                minY = polygon.getPointsArray().get(i).getY() - 1.0;
//            if (maxY < polygon.getPointsArray().get(i).getY() + 1.0)
//                maxY = polygon.getPointsArray().get(i).getY() + 1.0;
//        }
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

        Polygon outerFoursquare = new Polygon();
        outerFoursquare.getPointsArray().add(new Point2D(minXY, minXY));
        outerFoursquare.getPointsArray().add(new Point2D(maxXY, minXY));
        outerFoursquare.getPointsArray().add(new Point2D(maxXY, maxXY));
        outerFoursquare.getPointsArray().add(new Point2D(minXY, maxXY));

        return outerFoursquare;
    }

    double getArea() {
        return Math.pow(maxXY - minXY, 2);
    }
}
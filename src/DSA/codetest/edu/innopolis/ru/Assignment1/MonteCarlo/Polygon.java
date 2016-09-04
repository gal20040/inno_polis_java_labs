package DSA.codetest.edu.innopolis.ru.Assignment1.MonteCarlo;

class Polygon {
    private MyArrayList<Point2D> pointsArray = new MyArrayList<>();

    Polygon() {}

    MyArrayList<Point2D> getPointsArray() {return pointsArray;}
    void addPointInArray(Point2D point) {getPointsArray().add(point);}

    int getEdgeNumber() {return getPointsArray().getSize();}

    /**
     * @return true if the point is inside the polygon; false otherwise
     * */
    boolean isPointInside(Point2D point) {
        MyArrayList<Point2D> pointsArray = getPointsArray();
        int edgeNumber = getEdgeNumber();
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

            if (((iy <= py) && (i1y > py))
                    || ((iy > py) && (i1y <=  py))) {
                double vt = (float)(py  - iy) / (i1y - iy);
                if (px <  ix + vt * (i1x - ix))
                    counter++;
            }
        }

        //If ray intersects polygon even number of times (0, 2, 4, ...),
        // than point is outside the polygon, else point is inside.
        return (counter%2 != 0);
    }
}
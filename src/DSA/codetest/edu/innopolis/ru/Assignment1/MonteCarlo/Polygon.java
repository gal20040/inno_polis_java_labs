package DSA.codetest.edu.innopolis.ru.Assignment1.MonteCarlo;

import java.util.ArrayList;

class Polygon {
    private ArrayList<Point2D> pointsArray = new ArrayList<>();

    Polygon() {}

    ArrayList<Point2D> getPointsArray() {return pointsArray;}
    void addPointInArray(Point2D point) {getPointsArray().add(point);}

    int getEdgeNumber() {return getPointsArray().size();}
}
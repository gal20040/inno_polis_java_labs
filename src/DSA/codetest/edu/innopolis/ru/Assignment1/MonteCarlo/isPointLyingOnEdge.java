/**
 * @return true if the point is inside the polygon;
 * false otherwise (including lying on edges or in one of vertexes)
 * */
//              in Polygon.isPointInside()
//            //checking if the point is lying on edges or in one of vertexes
//            if (isPointLyingOnEdge(pointsArray.get(i), new Point2D(i1x, i1y), point)) {
//                return false;
//            }

//    private static boolean isPointLyingOnEdge(Point2D p0, Point2D p1, Point2D point) {
//        return 0 == (p1.getX() - p0.getX()) * (point.getY() - p0.getY())
//                - (point.getX() - p0.getX()) * (p1.getY() - p0.getY());
//    }
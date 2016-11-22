////package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment4.FastestPath;
//
//import sun.misc.Queue;
//import java.util.HashMap;
//
//class Router {
//    private final float bigFloat = 999999999f;
//    Vertex getEndVertex(Edge beginEndEdge, Edge[][] ams, HashMap<String, Vertex> vertexMap) {
//        int currentVertexIndex;
//        float currentVertexTime, secondVertexTime;
//        Vertex secondCurrentVertex;
//        Queue<Vertex> vertexQueue = new Queue<>();
//
//        Vertex currentVertex = vertexMap.get(beginEndEdge.getNode1().getName());
//        currentVertex.setDistance(0);
//        currentVertex.setTime(0);
//        currentVertex.setCost(0);
//
//        Vertex endVertex = vertexMap.get(beginEndEdge.getNode2().getName());
//        vertexQueue.enqueue(currentVertex);
//
//        while (!vertexQueue.isEmpty()) {
//            try {
//                currentVertex = vertexQueue.dequeue();
//
//                currentVertexIndex = currentVertex.getIndex();
//                currentVertexTime = currentVertex.getTime();
//
//                for (int i = 0; i < ams.length; i++) {
//                    Edge currentEdge = ams[currentVertexIndex][i];
//
//                    if (currentEdge != null) {
//                        secondCurrentVertex = currentEdge.getNode2();
//                        secondVertexTime = secondCurrentVertex.getTime();
//
//                        if (secondVertexTime == bigFloat)
//                            vertexQueue.enqueue(secondCurrentVertex);
//
//                        if (secondVertexTime > currentVertexTime +currentEdge.getTime()) {
//                            secondCurrentVertex.setTime(currentVertexTime + currentEdge.getTime());
//                            secondCurrentVertex.setDistance(currentVertex.getDistance() + currentEdge.getDistance());
//                            secondCurrentVertex.setCost(currentVertex.getCost() + currentEdge.getCost());
//                        }
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return  endVertex;
//    }
//
//    /**
//     * Приводит матрицу к первоначальному виду - ставит во всех вершинах distance,time,cost = bigFloat.
//     */
//    void setToDefaultVertex(Edge[][] ams) {
//        for (int i = 0; i < ams.length; i++) {
//            for (int j = 0; j < ams.length; j++) {
//                Edge currentEdge = ams[i][j];
//                if (currentEdge != null) {
//                    currentEdge.getNode1().setDistance(bigFloat);
//                    currentEdge.getNode1().setTime(bigFloat);
//                    currentEdge.getNode1().setCost(bigFloat);
//                }
//            }
//        }
//    }
//}
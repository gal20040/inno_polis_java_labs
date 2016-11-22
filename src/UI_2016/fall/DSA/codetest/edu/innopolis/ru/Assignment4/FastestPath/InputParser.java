////package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment4.FastestPath;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//class InputParser {
//    private int borderPosition, beginPosition, endPosition;
//
//    /**
//     * Парсит строку с названиями вершин и добавляет их в vertexMap.
//     */
//    void parseVertexString(HashMap<String, Vertex> vertexMap,
//                           String vertexString) {
//        int breakspacePosition, prevVertexEndPosition = 0, index = 0;
//        while (true) {
//            breakspacePosition = vertexString.indexOf(" ", prevVertexEndPosition);
//            if (breakspacePosition == -1) {
//                addNewVertex(vertexMap,
//                        vertexString,
//                        prevVertexEndPosition,
//                        vertexString.length(),
//                        index);
//                break;
//            }
//            addNewVertex(vertexMap,
//                    vertexString,
//                    prevVertexEndPosition,
//                    breakspacePosition,
//                    index);
//
//            index++;
//            prevVertexEndPosition = breakspacePosition + 1;
//        }
//    }
//
//    /**
//     * Берёт подстроку из vertexString и добавляет её в vertexMap.
//     */
//    private void addNewVertex(HashMap<String, Vertex> vertexMap,
//                              String vertexString,
//                              int fromPosition,
//                              int toPosition,
//                              int index) {
//        String vertexName = vertexString.substring(fromPosition, toPosition);
//        vertexMap.put(vertexName, new Vertex(vertexName, index));
//    }
//
//    /**
//     * Парсит строку с рёбрами и добавляет их в ams.
//     */
//    void parseEdgeString(HashMap<String, Vertex> vertexMap,
//                         Edge[][] ams,
//                         String vertexString) {
//        Edge currentEdge;
//        borderPosition = 0;
//        int firstVertexIndex, secondVertexIndex;
//        while (borderPosition < vertexString.length()) {
//            currentEdge = getCurrentEdge(vertexString, vertexMap);
//            firstVertexIndex  = vertexMap.get(currentEdge.getNode1().getName()).getIndex();
//            secondVertexIndex = vertexMap.get(currentEdge.getNode2().getName()).getIndex();
//
//            ams[firstVertexIndex][secondVertexIndex] = currentEdge;
//        }
//    }
//
//    /**
//     * Парсит входную строку vertexString, вытаскивает названия вершин, дистанцию, время и стоимость.
//     * Возвращает объект Edge, в котором указаны распарсенные ранее данные.
//     */
//    private Edge getCurrentEdge(String vertexString,
//                                HashMap<String, Vertex> vertexMap) {
//        int fromPosition = borderPosition;
//        int breakspacePosition = vertexString.indexOf(" ", fromPosition);
//
//        String firstVertexName  = vertexString.substring(fromPosition, breakspacePosition);
//
//        fromPosition = breakspacePosition + 1;
//        breakspacePosition = vertexString.indexOf(" ", fromPosition);
//        String secondVertexName = vertexString.substring(fromPosition, breakspacePosition);
//
//        fromPosition = breakspacePosition + 1;
//        int colonPosition = vertexString.indexOf(":", fromPosition);
//        float distance = Float.parseFloat(vertexString.substring(fromPosition, colonPosition));
//
//        fromPosition = colonPosition + 1;
//        colonPosition = vertexString.indexOf(":", fromPosition);
//        float time = Float.parseFloat(vertexString.substring(fromPosition, colonPosition));
//
//        fromPosition = colonPosition + 1;
//        breakspacePosition = vertexString.indexOf(" ", fromPosition);
//        if (breakspacePosition == -1)
//            breakspacePosition = vertexString.length();
//
//        float cost = Float.parseFloat(vertexString.substring(fromPosition, breakspacePosition));
//
//        borderPosition = breakspacePosition + 1;
//
//        return new Edge(vertexMap.get(firstVertexName),
//                vertexMap.get(secondVertexName),
//                distance,
//                time,
//                cost);
//    }
//
//    ArrayList<Edge> parseInput(ArrayList<String> inputList) {
//        String delimiter = " ";
//        ArrayList<Edge> edgeArrayList = new ArrayList<>();
//        Vertex vertex1, vertex2;
//        float weight;
//        for (String string : inputList) {
//            beginPosition = 0;
//            endPosition = 0;
//            vertex1 = new Vertex(getNextSubString(string, delimiter));
//            vertex2 = new Vertex(getNextSubString(string, delimiter));
//            weight = Float.parseFloat(getNextSubString(string, delimiter));
//            edgeArrayList.add(new Edge(vertex1, vertex2, weight));
//        }
//        return edgeArrayList;
//    }
//
//    private String getNextSubString(String inputString,
//                                    String delimiter) {
//        endPosition = inputString.indexOf(delimiter, beginPosition + 1);
//        if (endPosition == -1)
//            endPosition = inputString.length();
//        String nextSubString = inputString.substring(beginPosition, endPosition);
//        beginPosition = endPosition + 1;
//        return nextSubString;
//    }
//}
////package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment4.FastestPath;
//
///**
// * Statement
// 3 points
// You are working in delivery company "LHD". Your comapany's first priority is speed of delivery. So, each time you are looking for the route for delivery, you select the fastest one.
// Now you are building the information system for customers, that estimates time and cost of delivery. Your database is undirected loopless graph with no parallel edges of roads which has information about distance (in km), time (in hours) and cost (in rubles/kilogram) of travelling between two points. This graph is stored in russia.txt file in the following format:
//
// russia.txt
// VertexA VertexB VertextC
// VertextA VertexB dist:time:cost VertextC VertexB dist:time:cost
// For example:
//
// russia.txt
// Бабяково Коньково Свиблово
// Бабяково Коньково 120.0:4.3:100.50 Свиблово Коньково 220.0:4.0:10.0
// Means that there are 120.0 km between Бабяково and Коньково, time to travel is 4.3 hours, and one kilogram delivery will cost 100.5 rubles.
// Having this graph you can estimate delivery time and costs for you clients. You are given input.txt with requests in each line:
//
// input.txt
// Бабяково Свиблово 10.0
// Бабяково Коньково 5.0
// Means clients are going to deliver 10 kilos from Бабяково to Свиблово and 5 kilos from Бабяково to Коньково. Your system should estimate time and costs for these requests, and put them into output.txt file like this:
//
// output.txt
// Бабяково Свиблово 10.0 8.3 1105.0
// Бабяково Коньково 5.0 4.3 502.5
// E.g. first line means "from Бабяково to Свиблово 10.0 kilos will be delivered in 8.3 hours for (100.5+10.0)*10.0 = 1105 rubles".
// NB: All the number should be written with a single decimal digit after the point: 1234.5
//
//
// */
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Locale;
//
//public class GettingFastestPath {
//
//    public static void main(String[] args) {
//        HashMap<String, Vertex> vertexMap = new HashMap();
//
//        InputParser inputParser = new InputParser();
//        FileReaderWriter fileReaderWriter = new FileReaderWriter();
//
//        //взяли вершины и рёбра
//        ArrayList<String> inputVerticesAndEdges = fileReaderWriter.readFromInputFile("russia.txt");
//
//        //парсим вершины
//        inputParser.parseVertexString(vertexMap, inputVerticesAndEdges.get(0));
//
//        //парсим рёбра
//        int verticesQuantity = vertexMap.size();
//        Edge[][] ams = new Edge[verticesQuantity][verticesQuantity];
//        inputParser.parseEdgeString(vertexMap, ams, inputVerticesAndEdges.get(1));
//
//        //взяли искомые вершины и веса
//        ArrayList<String> inputList = fileReaderWriter.readFromInputFile("input.txt");
//        ArrayList<Edge> edgeArrayList = inputParser.parseInput(inputList);
//
//        //ищем путь для запрошенных вершин
//        Router router = new Router();
//        String outputString = "";
//        Edge beginEndEdge;
//        for (int i = 0; i < edgeArrayList.size(); i++) {
//            beginEndEdge = edgeArrayList.get(i);
//            Vertex endVertex = router.getEndVertex(beginEndEdge, ams, vertexMap);
//            outputString = String.format(Locale.ENGLISH, "%s%n%s %s %.1f %.1f %.1f",
//                    outputString,
//                    beginEndEdge.getNode1().getName(),
//                    beginEndEdge.getNode2().getName(),
//                    beginEndEdge.getWeight(),
//                    endVertex.getTime(),
//                    (endVertex.getCost() * beginEndEdge.getWeight())
//            );
//            router.setToDefaultVertex(ams);
//        }
//
//        fileReaderWriter.writeToOutputFile(outputString);
//    }
//}
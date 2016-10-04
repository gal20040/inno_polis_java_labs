////package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment2.KnapsackPacking;
//
///*Statement
//Implement 0/1 knapsack problem solution using dynamic programming for positive integer weights and costs.
//First line of input.txt stores weights. Second line stores costs. Third line stores limitation (weight is less or equal).
//
//output.txt should contain the only number: maximum cost.
//
//* Get extra point [4th] for implementation that can not only count the weight, but also provide proper item numbers.
//Example
//input.txt
//1 2 3 4 5
//5 4 3 2 1
//6
//
//output.txt
//12
//
//1 2 3 4 5
//5 1 4 2 3
//6
//output
//10
//*/
//
//import java.util.ArrayList;
//
//public class KnapsackPacking {
//    public static void main(String[] args) {
//        FileReaderWriter fileReaderWriter = new FileReaderWriter();
//        ArrayList<Integer> inputList = fileReaderWriter.readFromInputFile();
//        ArrayList<Item> itemsList = new ArrayList<>();
//
//        int knapsackBearingCapacity = inputList.get(inputList.size() - 1);
//        inputList.remove(inputList.size() - 1);
//
//        while (inputList.size() > 0) {
//            itemsList.add(new Item(inputList.get(0), inputList.get(inputList.size() / 2)));
//            inputList.remove(inputList.size() / 2); //cost
//            inputList.remove(0); //weight
//        }
//
//        fileReaderWriter.writeToOutputFile(doKnapsackPacking(itemsList, knapsackBearingCapacity) + "");
//    }
//
//    public static int doKnapsackPacking(ArrayList<Item> itemsList, int knapsackBearingCapacity) {
//        Object[][][] costArray = new Object[itemsList.size() + 1]
//                [knapsackBearingCapacity + 1]
//                [2]; //[items][knapsack bearing capacity][(String) list of item numbers]
//
//        for (int currBearingCapacity = 0; currBearingCapacity <= knapsackBearingCapacity; currBearingCapacity++) {
//            costArray[0][currBearingCapacity][0] = 0;
//            costArray[0][currBearingCapacity][1] = "";
//        }
//        for (int itemNumber = 1; itemNumber <= itemsList.size(); itemNumber++) {
//            costArray[itemNumber][0][0] = 0;
//            costArray[itemNumber][0][1] = "";
//        }
//
//        //n - itemNumber
//        //w - currBearingCapacity
//        int temp;
//        boolean elseStatement = false;
//        String maxCostElementsNumber = "";
//        for (int n = 1; n <= itemsList.size(); n++) {
//            for (int w = 0; w <= knapsackBearingCapacity; w++) {
//                if (itemsList.get(n - 1).getWeight() <= w) {
//                    temp = itemsList.get(n - 1).getCost() + (int) costArray[n - 1][w - itemsList.get(n - 1).getWeight()][0];
//                    if (temp > (int) costArray[n - 1][w][0]) {
//                        costArray[n][w][0] = temp;
//                        costArray[n][w][1] = (String) costArray[n - 1][w - itemsList.get(n - 1).getWeight()][1]
//                                + " " + (n - 1);
//                        maxCostElementsNumber = (String) costArray[n][w][1];
//                    } else //TODO заменить на continue - http://developer.alexanderklimov.ru/android/java/break.php#continue
//                        elseStatement = true;
//                } else
//                    elseStatement = true;
//                if (elseStatement) {
//                    costArray[n][w][0] = costArray[n - 1][w][0];
//                    costArray[n][w][1] = (String) costArray[n - 1][w][1];
//                    elseStatement = false;
//                }
//            }
//        }
//
////        System.out.println(maxCostElementsNumber); //эта строка пишет номера выбранных элементов (нумерация начинается с 0)
//        return (int) costArray[itemsList.size()][knapsackBearingCapacity][0];
//    }
//}
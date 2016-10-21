package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.TopContributor;

import java.util.ArrayList;

class InputParser {
    private static DateTimeHandler dateTimeHandler = new DateTimeHandler();
    private static MyPriorityQueue priorityQueue = new MyPriorityQueue();
    private static String outputString = "";
    private static long bossTimeBegin;

    String parse(ArrayList<String> inputList) {
        int semicolonPosition, dashPosition, signATPosition;
        String currentString, contributorName;
        int contributionValue;
        long contributionTime;

        //parse the first line
        currentString = inputList.get(0);
        semicolonPosition = currentString.indexOf(": ");
        dashPosition = currentString.indexOf(" - ");
        bossTimeBegin = dateTimeHandler.getTimeStampInMinutes(currentString, semicolonPosition + 2, dashPosition);
        long bossTimeEnd = dateTimeHandler.getTimeStampInMinutes(currentString, dashPosition + 3);

        int i = 1;
        //parse other lines
        while (i < inputList.size()) {
            currentString = inputList.get(i);
            signATPosition = currentString.indexOf(" at ");

            contributionTime = dateTimeHandler.getTimeStampInMinutes(currentString, signATPosition + 4);
            if (contributionTime <= bossTimeEnd) {
                addStringToOutput(contributionTime);
                semicolonPosition = currentString.indexOf(": ");
                contributorName = currentString.substring(0,semicolonPosition);
                contributionValue = Integer.parseInt(currentString.substring(semicolonPosition + 2, signATPosition));

                priorityQueue.put(new Node(contributionValue, contributorName));
            } else
                break;
            i++;
        }

        addStringToOutput(bossTimeEnd);

        return outputString;
    }

    private void addStringToOutput(long contributionTime) {
        while (contributionTime >= bossTimeBegin) {
            if (!outputString.equals("")) {
                outputString = outputString.concat("\n");
            }
            outputString = outputString.concat(dateTimeHandler.getFormattedDate(bossTimeBegin)
                    + ": " + priorityQueue.peek().getValue());
            bossTimeBegin = bossTimeBegin + 60; //time shifting for 60 minutes
        }
    }
}
package UI_2016.fall.ItP.ExpressionCalculatorSerializer;

import UI_2016.fall.ItP.ExpressionCalculatorSerializer.ShuntingYard.InfixParser;
import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.*;
import org.json.simple.JSONObject;
import sun.misc.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AST {
    public static void main(String[] args) {
        String inputString = getInputString(); //getting input STRING!!! e.g: "(1+0-1and2xor3or4)+1!=1+(26=3-98<=2*5)/15>=3+777<28"
        if (inputString == null
                || inputString.equals(""))
            assert false : "inputString is null or empty";

        Parser parser = new Parser();
        Stack<Expression> inputStack = parser.preParseInputString(inputString); //Evaluates input string in stack of objects

        if (inputStack.size() == 0)
            assert false : "inputStack is null or empty";

        Queue<Expression> inputQueue = new Queue<>();
        for (int i = 0; i < inputStack.size(); ) {
            inputQueue.enqueue(inputStack.pop()); //translate stack to queue - it's more convenient to deal
        }

        if (inputQueue.isEmpty())
            assert false : "inputQueue is null or empty";

        InfixParser infixParser = new InfixParser();
        Expression expressionTree = null;
        try {
            expressionTree = infixParser.parseStringToRPN(inputQueue).pop(); //Evaluates input queue in Reversed Polish notation.
        } catch (InterruptedException e) {e.getStackTrace();}

        long result = expressionTree.calculate();
        System.out.println("Ответ: " + result);

        JSONObject obj = expressionTree.toJSON();
        System.out.println("JSON:");
        System.out.println(obj);
    }

    private static String getInputString() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        System.out.println("Введите строку или нажмите Enter (будет использована строка по умолчанию):");
        try {
            input = bufferedReader.readLine();
            if (input.equals("")) {
//                input = "(2+3)>=(4^2)";
//                input = "1+(26-98)/15+777<28";
//                input = "1+(26-98)and1+777or(2-1)<28";
                input = "1+(26-98)/15+777<28or1";
                input = "28or1";
//                input = "(2and2)+1!=1+(26=3-98<=2*5)/15>=3+777<28";
                System.out.println("Будет использована строка: " + input);
//                input = "7<2";
//                input = "1+(26-98)";
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }

        return input;
    }
}
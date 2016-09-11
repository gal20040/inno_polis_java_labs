package UI_2016.fall.ItP.ExpressionCalculatorSerializer;

import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.*;
import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.Integer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class AST {
    public static void main(String[] args) {
        String inputString = getInputString();

        Parser parser = new Parser();
        Stack<Expression> inputStack = parser.preParseInputString(inputString);

        for (int i = 0; i < inputStack.size(); ) {
            System.out.println(inputStack.peek().getValue() + " " + inputStack.pop().getClass().getSimpleName());
        }

        if (inputString == null
                || inputString.equals("")
                || inputStack.size() == 0)
            assert false : "Input string is null or empty";

        Expression expressionTree = parser.parse(inputStack);

        long result = expressionTree.calculate();
        System.out.println(result);

        String serialized = expressionTree.ToJSON();
        System.out.println(serialized);
    }

    private static String getInputString() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
//        try {
//            input = bufferedReader.readLine();
//        input = "(2+3)>=(4^2)";
//        input = "1+(26-98)/15+777<28";
        input = "(1 and 2 xor 3 or 4)+1 != 1+(26=3-98 <= 2*5)/15>=3+777<28";
//        } catch (IOException e) {
//            System.out.println("исключение IOException");
//        } finally {
//            if (bufferedReader != null) {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    System.out.println("исключение IOException");
//                }
//            }
//        }

        return input;
    }
}
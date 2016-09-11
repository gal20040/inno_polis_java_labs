package ItP.ExpressionCalculatorSerializer;

import ItP.ExpressionCalculatorSerializer.expressions.*;
import ItP.ExpressionCalculatorSerializer.expressions.Integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AST {
    public static void main(String[] args) {
        String input = getInputString();

        Stack<Expression> inputQueue = preParseInputString(input);
        for (int i = 0; i < inputQueue.size(); ) {
            System.out.println(inputQueue.peek().getValue() + " " + inputQueue.pop().getTypeOfObject());
        }

        if (input == null)
            assert false : "Input string is null";

        Parser parser = new Parser();
        Expression expressionTree = parser.parse(inputStack);

//        long result = expressionTree.calculate();
//        System.out.println(result);
//
//        String serialized = expressionTree.ToJSON();
//        System.out.println(serialized);
    }

    private static Stack<Expression> preParseInputString(String inputString) {
        Stack<Expression> inputStack = new Stack<>();
        Object lastStackValue;

        for (int i = 0; i < inputString.length(); i++) {
            char sign = inputString.charAt(i);

            if (Character.isDigit(sign)) {
                //Check if the last element is Integer class.
                if (inputStack.size() > 0
                        && inputStack.peek().getTypeOfObject() instanceof Integer) {
                    // Then get it and remove it from the stack. Get the value.
                    lastStackValue = inputStack.peek().getValue();
                    inputStack.pop();
                } else
                    lastStackValue = "";

                /**
                 * Join the last element (if it exists) and new sign. For example: was 2, new sign = 5 then new value: 25
                 * Then parse new string into Integer and add as new element to the stack.
                 */
                inputStack.add(
                        new Expression(java.lang.Integer.parseInt(lastStackValue + (sign + "")),
                                new Integer()));
            } else if ((sign + "").equals(Parenthesized.Opcode.LEFT_BRACKET.toString())
                    || (sign + "").equals(Parenthesized.Opcode.RIGHT_BRACKET.toString())) {
                inputStack.add(new Expression(sign, new Parenthesized()));
            } else if ((sign + "").equals(Term.Opcode.PLUS.toString())
                    || (sign + "").equals(Term.Opcode.MINUS.toString())) {
                inputStack.add(new Expression(sign, new Term()));
            } else if ((sign + "").equals(Factor.Opcode.MULTIPLICATION.toString())
                    || (sign + "").equals(Factor.Opcode.DIVISION.toString())) {
                inputStack.add(new Expression(sign, new Factor()));
            } else if (((sign + "") + inputString.charAt(i+1)).equals(Relation.Opcode.LESS_EQUAL.toString())
                    || ((sign + "") + inputString.charAt(i+1)).equals(Relation.Opcode.GREATER_EQUAL.toString())) {
                inputStack.add(new Expression((sign + "") + inputString.charAt(i+1), new Relation()));
                i++;
            } else if ((sign + "").equals(Relation.Opcode.LESS.toString())
                    || (sign + "").equals(Relation.Opcode.GREATER.toString())
                    || (sign + "").equals(Relation.Opcode.EQUAL.toString())) {
                inputStack.add(new Expression(sign, new Relation()));
            } else if (((sign + "") + inputString.charAt(i + 1)).equals(Relation.Opcode.NOT_EQUAL.toString())) {
                inputStack.add(new Expression(Relation.Opcode.NOT_EQUAL.toString(), new Relation()));
                i++;
            } else if (((sign + "") + inputString.charAt(i+1) + inputString.charAt(i+2)
                    + inputString.charAt(i+3)).equals(Relation.Opcode.NONE.toString())) {
                if (inputStack.peek().getTypeOfObject() instanceof Term) {
                    inputStack.add(new Expression(Relation.Opcode.NONE.toString(), new Relation()));
                } else if (inputStack.peek().getTypeOfObject() instanceof Relation) {
                    inputStack.add(new Expression(Relation.Opcode.NONE.toString(), new Logical()));
                }
                i = i + 3;
            } else if (((sign + "") + inputString.charAt(i+1)).equals(Logical.Opcode.OR.toString())) {
                inputStack.add(new Expression((sign + "") + inputString.charAt(i+1), new Logical()));
                i++;
            } else if (((sign + "") + inputString.charAt(i+1) + inputString.charAt(i+2)).equals(Logical.Opcode.AND.toString())
                    || ((sign + "") + inputString.charAt(i+1) + inputString.charAt(i+2)).equals(Logical.Opcode.XOR.toString())) {
                inputStack.add(new Expression((sign + "") + inputString.charAt(i+1) + inputString.charAt(i+2), new Logical()));
                i = i + 2;
            }
        }

        Stack<Expression> tempStack = new Stack<>();
        for (int i = 0; i < inputStack.size(); ) {
            tempStack.add(inputStack.pop());
        }

        return tempStack;
    }

    private static String getInputString() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
//        try {
//        //(1 and 2 xor 3 or 4)+1 != 1+(26=3-98 <= 2*5)/15>=3+777<28
//        //1+(26-98)/15+777<28
//            input = bufferedReader.readLine();
        //(2+3)>=(4^2)
        input = "(2+3)>=(4^2)";
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
package UI_2016.fall.ItP.ExpressionCalculatorSerializer;

import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.*;
import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.Integer;
import java.util.Stack;

class Parser {
    /**
     * Evaluates input string in stack of objects: Logical, Relation, Term, Factor, Integer, Parenthesized.
     * @param inputString - e.g: "(1+0-1and2xor3or4)+1!=1+(26=3-98<=2*5)/15>=3+777<28".
     * @return stack of objects.
     */
    Stack<Expression> preParseInputString(String inputString) {
        Stack<Expression> inputStack = new Stack<>();
        Object lastStackValue;

        for (int i = 0; i < inputString.length(); i++) {
            char sign = inputString.charAt(i);

            if (Character.isDigit(sign)) {
                //Check if the last element is Integer class.
                if (inputStack.size() > 0
                        && inputStack.peek() instanceof UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.Integer) {
                    // Then get it and remove it from the stack. Get the value.
                    lastStackValue = inputStack.peek().getValue();
                    inputStack.pop();
                } else
                    lastStackValue = "";

                /*
                 * Join the last element (if it exists) and new sign. For example: was 2, new sign = 5 then new value: 25
                 * Then parse new string into Integer and add as new element to the stack.
                 */
                inputStack.add(
                        new Integer(java.lang.Integer.parseInt(lastStackValue + (sign + ""))));
            } else if ((sign + "").equals(Parenthesized.Opcode.LEFT_BRACKET.toString())
                    || (sign + "").equals(Parenthesized.Opcode.RIGHT_BRACKET.toString())) {
                inputStack.add(new Parenthesized(sign));
            } else if ((sign + "").equals(Term.Opcode.PLUS.toString())
                    || (sign + "").equals(Term.Opcode.MINUS.toString())) {
                inputStack.add(new Term(sign));
            } else if ((sign + "").equals(Factor.Opcode.MULTIPLICATION.toString())
                    || (sign + "").equals(Factor.Opcode.DIVISION.toString())) {
                inputStack.add(new Factor(sign));
            } else if (((sign + "") + inputString.charAt(i+1)).equals(Relation.Opcode.LESS_EQUAL.toString())
                    || ((sign + "") + inputString.charAt(i+1)).equals(Relation.Opcode.GREATER_EQUAL.toString())) {
                inputStack.add(new Relation((sign + "") + inputString.charAt(i+1)));
                i++;
            } else if ((sign + "").equals(Relation.Opcode.LESS.toString())
                    || (sign + "").equals(Relation.Opcode.GREATER.toString())
                    || (sign + "").equals(Relation.Opcode.EQUAL.toString())) {
                inputStack.add(new Relation(sign));
            } else if (((sign + "") + inputString.charAt(i + 1)).equals(Relation.Opcode.NOT_EQUAL.toString())) {
                inputStack.add(new Relation(Relation.Opcode.NOT_EQUAL.toString()));
                i++;
            } else if (((sign + "") + inputString.charAt(i+1) + inputString.charAt(i+2)
                    + inputString.charAt(i+3)).equals(Relation.Opcode.NONE.toString())) {
                /*TODO здесь и в нескольких ещё местах проблема: если до конца входной строки осталось мало символов,
                то может вылететь исключение StringIndexOutOfBoundsException, потому что на слово NONE
                надо 4 знака, а до конца строки может остаться меньше знаков
                пример: "28or1"*/
                if (inputStack.peek() instanceof Term) {
                    inputStack.add(new Relation(Relation.Opcode.NONE.toString()));
                } else if (inputStack.peek() instanceof Relation) {
                    inputStack.add(new Logical(Relation.Opcode.NONE.toString()));
                }
                i = i + 3;
            } else if (((sign + "") + inputString.charAt(i+1)).equals(Logical.Opcode.OR.toString())) {
                inputStack.add(new Logical((sign + "") + inputString.charAt(i+1)));
                i++;
            } else if (((sign + "") + inputString.charAt(i+1) + inputString.charAt(i+2)).equals(Logical.Opcode.AND.toString())
                    || ((sign + "") + inputString.charAt(i+1) + inputString.charAt(i+2)).equals(Logical.Opcode.XOR.toString())) {
                inputStack.add(new Logical((sign + "") + inputString.charAt(i+1) + inputString.charAt(i+2)));
                i = i + 2;
            }
        }

        Stack<Expression> tempStack = new Stack<>();
        for (int i = 0; i < inputStack.size(); ) {
            tempStack.add(inputStack.pop());
        }

        return tempStack;
    }
}
package UI_2016.fall.ItP.ExpressionCalculatorSerializer;

import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.*;
import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.Integer;
//import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.Integer;

import java.util.Stack;

class Parser {
//    Expression parse(PriorityQueue<Expression> inputQueue) {return Expression.parseExpression(inputQueue);}

    static Stack<Expression> inputStack;
//    public Parser(String s) {input = s;}

    public Expression parse(Stack<Expression> inputStack) {
        this.inputStack = inputStack;
        return parseLogical();}

    private Expression parseLogical() {
        Expression result;
        if (inputStack.peek() instanceof Logical)
            result = inputStack.pop();
        else
            result = parseRelation();
        while (true) {
            Logical.Opcode opcode = parseLogicalOperator();
            if (opcode != Logical.Opcode.NONE) {
                Expression right = parseRelation();
                result = new Logical(result, opcode, right);
            } else break; //TODO разобраться с этой строчкой
        }
        return result;
    }

    private Logical.Opcode parseLogicalOperator() {
        return ;
    }

    private Expression parseRelation() {
        Expression result;
        if (inputStack.peek() instanceof Relation)
            result = inputStack.pop();
        else
            result = parseTerm();
        while (true) {
            Relation.Opcode opcode = parseRelationOperator(); // //
            if (opcode != Relation.Opcode.NONE) { // //
                Expression right = parseTerm(); //
                result = new Relation(result, opcode, right); //
            } else break; //TODO разобраться с этой строчкой
        }
        return result;
    }

    private Relation.Opcode parseRelationOperator() {
        return ;
    }

    private Expression parseTerm() {
        Expression result;
        if (inputStack.peek() instanceof Term)
            result = inputStack.pop();
        else
            result = parseFactor();
        while (true) {
            Term.Opcode opcode = parseTermOperator(); // //
            if (opcode != Term.Opcode.) { // //
                Expression right = parseFactor(); //
                result = new Term(result, opcode, right); //
            } else break; //TODO разобраться с этой строчкой
        }
        return result;
    }

    private Term.Opcode parseTermOperator() {
        return ;
    }

    private Expression parseFactor() {
        Expression result;
        if (inputStack.peek() instanceof Factor)
            result = inputStack.pop();
        else
            result = parsePrimary();
        while (true) {
            Factor.Opcode opcode = parseFactorOperator(); // //
            if (opcode != Factor.Opcode.) { // //
                Expression right = parsePrimary(); //
                result = new Factor(result, opcode, right); //
            } else break; //TODO разобраться с этой строчкой
        }
        return result;
    }

    private Factor.Opcode parseFactorOperator() {
        return ;
    }

//    private Expression parsePrimary() {
//    }

    private Primary parsePrimary() {
        Expression result;
        if (inputStack.peek() instanceof Primary)
            result = inputStack.pop();
        else
            result = null;
        if (Char.IsDigit(nextChar()) )
            result = parseInteger();
        else if (nextChar() == '(' ) {
            result = parse();
            skipNextChar(); // skip ‘)’
        }
        else
        { ... } // error
        return result;
    }

    private Primary parseInteger() {
        Expression result;
        if (inputStack.peek() instanceof Integer)
            result = inputStack.pop();
        else
            result = null; //TODO переделать строчку
        return result;
    }

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

                /**
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
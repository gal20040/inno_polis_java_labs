package UI_2016.fall.ItP.ExpressionCalculatorSerializer.ShuntingYard;

import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.*;
import UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions.Integer;
import sun.misc.Queue;
import java.util.Stack;

public class InfixParser {
    private Stack<Expression> stackRPN = new Stack<>();

    /**
     * Evaluates input queue in Reverse Polish notation.
     * @param inputQueue - queue with elements: Logical, Relation, Term, Factor, Primary, Integer, Parenthesized
     * @return queue of objects in RPN.
     * @throws InterruptedException
     */
    public Stack<Expression> parseStringToRPN(Queue<Expression> inputQueue) throws InterruptedException {
        Stack<Expression> parserStack = new Stack<>();

        while (!inputQueue.isEmpty()) {
            Expression expression = inputQueue.dequeue();

            if (expression instanceof Integer
//                    || ((char) expression.getValue() == '.') //TODO implement algorithm with float number.
                    ) {
                // 1. If the incoming symbols is an operand, print it.
                // if it's a number or a sign
                // or if it is '.' (dot as separator between integer and fractional parts of real number)
                stackRPN.add(expression);
            }
            else if (expression.getValue().toString().equals(Parenthesized.Opcode.LEFT_BRACKET.toString())) {
                // 2. If the incoming symbol is a left parenthesis, push it on the parserStack.
                parserStack.push(expression);
            }
            else if (expression.getValue().toString().equals(Parenthesized.Opcode.RIGHT_BRACKET.toString())) {
				/*
				 * 3. If the incoming symbol is a right parenthesis: discard the
				 * right parenthesis, pop and print the parserStack symbols until you
				 * see a left parenthesis. Pop the left parenthesis and discard
				 * it.
				 */

                String signForChecking = expression.getValue().toString();

                while (!signForChecking.equals(Parenthesized.Opcode.LEFT_BRACKET.toString())) {
                    Expression tempSign = parserStack.pop();
                    signForChecking = tempSign.getValue().toString();
                    if (!(tempSign instanceof Parenthesized)) {
                        addStackRPNElement(tempSign.getValue().toString());
                    }
                }
            }
            else if (expression instanceof Factor
                    || expression instanceof Term
                    || expression instanceof Relation
                    || expression instanceof Logical) {
				/* If the incoming symbol is an operator... */
                String topElement = "$"; //пустышка
                if (parserStack.size() > 0) {
                    topElement = parserStack.peek().getValue().toString();
                }

                // determine precedences
                int precedenceOfTopElement = getPrecedenceOfSign(topElement);
                int precedenceOfCurrentElement = getPrecedenceOfSign(expression.getValue().toString());

                if (parserStack.size() == 0
                        || topElement.equals(Parenthesized.Opcode.LEFT_BRACKET.toString())) {
					/*
					 * ... and the parserStack is empty, push the incoming operator onto the parserStack.
					 * ... or contains a left parenthesis on top, push the incoming operator onto the parserStack.
					 */
                    parserStack.push(expression);
                }
                else if (precedenceOfCurrentElement > precedenceOfTopElement
                        || (precedenceOfCurrentElement == precedenceOfTopElement && (expression.getValue().toString()).equals("^"))
                        ) {
					/*
					 * ... and has either higher precedence than the operator on the top of the parserStack,
					 * or has the same precedence as the operator on the top of the parserStack
					 * and is right associative,
					 *
					 * than push the incoming operator onto the parserStack.
					 */
                    parserStack.push(expression);

                }
                else if (precedenceOfCurrentElement < precedenceOfTopElement
                        || (precedenceOfCurrentElement == precedenceOfTopElement && !(expression.getValue().toString()).equals("^"))
                        ) {
					/* ... and has either lower precedence than the operator on the top of the parserStack,
					 * or has the same precedence as the operator on the top of the parserStack and is left associative
					 *
					 * -- continue to pop the parserStack until this is not true. Then, push the incoming operator.*/

                    boolean needRepeat = true;

                    while (needRepeat
                            && (precedenceOfCurrentElement < precedenceOfTopElement
                            || (precedenceOfCurrentElement == precedenceOfTopElement && !(expression.getValue().toString()).equals("^"))
                    )
                            ) {
                        Expression tempSign = parserStack.pop();
                        if (!(tempSign instanceof Parenthesized)) {
                            addStackRPNElement(tempSign.getValue().toString());
                        }

                        if (parserStack.size() > 0) {
                            topElement = parserStack.peek().getValue().toString();

                            // determine precedences
                            precedenceOfTopElement = getPrecedenceOfSign(topElement);
                            precedenceOfCurrentElement = getPrecedenceOfSign(expression.getValue().toString());
                        } else {
                            needRepeat = false;
                        }
                    }

                    parserStack.push(expression);
                }
            }
        }

        for (int j = parserStack.size() - 1; j >= 0; j--) {
			/*
			 * 7. At the end of the
			 * expression, pop and print all operators on the parserStack. (No
			 * parentheses should remain.)
			 */
            Expression tempSign = parserStack.pop();
            if (!(tempSign instanceof Parenthesized))
                addStackRPNElement(tempSign.getValue().toString());
        }
        return stackRPN;
    }

    private void addStackRPNElement(String tempSign) {
        Expression right = stackRPN.pop();
        Expression left = stackRPN.pop();
        Term.Opcode termOpCode = null;
        Factor.Opcode factorOpCode = null;
        Relation.Opcode relationOpCode = null;
        Logical.Opcode logicalOpCode = null;

        switch (tempSign) {
            case "+":
                termOpCode = Term.Opcode.PLUS;
            case "-":
                if (termOpCode == null)
                    termOpCode = Term.Opcode.MINUS;
                stackRPN.add(new Term(left, termOpCode, right));
                break;

            case "*":
                factorOpCode = Factor.Opcode.MULTIPLICATION;
            case "/":
                if (factorOpCode == null)
                    factorOpCode = Factor.Opcode.DIVISION;
                stackRPN.add(new Factor(left, factorOpCode, right));
                break;

            case "<":
                relationOpCode = Relation.Opcode.LESS;
            case "<=":
                if (relationOpCode == null)
                    relationOpCode = Relation.Opcode.LESS_EQUAL;
            case ">":
                if (relationOpCode == null)
                    relationOpCode = Relation.Opcode.GREATER;
            case ">=":
                if (relationOpCode == null)
                    relationOpCode = Relation.Opcode.GREATER_EQUAL;
            case "=":
                if (relationOpCode == null)
                    relationOpCode = Relation.Opcode.EQUAL;
            case "!=":
                if (relationOpCode == null)
                    relationOpCode = Relation.Opcode.NOT_EQUAL;
                stackRPN.add(new Relation(left, relationOpCode, right));
                break;
            case "and":
                logicalOpCode = Logical.Opcode.AND;
            case "or":
                if (logicalOpCode == null)
                    logicalOpCode = Logical.Opcode.OR;
            case "xor":
                if (logicalOpCode == null)
                    logicalOpCode = Logical.Opcode.XOR;
                stackRPN.add(new Logical(left, logicalOpCode, right));
                break;
        }
    }

    private int getPrecedenceOfSign(String object) {
        int precedenceOfTopElement = 0;

        if (object.equals(Factor.Opcode.MULTIPLICATION.toString())
                || object.equals(Factor.Opcode.DIVISION.toString())) {
            precedenceOfTopElement = 4;
        } else if (object.equals(Term.Opcode.PLUS.toString())
                || object.equals(Term.Opcode.MINUS.toString())) {
            precedenceOfTopElement = 3;
        } else if (object.equals(Relation.Opcode.LESS.toString())
                || object.equals(Relation.Opcode.LESS_EQUAL.toString())
                || object.equals(Relation.Opcode.GREATER.toString())
                || object.equals(Relation.Opcode.GREATER_EQUAL.toString())
                || object.equals(Relation.Opcode.EQUAL.toString())
                || object.equals(Relation.Opcode.NOT_EQUAL.toString())) {
            precedenceOfTopElement = 2;
        } else if (object.equals(Logical.Opcode.AND.toString())
                || object.equals(Logical.Opcode.OR.toString())
                || object.equals(Logical.Opcode.XOR.toString())) {
            precedenceOfTopElement = 1;
        }

        return precedenceOfTopElement;
    }
}
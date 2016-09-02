//package DSA.codetest.edu.innopolis.ru.Assignment1.ShuntingYard;

import java.util.ArrayList;

/**
 * Statement
 4 points
 1. Implement LinkedStack and LinkedQueue classes.
 2. Implement shunting-yard algorithm for arithmetic operators ("+ - * /") and brackets ("()").
 No functions handling required.
 3. Implement evaluation of stringRPN method for double values.

 Read expression from input.txt file. Write result to output.txt rounded to 2 decimal digits after the point.

 Example
 input.txt
 (1 + 5)/(7 + 1)
 (7-8)*(4/5)*3+0.25

 output.txt
 0.75
 -2.15
 */
class AShuntingYard {
    private static MyLinkedStack<Object> stack = new MyLinkedStack<>();
    private static String stringRPN = "";

    public static void main(String[] args) {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<Integer> inputArray = fileReaderWriter.readFromInputFile();

        parseString(inputArray);

        fileReaderWriter.writeToOutputFile(String.format("%.2f", calculate(stringRPN)));
    }

    private static Double calculate(String stringIn) {
        double tempDouble;
        MyLinkedStack<Double> stackForDouble = new MyLinkedStack<>();
        boolean nowWeAreProcessingNumber = false;
        boolean nowWeAreProcessingFractionalPart = false;
        int rate = 1;

        for (int i = 0; i < stringIn.length(); i++) {
            char sign = stringIn.charAt(i);

            if ((sign == ' ')) {
                nowWeAreProcessingNumber = false;
                nowWeAreProcessingFractionalPart = false;
            } else if ((sign == '.')) {
                nowWeAreProcessingFractionalPart = true;
                rate = 1;
            } else if (isNumeric(sign + "")) {
                // if it's a number
                tempDouble = 0;
                if (nowWeAreProcessingNumber) {
                    if (nowWeAreProcessingFractionalPart) {
                        tempDouble = stackForDouble.pop();
                        rate = rate * 10;
                    } else {
                        tempDouble = stackForDouble.pop() * 10;
                    }
                }
                stackForDouble.push(tempDouble + Double.parseDouble(sign + "") / rate);
                nowWeAreProcessingNumber = true;
            } else if (sign == '+') {
                stackForDouble.push(stackForDouble.pop() + stackForDouble.pop());
            } else if (sign == '-') {
                tempDouble = stackForDouble.pop();
                stackForDouble.push(stackForDouble.pop() - tempDouble);
            } else if (sign == '*') {
                stackForDouble.push(stackForDouble.pop() * stackForDouble.pop());
            } else if (sign == '/') {
                tempDouble = stackForDouble.pop();
                stackForDouble.push(stackForDouble.pop() / tempDouble);
            } else if (sign == '^') {
                tempDouble = stackForDouble.pop();
                stackForDouble.push(Math.pow(stackForDouble.pop(), tempDouble));
            }
        }

        return stackForDouble.pop();
    }

    private static void parseString(ArrayList<Integer> inputArray) {
        for (int i = 0; i < inputArray.size(); i++) {
            char sign = (char) (inputArray.get(i) + 0); //без 0 компилятор отказывается кастовать Integer в char

//            if (sign == ' ') {
//
//            } else
            if (isNumeric(sign + "")
                    || (sign == '.')
                    || (sign >= 'a' && sign <= 'z')
                    || (sign >= 'A' && sign <= 'Z')) {
                // 1. If the incoming symbols is an operand, print it.
                // if it's a number or a sign
                // or if it is '.' (dot as separator between integer and fractional parts of real number)
                stringRPN = stringRPN + sign;
            }
            else if (sign == '(') {
                // 2. If the incoming symbol is a left parenthesis, push it on the stack.
                stack.push(sign);
            }
            else if (sign == ')') {
				/*
				 * 3. If the incoming symbol is a right parenthesis: discard the
				 * right parenthesis, pop and print the stack symbols until you
				 * see a left parenthesis. Pop the left parenthesis and discard
				 * it.
				 */

                char signForChecking = sign;

                while (signForChecking != '(') {
                    char tempChar = (char) stack.pop();
                    signForChecking = tempChar;
                    if (tempChar != '(' && tempChar != ')') {
                        stringRPN = stringRPN + tempChar;
                    }
                }
            }
            else if ((sign == '+' || sign == '-' || sign == '*' || sign == '/' || sign == '^')) {
                stringRPN = stringRPN + " ";

				/* If the incoming symbol is an operator... */

                char topElement = '$'; //пустышка
                if (stack.getSize() > 0) {
                    topElement = (char) stack.peek();
                }

                // determine precedences
                int precedenceOfTopElement = getPrecedenceOfSign(topElement);
                int precedenceOfCurrentElement = getPrecedenceOfSign(sign);

                if (stack.getSize() == 0
                        || topElement == '(') {
					/*
					 * ... and the stack is empty, push the incoming operator onto the stack.
					 * ... or contains a left parenthesis on top, push the incoming operator onto the stack.
					 */
                    stack.push(sign);
                }
                else if (precedenceOfCurrentElement > precedenceOfTopElement
                        || (precedenceOfCurrentElement == precedenceOfTopElement && sign == '^')
                        ) {
					/*
					 * ... and has either higher precedence than the operator on the top of the stack,
					 * or has the same precedence as the operator on the top of the stack
					 * and is right associative,
					 *
					 * than push the incoming operator onto the stack.
					 */
                    stack.push(sign);

                }
                else if (precedenceOfCurrentElement < precedenceOfTopElement
                        || (precedenceOfCurrentElement == precedenceOfTopElement && sign != '^')) {
					/* ... and has either lower precedence than the operator on the top of the stack,
					 * or has the same precedence as the operator on the top of the stack and is left associative
					 *
					 * -- continue to pop the stack until this is not true. Then, push the incoming operator.*/

                    boolean needRepeat = true;

                    while (needRepeat
                            && (precedenceOfCurrentElement < precedenceOfTopElement
                            || (precedenceOfCurrentElement == precedenceOfTopElement && sign != '^')
                    )
                            ) {
                        char tempChar = (char) stack.pop();
                        if (tempChar != '(' && tempChar != ')') {
                            stringRPN = stringRPN + tempChar;// + " ";
                        }

                        if (stack.getSize() > 0) {
                            topElement = (char) stack.peek();

                            // determine precedences
                            precedenceOfTopElement = getPrecedenceOfSign(topElement);
                            precedenceOfCurrentElement = getPrecedenceOfSign(sign);
                        } else {
                            needRepeat = false;
                        }
                    }

                    stack.push(sign);
                }
            }
        }

        for (int j = stack.getSize() - 1; j >= 0; j--) {
			/*
			 * 7. At the end of the
			 * expression, pop and print all operators on the stack. (No
			 * parentheses should remain.)
			 */
            char tempChar = (char) stack.pop();
            if (tempChar != '(' && tempChar != ')')
                stringRPN = stringRPN + tempChar;// + " ";
        }
    }

    private static int getPrecedenceOfSign(char c) {
        int precedenceOfTopElement = 0;
        switch (c) {
            case '^':
                precedenceOfTopElement = 3;
                break;
            case '*':
                precedenceOfTopElement = 2;
                break;
            case '/':
                precedenceOfTopElement = 2;
                break;
            case '+':
                precedenceOfTopElement = 1;
                break;
            case '-':
                precedenceOfTopElement = 1;
                break;
        }

        return precedenceOfTopElement;
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
        // '-' and decimal.
    }
}
package UI_2016.fall.ru.Assignment1.ShuntingYard;

class InfixParser {
    MyLinkedQueue<Integer> parseString(MyLinkedQueue<Integer> inputQueue) {
        MyLinkedStack<Object> parserStack = new MyLinkedStack<>();
        MyLinkedQueue<Integer> queueRPN = new MyLinkedQueue<>();
        for (int i = 0; i < inputQueue.getSize(); ) { /*we don't need to iterate 'i' - inputQueue.queueSize will change every dequeue()*/
            char sign = (char) (inputQueue.dequeue() + 0); //without '+ 0' compiler refuses to cast Integer into char

            if (isNumeric(sign + "")
                    || (sign == '.')
                    || (sign >= 'a' && sign <= 'z')
                    || (sign >= 'A' && sign <= 'Z')) {
                // 1. If the incoming symbols is an operand, print it.
                // if it's a number or a sign
                // or if it is '.' (dot as separator between integer and fractional parts of real number)
                queueRPN.enqueue((int) sign); //TODO не знаю, как сделать MyLinkedQueue<> для хранения символов - нет типа Char
            }
            else if (sign == '(') {
                // 2. If the incoming symbol is a left parenthesis, push it on the parserStack.
                parserStack.push(sign);
            }
            else if (sign == ')') {
				/*
				 * 3. If the incoming symbol is a right parenthesis: discard the
				 * right parenthesis, pop and print the parserStack symbols until you
				 * see a left parenthesis. Pop the left parenthesis and discard
				 * it.
				 */

                char signForChecking = sign;

                while (signForChecking != '(') {
                    char tempChar = (char) parserStack.pop();
                    signForChecking = tempChar;
                    if (tempChar != '(' && tempChar != ')') {
                        queueRPN.enqueue((int) tempChar);
                    }
                }
            }
            else if ((sign == '+' || sign == '-' || sign == '*' || sign == '/' || sign == '^')) {
                queueRPN.enqueue((int) ' ');

				/* If the incoming symbol is an operator... */
                char topElement = '$'; //пустышка
                if (parserStack.getSize() > 0) {
                    topElement = (char) parserStack.peek();
                }

                // determine precedences
                int precedenceOfTopElement = getPrecedenceOfSign(topElement);
                int precedenceOfCurrentElement = getPrecedenceOfSign(sign);

                if (parserStack.getSize() == 0
                        || topElement == '(') {
					/*
					 * ... and the parserStack is empty, push the incoming operator onto the parserStack.
					 * ... or contains a left parenthesis on top, push the incoming operator onto the parserStack.
					 */
                    parserStack.push(sign);
                }
                else if (precedenceOfCurrentElement > precedenceOfTopElement
                        || (precedenceOfCurrentElement == precedenceOfTopElement && sign == '^')
                        ) {
					/*
					 * ... and has either higher precedence than the operator on the top of the parserStack,
					 * or has the same precedence as the operator on the top of the parserStack
					 * and is right associative,
					 *
					 * than push the incoming operator onto the parserStack.
					 */
                    parserStack.push(sign);

                }
                else if (precedenceOfCurrentElement < precedenceOfTopElement
                        || (precedenceOfCurrentElement == precedenceOfTopElement && sign != '^')) {
					/* ... and has either lower precedence than the operator on the top of the parserStack,
					 * or has the same precedence as the operator on the top of the parserStack and is left associative
					 *
					 * -- continue to pop the parserStack until this is not true. Then, push the incoming operator.*/

                    boolean needRepeat = true;

                    while (needRepeat
                            && (precedenceOfCurrentElement < precedenceOfTopElement
                            || (precedenceOfCurrentElement == precedenceOfTopElement && sign != '^')
                    )
                            ) {
                        char tempChar = (char) parserStack.pop();
                        if (tempChar != '(' && tempChar != ')') {
                            queueRPN.enqueue((int) tempChar); //stringRPN = stringRPN + tempChar;// + " ";
                        }

                        if (parserStack.getSize() > 0) {
                            topElement = (char) parserStack.peek();

                            // determine precedences
                            precedenceOfTopElement = getPrecedenceOfSign(topElement);
                            precedenceOfCurrentElement = getPrecedenceOfSign(sign);
                        } else {
                            needRepeat = false;
                        }
                    }

                    parserStack.push(sign);
                }
            }
        }

        for (int j = parserStack.getSize() - 1; j >= 0; j--) {
			/*
			 * 7. At the end of the
			 * expression, pop and print all operators on the parserStack. (No
			 * parentheses should remain.)
			 */
            char tempChar = (char) parserStack.pop();
            if (tempChar != '(' && tempChar != ')')
                queueRPN.enqueue((int) tempChar); //stringRPN = stringRPN + tempChar;// + " ";
        }
        return queueRPN;
    }

    private int getPrecedenceOfSign(char c) {
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

    boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
        // '-' and decimal.
    }
}
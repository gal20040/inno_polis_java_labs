package homework5.shuntingyard;

import java.util.Scanner;

public class ShuntingYardAlgorithm {
	private static Lifo<Object> queue = new Lifo<Object>();
	private static String stringOut = "";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter string:");
		String stringIn;
		
//		stringIn = "A * B + C"; //A B * C +
//		stringIn = "A + B * C"; //A B C * +   !!!!
//		stringIn = "A * (B + C)"; //A B C + * !!!!
//		stringIn = "A - B + C"; //A B - C +
//		stringIn = "A * B ^ C + D"; //A B C ^ * D +
//		stringIn = "A * (B + C * D) + E"; //A B C D * + * E +
		
		stringIn = scanner.nextLine();

		parseString(stringIn);

		System.out.println("result: " + stringOut);
		scanner.close();
	}

	private static void parseString(String stringIn) {
		for (int i = 0; i < stringIn.length(); i++) {
			char sign = stringIn.charAt(i);

			if (sign == ' ') {
				
			} else if (isNumeric(sign + "") || (sign >= 'a' && sign <= 'z') || (sign >= 'A' && sign <= 'Z')) {
				// 1. If the incoming symbols is an operand, print it.
				// if it's a number or a sign
				stringOut = stringOut + sign + " ";
			}
			else if (sign == '(') {
				// 2. If the incoming symbol is a left parenthesis, push it on the stack.
				queue.add(sign);
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
					char tempChar = (char) queue.get(queue.getElementsNumber() - 1);
					queue.remove(queue.getElementsNumber() - 1);
					signForChecking = tempChar;
					if (tempChar != '(' && tempChar != ')') {
						stringOut = stringOut + tempChar + " ";
					}
				}
			}
			else if ((sign == '+' || sign == '-' || sign == '*' || sign == '/' || sign == '^')) {
				/* If the incoming symbol is an operator... */

				char topElement = '$'; //пустышка
				if (queue.getElementsNumber() > 0) {
					topElement = (char) queue.get(queue.getElementsNumber() - 1);
				}

				// determine precedences
				int precedenceOfTopElement = getPrecedenceOfSign(topElement);
				int precedenceOfCurrentElement = getPrecedenceOfSign(sign);

				if (queue.getElementsNumber() == 0
						|| topElement == '(') {
					/*
					 * ... and the stack is empty, push the incoming operator onto the stack.
					 * ... or contains a left parenthesis on top, push the incoming operator onto the stack.
					 */
					queue.add(sign);
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
					queue.add(sign);

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
						char tempChar = (char) queue.get(queue.getElementsNumber() - 1);
						queue.remove(queue.getElementsNumber() - 1);
						if (tempChar != '(' && tempChar != ')') {
							stringOut = stringOut + tempChar + " ";
						}
						
						if (queue.getElementsNumber() > 0) {
							topElement = (char) queue.get(queue.getElementsNumber() - 1);

							// determine precedences
							precedenceOfTopElement = getPrecedenceOfSign(topElement);
							precedenceOfCurrentElement = getPrecedenceOfSign(sign);
						} else {
							needRepeat = false;
						}
					}
					
					queue.add(sign);
				}
			}
		}
		
		for (int j = queue.getElementsNumber() - 1; j >= 0; j--) {
			/*
			 * 7. At the end of the
			 * expression, pop and print all operators on the stack. (No
			 * parentheses should remain.)
			 */
			char tempChar = (char) queue.get(j);
			queue.remove(j);
			if (tempChar != '(' && tempChar != ')')
				stringOut = stringOut + tempChar + " ";
		}
	}

	public static int getPrecedenceOfSign(char c) {
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

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}
}
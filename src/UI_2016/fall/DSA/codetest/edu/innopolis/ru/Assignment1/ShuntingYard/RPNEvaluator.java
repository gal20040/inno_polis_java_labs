package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment1.ShuntingYard;

class RPNEvaluator {
    Double calculate(MyLinkedQueue<Integer> queueRPN) {
        MyLinkedStack<Double> evaluatorStack = new MyLinkedStack<>();
        Double d;
        double tempDouble;
        boolean nowWeAreProcessingNumber = false;
        boolean nowWeAreProcessingFractionalPart = false;
        int rate = 1;
        InfixParser infixParser = new InfixParser();

        for (int i = 0; i < queueRPN.getSize(); ) { /*we don't need to iterate 'i' - inputQueue.queueSize will change every dequeue()*/
            char sign = (char) (queueRPN.dequeue() + 0);

            switch (sign) {
                case ' ':
                    nowWeAreProcessingNumber = false;
                    nowWeAreProcessingFractionalPart = false;
                    break;
                case '.':
                    nowWeAreProcessingFractionalPart = true;
                    rate = 1;
                    break;
                case '+':
                    d = evaluatorStack.pop() + evaluatorStack.pop();
                    evaluatorStack.push(d);
//                    evaluatorStack.push(evaluatorStack.pop() + evaluatorStack.pop());
                    break;
                case '-':
                    tempDouble = evaluatorStack.pop();
                    d = evaluatorStack.pop() - tempDouble;
                    evaluatorStack.push(d);
//                    evaluatorStack.push(evaluatorStack.pop() - tempDouble);
                    break;
                case '*':
                    d = evaluatorStack.pop() * evaluatorStack.pop();
                    evaluatorStack.push(d);
//                    evaluatorStack.push(evaluatorStack.pop() * evaluatorStack.pop());
                    break;
                case '/':
                    tempDouble = evaluatorStack.pop();
                    d = evaluatorStack.pop() / tempDouble;
                    evaluatorStack.push(d);
//                    evaluatorStack.push(evaluatorStack.pop() / tempDouble);
                    break;
                case '^':
                    tempDouble = evaluatorStack.pop();
                    d = Math.pow(evaluatorStack.pop(), tempDouble);
                    evaluatorStack.push(d);
//                    evaluatorStack.push(Math.pow(evaluatorStack.pop(), tempDouble));
                    break;
                default: {
                    if (infixParser.isNumeric(sign + "")) {
                        // if it's a number
                        tempDouble = 0;
                        if (nowWeAreProcessingNumber) {
                            if (nowWeAreProcessingFractionalPart) {
                                tempDouble = evaluatorStack.pop();
                                rate = rate * 10;
                            } else {
                                tempDouble = evaluatorStack.pop() * 10;
                            }
                        }
                        d = tempDouble + Double.parseDouble(sign + "") / rate;
                        evaluatorStack.push(d);
//                        evaluatorStack.push(tempDouble + Double.parseDouble(sign + "") / rate);
                        nowWeAreProcessingNumber = true;
                    }
                    break;
                }
            }

        }

        return evaluatorStack.pop();
    }
}
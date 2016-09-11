package UI_2016.fall.ru.Assignment1.ShuntingYard;

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
 (1 + 5)/(7 + 1) //1 5 + 7 1 + /
 (7-8)*(4/5)*3+0.25 //7 8 - 4 5 / * 3 * 2 +
 3+4*(2-1)+0.5 //3 4 2 1 - * +
 1+2*3+4 //1 2 3 * + 4 +

 output.txt
 0.75
 -2.15
 7.5
 11.0
 */
class AShuntingYard {
    public static void main(String[] args) {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        MyLinkedQueue<Integer> inputQueue = fileReaderWriter.readFromInputFile();

        InfixParser infixParser = new InfixParser();
        MyLinkedQueue<Integer> queueRPN = infixParser.parseString(inputQueue);

        RPNEvaluator rpnEvaluator = new RPNEvaluator();
        fileReaderWriter.writeToOutputFile(String.format("%.2f", rpnEvaluator.calculate(queueRPN)));
    }
}
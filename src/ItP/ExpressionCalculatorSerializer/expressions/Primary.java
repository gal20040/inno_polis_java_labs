package ItP.ExpressionCalculatorSerializer.expressions;

import java.util.PriorityQueue;

class Primary extends Expression {
    @Override
    long calculate() {return ;}

    public Primary() {}
    public Primary(Object value, Expression typeOfObject) {super(value, typeOfObject);}

    static Expression parsePrimary(PriorityQueue<Expression> inputQueue) {
        Expression result = null;
//        if (Character.isDigit(nextChar()) )
            result = Integer.parseInteger(inputQueue);
//        else if ( nextChar() == '(' ) {
//            result = parse();
//            skipNextChar(); // skip ‘)’
//        }
//        else { ... } // error

        return result;
    }
}
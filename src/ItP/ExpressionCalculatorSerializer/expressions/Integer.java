package ItP.ExpressionCalculatorSerializer.expressions;

import java.util.PriorityQueue;

public class Integer extends Primary {
    private long value;

    public Integer() {}
    public Integer(Object value, Expression typeOfObject) {super(value, typeOfObject);}

    static Expression parseInteger(PriorityQueue<Expression> inputQueue) {
        Expression result = null;
        return result;
    }
//...
}
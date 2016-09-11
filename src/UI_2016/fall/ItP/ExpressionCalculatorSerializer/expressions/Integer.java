package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import java.util.PriorityQueue;

public class Integer extends Primary {
    private long value;

    @Override
    public long calculate() {return value;} //TODO доделать

    @Override
    public String ToJSON() {return "";} //TODO доделать

    public Integer() {}
//    public Integer(Object value, Expression typeOfObject) {super(value, typeOfObject);}
    public Integer(Object value) {super(value);}

    static Expression parseInteger(PriorityQueue<Expression> inputQueue) {
        Expression result = null;
        return result;
    }
//...
}
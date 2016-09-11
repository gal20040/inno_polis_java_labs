package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import java.util.PriorityQueue;

public class Primary extends Expression {
    @Override
    public long calculate() {return 1;} //TODO доделать

    @Override
    public String ToJSON() {return "";} //TODO доделать

    public Primary() {}
//    public Primary(Object value, Expression typeOfObject) {super(value, typeOfObject);}
    public Primary(Object value) {super(value);}

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
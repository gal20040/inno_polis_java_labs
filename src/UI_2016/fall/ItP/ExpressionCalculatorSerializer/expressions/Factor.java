package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import java.util.PriorityQueue;

public class Factor extends Expression {
    public enum Opcode {
        MULTIPLICATION("*"),
        DIVISION("/");

        private final String text;

        Opcode(final String text) {this.text = text;}

        @Override
        public String toString() {return text;}
    }
    Opcode op;
    Primary left, right;

    public Factor() {}
    public Factor(Object value, Expression typeOfObject) {super(value, typeOfObject);}

    static Expression parseFactor(PriorityQueue<Expression> inputQueue) {
        Expression result = Primary.parsePrimary(inputQueue);
        return result;
    }
}
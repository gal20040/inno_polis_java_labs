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
    Opcode opcode;
    Expression /*Primary*/ left, right;

    public Factor() {}
    //    public Factor(Object value, Expression typeOfObject) {super(value, typeOfObject);}
    public Factor(Object value) {super(value);}

    public Factor(Expression left, Opcode opcode, Expression right) {
        this.left = left;
        this.opcode = opcode;
        this.right = right;
    }

    @Override
    public long calculate() {return 1;} //TODO доделать

    @Override
    public String ToJSON() {return "";} //TODO доделать

//    static Expression parseFactor(PriorityQueue<Expression> inputQueue) {
//        Expression result = Primary.parsePrimary(inputQueue);
//        return result;
//    }
}
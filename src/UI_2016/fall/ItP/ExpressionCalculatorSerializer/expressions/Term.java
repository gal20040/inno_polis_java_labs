package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import java.util.PriorityQueue;

public class Term extends Expression {
    public enum Opcode {
        PLUS("+"),
        MINUS("-");

        private final String text;

        Opcode(final String text) {this.text = text;}

        @Override
        public String toString() {return text;}
    }
    Opcode opcode;
    Expression /*Factor*/ left, right;

    public Term() {}
    //    public Term(Object value, Expression typeOfObject) {super(value, typeOfObject);}
    public Term(Object value) {super(value);}

    public Term(Expression left, Opcode opcode, Expression right) {
        this.left = left;
        this.opcode = opcode;
        this.right = right;
    }

    @Override
    public long calculate() {return 1;} //TODO доделать

    @Override
    public String ToJSON() {return "";} //TODO доделать

//    static Expression parseTerm(PriorityQueue<Expression> inputQueue) {
//        Expression result = Factor.parseFactor(inputQueue);
//        return result;
//    }
}
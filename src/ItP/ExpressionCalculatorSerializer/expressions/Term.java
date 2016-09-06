package ItP.ExpressionCalculatorSerializer.expressions;

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
    Opcode op;
    Factor left, right;

    public Term() {}
    public Term(Object value, Expression typeOfObject) {super(value, typeOfObject);}

    static Expression parseTerm(PriorityQueue<Expression> inputQueue) {
        Expression result = Factor.parseFactor(inputQueue);
        return result;
    }
}
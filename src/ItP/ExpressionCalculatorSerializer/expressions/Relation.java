package ItP.ExpressionCalculatorSerializer.expressions;

import java.util.PriorityQueue;

public class Relation extends Expression {
    public enum Opcode {
        LESS("<"),
        LESS_EQUAL("<="),
        GREATER(">"),
        GREATER_EQUAL(">="),
        EQUAL("="),
        NOT_EQUAL("!="),
//        EXCLAMATION_POINT("!"),
        NONE("NONE"); //TODO что такое NONE?

        private final String text;

        Opcode(final String text) {this.text = text;}

        @Override
        public String toString() {return text;}
    }
    Opcode op;
    Term /*Factor*/ left, right;

    public Relation() {}
    public Relation(Object value, Expression typeOfObject) {super(value, typeOfObject);}

    static Expression parseRelation(PriorityQueue<Expression> inputQueue) {
        Expression result = Term.parseTerm(inputQueue);
        return result;
    }
//...
}
package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

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
    Opcode opcode;
    Expression /*Term*/ /*Factor*/ left, right;

    public Relation() {}
    //    public Relation(Object value, Expression typeOfObject) {super(value, typeOfObject);}
    public Relation(Object value) {super(value);}

    public Relation(Expression left, Opcode opcode, Expression right) {
        this.left = left;
        this.opcode = opcode;
        this.right = right;
    }

    @Override
    public long calculate() {return 1;} //TODO доделать

    @Override
    public String ToJSON() {return "";} //TODO доделать

//    static Expression parseRelation(PriorityQueue<Expression> inputQueue) {
//        Expression result = Term.parseTerm(inputQueue);
//        return result;
//    }
//...
}
package ItP.ExpressionCalculatorSerializer.expressions;

public class Parenthesized extends Primary {
    public enum Opcode {
        LEFT_BRACKET("("),
        RIGHT_BRACKET(")");

        private final String text;

        Opcode(final String text) {this.text = text;}

        @Override
        public String toString() {return text;}
    }
//    Opcode op;
//    Term /*Factor*/ left, right;

    public Parenthesized() {}
    public Parenthesized(Object value, Expression typeOfObject) {super(value, typeOfObject);}

    private Expression expression;
//...
}
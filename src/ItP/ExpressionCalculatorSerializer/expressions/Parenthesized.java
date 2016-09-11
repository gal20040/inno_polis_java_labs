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
    private Expression expression;

    @Override
    long calculate() {return expression.calculate();}

    public Parenthesized() {}
    public Parenthesized(Object value, Expression typeOfObject) {super(value, typeOfObject);}


//...
}
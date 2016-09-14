package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import org.json.simple.JSONObject;

public class Parenthesized extends Primary {
    public enum Opcode {
        LEFT_BRACKET("("),
        RIGHT_BRACKET(")");

        private final String text;

        Opcode(final String text) {this.text = text;}

        @Override
        public String toString() {return text;}
    }

    @Override
    public long calculate() {assert false : "Unknown parenthesized operator";
        return 1;}

    @Override
    public JSONObject toJSON() {
        assert false : "Unknown parenthesized operator";
        return new JSONObject();}

    public Parenthesized(Object value) {super(value);}
}
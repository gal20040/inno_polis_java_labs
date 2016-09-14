package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import org.json.simple.JSONObject;

public class Logical extends Expression {
    public enum Opcode {
        AND("and"),
        OR("or"),
        XOR("xor"),
        NONE("none"); //TODO разобраться с NONE

        private final String text;

        Opcode(final String text) {this.text = text;}

        @Override
        public String toString() {return text;}
    }

    private Opcode opcode;
    private Expression left, right;

    @Override
    public long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();

        switch (opcode.toString()) {
            case "and":
                return ((r1 > 0) && (r2 > 0)) ? 1 : 0;
            case "or":
                return ((r1 > 0) || (r2 > 0)) ? 1 : 0;
            case "xor":
                return r1 != r2 ? 1 : 0;
        }
        assert false : "Unknown logical operator";
        return -999999999;
    }

    @Override
    public JSONObject toJSON() {
        //TODO реализовать общий метод для всех всех классов
        JSONObject obj = new JSONObject();
        obj.put("left", left.toJSON());
        obj.put("right", right.toJSON());

        obj.put("opCode", opcode.toString());
        return obj;}

    public Logical(Object value) {super(value);}

    public Logical(Expression left, Opcode opcode, Expression right) {
        this.left = left;
        this.opcode = opcode;
        this.right = right;
    }
}
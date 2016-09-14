package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import org.json.simple.JSONObject;

public class Term extends Expression {
    public enum Opcode {
        PLUS("+"),
        MINUS("-");

        private final String text;

        Opcode(final String text) {this.text = text;}

        @Override
        public String toString() {return text;}
    }
    private Opcode opcode;
    private Expression /*Factor*/ left, right;

    public Term(Object value) {super(value);}

    public Term(Expression left, Opcode opcode, Expression right) {
        this.left = left;
        this.opcode = opcode;
        this.right = right;
    }

    @Override
    public long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();
        switch (opcode.toString()) {
            case "+":
                return r1 + r2;
            case "-":
                return r1 - r2;
        }
        assert false : "Unknown term operator";
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
}
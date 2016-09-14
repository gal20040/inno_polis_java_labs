package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import org.json.simple.JSONObject;

class Primary extends Expression {
    @Override
    public long calculate() {assert false : "Unknown primary operator";
        return 1;}

    @Override
    public JSONObject toJSON() {
        //TODO реализовать общий метод для всех классов
        assert false : "Unknown primary operator";
        return new JSONObject();}

    Primary(Object value) {super(value);}
}
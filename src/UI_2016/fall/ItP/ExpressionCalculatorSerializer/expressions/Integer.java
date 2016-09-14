package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import org.json.simple.JSONObject;

public class Integer extends Primary {
    @Override
    public long calculate() {return java.lang.Integer.parseInt(super.getValue()+"");} //TODO доделать

    @Override
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("value", java.lang.Integer.parseInt(super.getValue()+""));
        return obj;}

    public Integer(Object value) {super(value);}
}
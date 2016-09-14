package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import org.json.simple.JSONObject;

public abstract class Expression {
    private Object value;

    Expression() {}
    Expression(Object value) {
        this.value = value;
    }

    public abstract long calculate();
    public abstract JSONObject toJSON();

    public Object getValue() {return value;}
    public void setValue(Object value) {this.value = value;}
}
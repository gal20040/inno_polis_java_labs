package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import java.util.PriorityQueue;

public abstract class Expression {
    private Object value;
//    private Expression typeOfObject;

    public Expression() {}
    public Expression(Object value /*, Expression typeOfObject*/) {
        this.value = value;
//        this.typeOfObject = typeOfObject;
    }

//    public Logical(Relation left, Opcode opcode, Relation right) {super(value);}

    public abstract long calculate();
    public abstract String ToJSON();


    public Object getValue() {return value;}
//    public Expression getTypeOfObject() {return typeOfObject;}
    public void setValue(Object value) {this.value = value;}
//    public void setTypeOfObject(Expression typeOfObject) {this.typeOfObject = typeOfObject;}

    public static Expression parseExpression(PriorityQueue<Expression> inputQueue) {
        Expression result = Logical.parseLogical(inputQueue);
//        Expression result = parseRelation();
//        while (true) {
//            Relation.Opcode op = parseLogOperator();
//            if ( op != Relation.Opcode.none ) {
//                Expression right = parseRelation();
//                result = new Logical(op,result,right);
//            }
//            break;
//        }
        return result;
    }
}
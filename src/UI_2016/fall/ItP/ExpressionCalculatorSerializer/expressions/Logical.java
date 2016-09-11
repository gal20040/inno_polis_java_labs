package UI_2016.fall.ItP.ExpressionCalculatorSerializer.expressions;

import java.util.PriorityQueue;

public class Logical extends Expression {
    public enum Opcode {
        AND("and"),
        OR("or"),
        XOR("xor"),
        NONE("none");

        private final String text;

        Opcode(final String text) {this.text = text;}

        @Override
        public String toString() {return text;}
    }

    Opcode opcode;
    Expression left, right;

    @Override
    public long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();

//        switch (op.toString()) {
//            case Opcode.AND:
//                return ((r1 > 0) && (r2 > 0)) ? 1 : 0;
////            break;
//            case Opcode.OR:
//                return ((r1 > 0) || (r2 > 0)) ? 1 : 0;
//...
//        }
        return 1; //TODO доделать
    }

    @Override
    public String ToJSON() {return "";} //TODO доделать

    public Logical() {}
//    public Logical(Object value, Expression typeOfObject) {super(value, typeOfObject);}
    public Logical(Object value) {super(value);}

    public Logical(Expression left, Opcode opcode, Expression right) {
        this.left = left;
        this.opcode = opcode;
        this.right = right;
    }

//    static Expression parseLogical(PriorityQueue<Expression> inputQueue) {
//        Expression result = Relation.parseRelation(inputQueue);
////        while (true) {
////            Relation.Opcode op = parseLogOperator();
////            if ( op != Relation.Opcode.none ) {
////                Expression right = parseRelation();
////                result = new Logical(op,result,right);
////            }
////            break;
////        }
//        return result;
//    }
//...
}
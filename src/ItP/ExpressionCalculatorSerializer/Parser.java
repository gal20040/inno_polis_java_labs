package ItP.ExpressionCalculatorSerializer;

import ItP.ExpressionCalculatorSerializer.expressions.Expression;

import java.util.PriorityQueue;

class Parser {
//    private String input;
//    public Parser(String s) {input = s;}
//    public Parser(String s) {}

    Expression parse(PriorityQueue<Expression> inputQueue) {return Expression.parseExpression(inputQueue);}
//...
}
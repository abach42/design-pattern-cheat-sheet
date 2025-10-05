package com.abach42.designpatterns.behavioral.interpreter;

// NonTerminalExpression
public record NotExpression(Expression expression) implements Expression {


    @Override
    public boolean interpret(Context context) {
        return !expression.interpret(context);
    }
}

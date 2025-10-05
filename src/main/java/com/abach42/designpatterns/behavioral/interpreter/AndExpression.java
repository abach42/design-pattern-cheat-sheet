package com.abach42.designpatterns.behavioral.interpreter;

// NonTerminalExpression
public record AndExpression(Expression first, Expression second) implements Expression {

    @Override
    public boolean interpret(Context context) {
        return first.interpret(context) && second.interpret(context);
    }
}

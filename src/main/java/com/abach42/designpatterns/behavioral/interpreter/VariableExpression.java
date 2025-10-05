package com.abach42.designpatterns.behavioral.interpreter;

// TerminalExpression
public record VariableExpression(String name) implements Expression {

    @Override
    public boolean interpret(Context context) {
        return context.lookup(name);
    }
}

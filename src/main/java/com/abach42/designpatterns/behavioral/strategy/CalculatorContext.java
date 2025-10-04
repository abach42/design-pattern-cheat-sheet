package com.abach42.designpatterns.behavioral.strategy;

public class CalculatorContext {

    private Strategy strategy;

    public void setBehavior(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int firstOperand, int secondOperand) {
        return strategy.performOperation(firstOperand, secondOperand);
    }
}
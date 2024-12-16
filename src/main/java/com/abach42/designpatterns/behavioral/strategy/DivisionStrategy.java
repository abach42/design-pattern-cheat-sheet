package com.abach42.designpatterns.behavioral.strategy;

public class DivisionStrategy implements Strategy {

    @Override
    public int performOperation(int firstOperand, int secondOperand) {
        if (secondOperand == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return firstOperand / secondOperand;
    }
}
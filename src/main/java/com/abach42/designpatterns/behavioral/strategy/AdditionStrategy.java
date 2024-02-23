package com.abach42.designpatterns.behavioral.strategy;

public class AdditionStrategy implements Strategy{

    @Override
    public int performOperation(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}
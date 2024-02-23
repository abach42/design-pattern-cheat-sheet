package com.abach42.designpatterns.strategy;

public class SubtractionStrategy implements Strategy{

    @Override
    public int performOperation(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
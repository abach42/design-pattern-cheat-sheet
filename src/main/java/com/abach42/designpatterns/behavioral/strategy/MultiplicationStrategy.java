package com.abach42.designpatterns.behavioral.strategy;

public class MultiplicationStrategy implements Strategy{

    @Override
    public int performOperation(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
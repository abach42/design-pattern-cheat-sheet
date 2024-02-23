package com.abach42.designpatterns.strategy;

public class StrategyApp {
    public static void main(String[] args) {
        CalculatorContext calculator = new CalculatorContext();
        calculator.setBehavior(new AdditionStrategy());
        calculator.calculate(1,1);
        calculator.setBehavior(new DivisionStrategy());

        try {
            calculator.calculate(4, 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
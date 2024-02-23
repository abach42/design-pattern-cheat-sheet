package com.abach42.designpatterns.behavioral.strategy;

/*
 * The Strategy pattern is a behavioral design pattern that allows you to define a family of algorithms, encapsulate each one of them, 
 * and make them interchangeable. 
 * It enables a client to choose a particular algorithm from the family of algorithms at runtime without altering the client's code.
 */
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
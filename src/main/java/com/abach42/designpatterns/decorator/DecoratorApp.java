package com.abach42.designpatterns.decorator;

public class DecoratorApp {
    public static void main(String[] args) {
        Component order = new FoamMilk(
            new Chocolate(
                new Espresso()
            )
        );

        System.out.println(String.format("%.2f", order.calculatePrice()));
    }
}

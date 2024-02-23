package com.abach42.designpatterns.structural.decorator;

/*
 * The Decorator pattern allows you to stack decorators on top of each other, each adding its own behavior, 
 * and providing a flexible way to modify the behavior of individual objects at runtime. It promotes code reuse and separation 
 * of concerns, as decorators can be combined in various ways to achieve different effects without 
 * modifying the original object.
 */
public class AppDecorator {
    public static void main(String[] args) {
        Component order = new FoamMilkDecorator(
            new ChocolateDecorator(
                new EspressoComponent()
            )
        );

        System.out.println(String.format("%.2f", order.calculatePrice()));
    }
}

package com.abach42.designpatterns.structural.decorator;

import java.math.BigDecimal;

public class ChocolateDecorator extends Decorator {

    public ChocolateDecorator(Component component) {
        super(component);
    }

    @Override
    public BigDecimal calculatePrice() {
        return component.calculatePrice().add(new BigDecimal("1.99"));
    }
}
package com.abach42.designpatterns.decorator;

import java.math.BigDecimal;

public class Chocolate extends Decorator {

    public Chocolate(Component component) {
        super(component);
    }

    @Override
    public BigDecimal calculatePrice() {
        return component.calculatePrice().add(new BigDecimal("1.99"));
    }
}
package com.abach42.designpatterns.decorator;

import java.math.BigDecimal;

public class Soy extends Decorator{

    public Soy(Component component) {
        super(component);
    }

    @Override
    public BigDecimal calculatePrice() {
        return component.calculatePrice().add(new BigDecimal("3.29"));
    }
}
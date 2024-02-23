package com.abach42.designpatterns.structural.decorator;

import java.math.BigDecimal;

public class FoamMilkDecorator extends Decorator {

    public FoamMilkDecorator(Component component) {
        super(component);
    }

    @Override
    public BigDecimal calculatePrice() {
        return component.calculatePrice().add(new BigDecimal("2.39"));
    }
}
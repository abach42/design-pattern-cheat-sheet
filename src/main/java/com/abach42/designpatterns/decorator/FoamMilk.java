package com.abach42.designpatterns.decorator;

import java.math.BigDecimal;

public class FoamMilk extends Decorator {

    public FoamMilk(Component component) {
        super(component);
    }

    @Override
    public BigDecimal calculatePrice() {
        return component.calculatePrice().add(new BigDecimal("2.39"));
    }
}
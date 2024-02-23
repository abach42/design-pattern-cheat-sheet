package com.abach42.designpatterns.decorator;

import java.math.BigDecimal;

public class Espresso implements Component {

    @Override
    public BigDecimal calculatePrice() {
        return new BigDecimal("3.49");
    }
}

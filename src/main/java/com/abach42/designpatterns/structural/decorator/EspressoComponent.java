package com.abach42.designpatterns.structural.decorator;

import java.math.BigDecimal;

public class EspressoComponent implements Component {

    @Override
    public BigDecimal calculatePrice() {
        return new BigDecimal("3.49");
    }
}

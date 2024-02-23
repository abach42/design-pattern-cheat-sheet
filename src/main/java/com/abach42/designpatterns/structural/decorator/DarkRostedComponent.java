package com.abach42.designpatterns.structural.decorator;

import java.math.BigDecimal;

public class DarkRostedComponent implements Component {

    @Override
    public BigDecimal calculatePrice() {
        return new BigDecimal("4.49");
    }
}

package com.abach42.designpatterns.decorator;

import java.math.BigDecimal;

public class DarkRosted implements Component {

    @Override
    public BigDecimal calculatePrice() {
        return new BigDecimal("4.49");
    }
}

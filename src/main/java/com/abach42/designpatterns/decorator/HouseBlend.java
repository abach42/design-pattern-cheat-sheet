package com.abach42.designpatterns.decorator;

import java.math.BigDecimal;

public class HouseBlend implements Component {
    @Override
    public BigDecimal calculatePrice() {
        return new BigDecimal("2.99");
    }
}
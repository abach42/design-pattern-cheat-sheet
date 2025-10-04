package com.abach42.designpatterns.structural.decorator;

import java.math.BigDecimal;

public class HouseBlendComponent implements Component {

    @Override
    public BigDecimal calculatePrice() {
        return new BigDecimal("2.99");
    }
}
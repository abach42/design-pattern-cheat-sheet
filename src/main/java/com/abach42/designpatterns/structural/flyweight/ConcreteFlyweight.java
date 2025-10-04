package com.abach42.designpatterns.structural.flyweight;

public class ConcreteFlyweight implements Flyweight {

    private final String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public String operation(String extrinsicState) {
        return "Intrinsic: " + intrinsicState + ", Extrinsic: " + extrinsicState;
    }
}

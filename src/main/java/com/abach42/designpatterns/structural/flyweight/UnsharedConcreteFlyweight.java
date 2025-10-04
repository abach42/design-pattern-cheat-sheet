package com.abach42.designpatterns.structural.flyweight;

public class UnsharedConcreteFlyweight implements Flyweight {

    private final String allState;

    public UnsharedConcreteFlyweight(String allState) {
        this.allState = allState;
    }

    @Override
    public String operation(String extrinsicState) {
        return "Unshared: " + allState + ", Extrinsic: " + extrinsicState;
    }
}

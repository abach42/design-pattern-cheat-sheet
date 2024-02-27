package com.abach42.designpatterns.creational.prototype;

public class CirclePrototype extends Prototype {
    public int radius;

    public CirclePrototype() {
    }

    public CirclePrototype(CirclePrototype prototype) {
        super(prototype);
        this.radius = prototype.radius;
    }

    @Override
    public Prototype clone() {
        return new CirclePrototype(this);
    }

    @Override
    public boolean equals(Object comparison) {
        if(false == comparison instanceof CirclePrototype
            || false == super.equals(comparison)
        ) {
            return false;
        }

        CirclePrototype prototype = (CirclePrototype) comparison;
        return prototype.radius == this.radius;
    }
}
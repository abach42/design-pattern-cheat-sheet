package com.abach42.designpatterns.creational.prototype;

import java.awt.Point;

public abstract class Prototype extends Point {
    // interface Cloneable for the type Prototype, already defined by Point2D, consider to use it otherwise
    public String color;

    public Prototype() {
    }

    public Prototype(Prototype prototype) {
        super(prototype.x, prototype.y);
        this.color = prototype.color;
    }

    public abstract Prototype clone();

    @Override
    public boolean equals(Object comparison) {
        if(false == comparison instanceof Prototype) {
            return false;
        }

        Prototype prototype = (Prototype) comparison;
        return prototype.x == this.x 
            && prototype.y == this.y
            && color.equals(prototype.color);
    }
}
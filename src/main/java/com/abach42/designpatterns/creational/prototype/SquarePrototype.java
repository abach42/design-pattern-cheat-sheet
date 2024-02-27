package com.abach42.designpatterns.creational.prototype;

public class SquarePrototype extends Prototype {
    public int side;

    public SquarePrototype() {
    }

    public SquarePrototype(SquarePrototype prototype) {
        super(prototype);
        this.side = prototype.side;
    }

    @Override
    public Prototype clone() {
        return new SquarePrototype(this);
    }

    @Override
    public boolean equals(Object comparison) {
        if( false == comparison instanceof SquarePrototype
            || false == super.equals(comparison)
        ) {
            return false;
        }
        
        SquarePrototype prototype = (SquarePrototype) comparison;
        return prototype.side == this.side;
    }
}
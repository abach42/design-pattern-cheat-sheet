package com.abach42.designpatterns.creational.factorymethod;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

public class SquareProduct implements Product {
    private Point topLeft;
    private int side;

    public SquareProduct(Point topLeft, int side) {
        super();
        this.topLeft = topLeft;
        this.side = side;
    }

    @Override
    public Shape getShape() {
        return new Rectangle(topLeft.x, topLeft.y, side, side);
    }
}
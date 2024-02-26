package com.abach42.designpatterns.creational.factorymethod;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class CircleProduct implements Product {
    private Point center;
    private int radius;

    public CircleProduct(Point center, int radius) {
        super();
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(center.x - radius, center.y - radius, 2 * radius, 2 * radius);
    }
}
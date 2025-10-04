package com.abach42.designpatterns.structural.bridge;

import java.awt.geom.Point2D;

// "Refined Abstraction"
public class Circle extends Shape {

    private final double radius;
    private final Point2D center;

    public Circle(Renderer renderer, double radius, Point2D center) {
        super(renderer);
        this.radius = radius;
        this.center = center;
    }

    @Override
    public Object draw() {
        return renderer.renderCircle(radius, center);
    }
}

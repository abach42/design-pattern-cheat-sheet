package com.abach42.designpatterns.structural.bridge;

import java.awt.geom.Point2D;

// "Refined Abstraction"
public class Rectangle extends Shape {

    private final double width;
    private final double height;
    private final Point2D topLeft;

    public Rectangle(Renderer renderer, double width, double height, Point2D topLeft) {
        super(renderer);
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
    }

    @Override
    public Object draw() {
        return renderer.renderRectangle(width, height, topLeft);
    }
}
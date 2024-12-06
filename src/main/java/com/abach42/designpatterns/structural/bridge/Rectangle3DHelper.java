package com.abach42.designpatterns.structural.bridge;

public class Rectangle3DHelper {
    public Point3DHelper topLeft;
    
    public double width, height;

    public Rectangle3DHelper(Point3DHelper topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }
}
package com.abach42.designpatterns.structural.bridge.geom;

//Helper does not belong to pattern
public class Circle3DHelper {

    public Point3DHelper center;
    public double radius;

    public Circle3DHelper(Point3DHelper center, double radius) {
        this.center = center;
        this.radius = radius;
    }
}
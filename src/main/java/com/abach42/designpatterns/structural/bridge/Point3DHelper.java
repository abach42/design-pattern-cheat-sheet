package com.abach42.designpatterns.structural.bridge;

public class Point3DHelper {
    public double x, y, z;

    public Point3DHelper(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
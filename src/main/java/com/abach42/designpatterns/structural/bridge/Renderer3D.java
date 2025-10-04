package com.abach42.designpatterns.structural.bridge;

import com.abach42.designpatterns.structural.bridge.geom.Circle3DHelper;
import com.abach42.designpatterns.structural.bridge.geom.Point3DHelper;
import com.abach42.designpatterns.structural.bridge.geom.Rectangle3DHelper;
import java.awt.geom.Point2D;

// "Concrete Implementator"
public class Renderer3D implements Renderer {

    @Override
    public Circle3DHelper renderCircle(double radius, Point2D center) {
        return new Circle3DHelper(
                new Point3DHelper(center.getX(), center.getY(), 0), // Assume z = 0 for simplicity
                radius
        );
    }

    @Override
    public Rectangle3DHelper renderRectangle(double width, double height, Point2D topLeft) {
        return new Rectangle3DHelper(
                new Point3DHelper(topLeft.getX(), topLeft.getY(), 0), // Assume z = 0 for simplicity
                width,
                height
        );
    }
}
package com.abach42.designpatterns.structural.bridge;

import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

// "Concrete Implementator"
public class Renderer2D implements Renderer {
    
    @Override
    public Ellipse2D renderCircle(double radius, Point2D center) {
        return new Ellipse2D.Double(
                center.getX() - radius, // x-coordinate of the top-left corner
                center.getY() - radius, // y-coordinate of the top-left corner
                2 * radius, // width
                2 * radius  // height
        );
    }

    @Override
    public Rectangle2D renderRectangle(double width, double height, Point2D topLeft) {
        return new Rectangle2D.Double(
                topLeft.getX(),
                topLeft.getY(),
                width,
                height
        );
    }
}
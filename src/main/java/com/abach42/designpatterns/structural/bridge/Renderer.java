package com.abach42.designpatterns.structural.bridge;

import java.awt.geom.Point2D;

// "Implementator"
public interface Renderer {

    Object renderCircle(double radius, Point2D center);

    Object renderRectangle(double width, double height, Point2D topLeft);
}
package com.abach42.designpatterns.structural.bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.abach42.designpatterns.structural.bridge.geom.Circle3DHelper;
import com.abach42.designpatterns.structural.bridge.geom.Rectangle3DHelper;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @Test
    @DisplayName("Validate that a Circle rendered in 2D produces a mathematically correct Ellipse2D")
    void testCircleWith2DRenderer() {
        Renderer2D renderer2D = new Renderer2D();
        Circle circle = new Circle(renderer2D, 5.0, new Point2D.Double(10, 10));

        Ellipse2D result = (Ellipse2D) circle.draw();

        assertEquals(5.0, result.getWidth() / 2, 0.01, "Circle radius (width) should match");
        assertEquals(5.0, result.getHeight() / 2, 0.01, "Circle radius (height) should match");
        assertEquals(10 - 5, result.getX(), 0.01, "Top-left X coordinate should be adjusted for radius");
        assertEquals(10 - 5, result.getY(), 0.01, "Top-left Y coordinate should be adjusted for radius");
    }

    @Test
    @DisplayName("Validate that a Rectangle rendered in 3D produces a Rectangle3D object with correct dimensions")
    void testRectangleWith3DRenderer() {
        Renderer3D renderer3D = new Renderer3D();
        Rectangle rectangle = new Rectangle(renderer3D, 10.0, 5.0, new Point2D.Double(0, 0));

        Rectangle3DHelper result = (Rectangle3DHelper) rectangle.draw();

        assertEquals(10.0, result.width, "Rectangle width should match");
        assertEquals(5.0, result.height, "Rectangle height should match");
        assertEquals(0.0, result.topLeft.x, "Top-left X coordinate should match");
        assertEquals(0.0, result.topLeft.y, "Top-left Y coordinate should match");
        assertEquals(0.0, result.topLeft.z, "Z coordinate should default to 0 in 3D rendering");
    }

    @Test
    @DisplayName("Validate that a Circle rendered in 3D produces a Circle3D object with correct radius and center")
    void testCircleWith3DRenderer() {
        Renderer3D renderer3D = new Renderer3D();
        Circle circle = new Circle(renderer3D, 7.5, new Point2D.Double(5, 5));

        Circle3DHelper result = (Circle3DHelper) circle.draw();

        assertEquals(7.5, result.radius, 0.01, "Circle radius should match");
        assertEquals(5.0, result.center.x, 0.01, "Circle center X coordinate should match");
        assertEquals(5.0, result.center.y, 0.01, "Circle center Y coordinate should match");
        assertEquals(0.0, result.center.z, "Z coordinate should default to 0 in 3D rendering");
    }
}
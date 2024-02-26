package com.abach42.designpatterns.unit.creational.factorymethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.creational.factorymethod.CircleCreator;
import com.abach42.designpatterns.creational.factorymethod.Creator;
import com.abach42.designpatterns.creational.factorymethod.Product;
import com.abach42.designpatterns.creational.factorymethod.SquareCreator;

public class FactoryMethodTest {
    @Test
    @DisplayName("Should return circle")
    public void testShouldReturnCircle() {
        Creator creator = new CircleCreator();
        Product product = creator.createProduct(new Point(1, 1));
        Shape shape =  product.getShape();
        
        double actualWidth = shape.getBounds2D().getBounds().getWidth();
        int expectedWidth = 40;
    
        assertInstanceOf(Ellipse2D.class, shape);
        assertEquals(expectedWidth, actualWidth);
    }

    @Test
    @DisplayName("Should return square")
    public void testShouldReturnSquare() {
        Creator creator = new SquareCreator();
        Product product = creator.createProduct(new Point(1, 1));
        Shape shape =  product.getShape();
        
        double actualWidth = shape.getBounds2D().getBounds().getWidth();
        int expectedWidth = 50;
    
        assertInstanceOf(Rectangle.class, shape);
        assertEquals(expectedWidth, actualWidth);
    }
}    


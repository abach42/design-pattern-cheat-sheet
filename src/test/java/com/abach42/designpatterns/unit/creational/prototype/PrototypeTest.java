package com.abach42.designpatterns.unit.creational.prototype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.creational.prototype.CirclePrototype;
import com.abach42.designpatterns.creational.prototype.SquarePrototype;

public class PrototypeTest {

    @Test
    @DisplayName("Circles Should have different identity but same values")
    public void testCircleShouldBeNotSameButEqual() {
        CirclePrototype circlePrototype = new CirclePrototype();
        circlePrototype.x = 1;
        circlePrototype.y = 1;
        circlePrototype.radius = 10;
        circlePrototype.color = "blue";

        CirclePrototype actualCircle = (CirclePrototype) circlePrototype.clone();
        assertNotSame(circlePrototype, actualCircle);
        assertEquals(circlePrototype, actualCircle);
    }

    @Test
    @DisplayName("Squares Should have different identity but same values")
    public void testSquareShouldBeNotSameButEqual() {
        SquarePrototype squarePrototype = new SquarePrototype();
        squarePrototype.x = 1;
        squarePrototype.y = 1;
        squarePrototype.side = 10;
        squarePrototype.color = "yellow";
        
        SquarePrototype actualSquare = (SquarePrototype) squarePrototype.clone();
        assertNotSame(squarePrototype, actualSquare);
        assertEquals(squarePrototype, actualSquare);
    }
}
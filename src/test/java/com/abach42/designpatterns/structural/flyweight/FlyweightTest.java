package com.abach42.designpatterns.structural.flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class FlyweightTest {

    @Test
    void testSharedFlyweights() {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight sharedA1 = factory.getFlyweight("A");
        Flyweight sharedA2 = factory.getFlyweight("A");
        Flyweight sharedB = factory.getFlyweight("B");

        assertSame(sharedA1, sharedA2);
        assertNotSame(sharedA1, sharedB);

        assertEquals("Intrinsic: A, Extrinsic: first", sharedA1.operation("first"));
        assertEquals("Intrinsic: A, Extrinsic: second", sharedA2.operation("second"));
        assertEquals("Intrinsic: B, Extrinsic: context", sharedB.operation("context"));

        assertEquals(2, factory.poolSize());
    }

    @Test
    void testUnsharedFlyweight() {
        Flyweight unshared = new UnsharedConcreteFlyweight("CustomState");

        String result = unshared.operation("external context");
        assertEquals("Unshared: CustomState, Extrinsic: external context", result);
    }
}

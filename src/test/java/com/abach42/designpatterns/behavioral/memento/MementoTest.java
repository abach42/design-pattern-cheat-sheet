package com.abach42.designpatterns.behavioral.memento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MementoTest {

    @Test
    @DisplayName("Test Memento change and restore history")
    public void testMenento() {
        Originator originator = new Originator("foo");

        Caretaker caretaker = new Caretaker();
        originator.changeState("bar");
        caretaker.addMemento(originator.createSnapshot());
        originator.restoreSnapshot(caretaker.getMemento(0));
        String actualFooBar = originator.getState();

        originator.changeState("baz");
        caretaker.addMemento(originator.createSnapshot());
        originator.restoreSnapshot(caretaker.getMemento(1));
        String actualFooBarBaz = originator.getState();

        assertEquals("foo, bar", actualFooBar);
        assertEquals("foo, bar, baz", actualFooBarBaz);
    }
}
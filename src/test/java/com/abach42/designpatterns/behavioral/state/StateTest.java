package com.abach42.designpatterns.behavioral.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StateTest {

    @Test
    void testValidTransitions() {
        Document doc = new Document();
        assertEquals("Draft", doc.getStateName());

        doc.publish();
        assertEquals("Published", doc.getStateName());

        doc.archive();
        assertEquals("Archived", doc.getStateName());
    }

    @Test
    void testInvalidTransitions() {
        Document doc = new Document();

        assertThrows(IllegalStateException.class, doc::archive);
        doc.publish();

        assertThrows(IllegalStateException.class, doc::publish);
        doc.archive();

        assertThrows(IllegalStateException.class, doc::publish);
        assertThrows(IllegalStateException.class, doc::archive);
    }
}

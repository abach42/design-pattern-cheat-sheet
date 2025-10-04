package com.abach42.designpatterns.behavioral.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StateTest {

    @Test
    void testValidTransitions() {
        Document document = new Document();
        assertEquals("Draft", document.getStateName());

        document.publish();
        assertEquals("Published", document.getStateName());

        document.archive();
        assertEquals("Archived", document.getStateName());
    }

    @Test
    void testInvalidTransitions() {
        Document document = new Document();

        assertThrows(IllegalStateException.class, document::archive);
        document.publish();

        assertThrows(IllegalStateException.class, document::publish);
        document.archive();

        assertThrows(IllegalStateException.class, document::publish);
        assertThrows(IllegalStateException.class, document::archive);
    }
}

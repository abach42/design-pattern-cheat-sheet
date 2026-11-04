package com.abach42.designpatterns.behavioral.template;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TemplateMethodTest {

    @Test
    @DisplayName("Should save users sorted by name, because the process hook is overridden")
    void testUserProcessorOverridesHook() {
        UserProcessor processor = new UserProcessor();
        processor.processData();

        assertEquals(List.of(new UserData("Alice"), new UserData("John")), processor.getSavedData());
    }

    @Test
    @DisplayName("Should save products as fetched, because the process hook keeps its default")
    void testProductProcessorUsesDefaultHook() {
        ProductProcessor processor = new ProductProcessor();
        processor.processData();

        assertEquals(
                List.of(new ProductData("Laptop", 999), new ProductData("Phone", 599)),
                processor.getSavedData());
    }
}

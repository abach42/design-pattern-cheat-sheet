package com.abach42.designpatterns.unit.behavioral.template;

import static org.junit.jupiter.api.Assertions.*;

import com.abach42.designpatterns.behavioral.template.*;
import org.junit.jupiter.api.Test;

public class TemplateMethodTest {

    @Test
    public void testUserProcessor() {
        DataProcessor userProcessor = new UserProcessor();
        userProcessor.processData();
    }

    @Test
    public void testProductProcessor() {
        DataProcessor productProcessor = new ProductProcessor();
        productProcessor.processData();
    }

    @Test
    public void testUserData() {
        UserData userData = new UserData("John");
        assertEquals("John", userData.getName());
    }

    @Test
    public void testProductData() {
        ProductData productData = new ProductData("Laptop", 999);
        assertEquals("Laptop", productData.getName());
        assertEquals(999, productData.getPrice(), 0.001);
    }
}

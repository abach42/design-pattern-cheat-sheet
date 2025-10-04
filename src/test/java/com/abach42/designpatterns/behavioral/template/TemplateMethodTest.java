package com.abach42.designpatterns.behavioral.template;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TemplateMethodTest {

    @Test
    public void testUserProcessorFetch() {
        UserProcessor userProcessor = new UserProcessor();
        List<Data> dataList = userProcessor.fetchData();
        assertEquals(2, dataList.size());
        assertInstanceOf(UserData.class, dataList.getFirst());
        assertEquals("John", ((UserData)dataList.getFirst()).getName());
    }

    @Test
    public void testProductProcessorFetch() {
        ProductProcessor productProcessor = new ProductProcessor();
        List<Data> dataList = productProcessor.fetchData();

        assertEquals(2, dataList.size());
        assertInstanceOf(ProductData.class, dataList.getFirst());
        assertEquals("Laptop", ((ProductData) dataList.get(0)).getName());
        assertEquals(999, ((ProductData) dataList.get(0)).getPrice(), 0.001);

        assertInstanceOf(ProductData.class, dataList.get(1));
        assertEquals("Phone", ((ProductData) dataList.get(1)).getName());
        assertEquals(599, ((ProductData) dataList.get(1)).getPrice(), 0.001);
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

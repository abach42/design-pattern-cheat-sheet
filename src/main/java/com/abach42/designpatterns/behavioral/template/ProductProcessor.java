package com.abach42.designpatterns.behavioral.template;

import java.util.List;

public class ProductProcessor extends DataProcessor {
    @Override
    protected List<Data> fetchData() {
        // Code to fetch product data from the database
        // Simulated data retrieval
        return List.of(new ProductData("Laptop", 999), new ProductData("Phone", 599));
    }

    @Override
    protected void process(List<Data> dataList) {
        // Code to process product data
        for (Data data : dataList) {
            // Simulated processing
            // No output
        }
    }

    @Override
    protected void saveData(List<Data> dataList) {
        // Code to save product data back to the database
        // Simulated saving operation
    }
}
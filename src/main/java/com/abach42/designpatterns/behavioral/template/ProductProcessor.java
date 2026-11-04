package com.abach42.designpatterns.behavioral.template;

import java.util.List;

// uses the default of the process hook: products are saved as fetched
public class ProductProcessor extends DataProcessor<ProductData> {

    @Override
    protected List<ProductData> fetchData() {
        // simulates reading products from a database
        return List.of(new ProductData("Laptop", 999), new ProductData("Phone", 599));
    }
}

package com.abach42.designpatterns.behavioral.template;

import java.util.List;

public class UserProcessor extends DataProcessor {
    @Override
    protected List<Data> fetchData() {
        // Code to fetch user data from the database
        // Simulated data retrieval
        return List.of(new UserData("John"), new UserData("Alice"));
    }

    @Override
    protected void process(List<Data> dataList) {
        // Code to process user data
        for (Data data : dataList) {
            // Simulated processing
            // No output
        }
    }

    @Override
    protected void saveData(List<Data> dataList) {
        // Code to save user data back to the database
        // Simulated saving operation
    }
}
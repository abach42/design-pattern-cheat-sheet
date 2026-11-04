package com.abach42.designpatterns.behavioral.template;

import java.util.List;

/**
 * Abstract class: owns the template method and the invariant steps.
 */
public abstract class DataProcessor<T> {

    private List<T> savedData = List.of();

    // template method; final, so subclasses cannot change the order of the steps
    public final void processData() {
        List<T> dataList = fetchData();
        List<T> processed = process(dataList);
        saveData(processed);
    }

    public List<T> getSavedData() {
        return savedData;
    }

    // primitive operation: every subclass must provide it
    protected abstract List<T> fetchData();

    // hook: default keeps the data unchanged, subclasses may override
    protected List<T> process(List<T> dataList) {
        return dataList;
    }

    // invariant step: the same for every subclass
    private void saveData(List<T> dataList) {
        // simulates writing the data back to a database
        savedData = List.copyOf(dataList);
    }
}

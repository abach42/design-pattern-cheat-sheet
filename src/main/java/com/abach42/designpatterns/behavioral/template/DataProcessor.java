package com.abach42.designpatterns.behavioral.template;

import java.util.List;

public abstract class DataProcessor {

    // to simplify usage, you could collect your "actions"
    public void processData() {
        List<Data> dataList = fetchData();
        process(dataList);
        saveData(dataList);
    }

    protected abstract List<Data> fetchData();

    protected abstract void process(List<Data> dataList);

    protected abstract void saveData(List<Data> dataList);
}

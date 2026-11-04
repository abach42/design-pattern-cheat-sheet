package com.abach42.designpatterns.behavioral.template;

import java.util.Comparator;
import java.util.List;

public class UserProcessor extends DataProcessor<UserData> {

    @Override
    protected List<UserData> fetchData() {
        // simulates reading users from a database
        return List.of(new UserData("John"), new UserData("Alice"));
    }

    @Override
    protected List<UserData> process(List<UserData> dataList) {
        return dataList.stream()
                .sorted(Comparator.comparing(UserData::name))
                .toList();
    }
}

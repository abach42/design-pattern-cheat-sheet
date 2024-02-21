package com.abach42.designpatterns.chain.context;

import java.util.Collections;
import java.util.Comparator;

public class SortByAgeHandler extends AbstractHandler {
    public SortByAgeHandler(MemberList data) {
        super(data);
    }

    @Override
    public void handle() {
        if (data.isEmpty()) {
            handleNext();
        }

        Collections.sort(data, Comparator.comparingInt(AbstractHandler.Member::age));

        handleNext();
    }
}

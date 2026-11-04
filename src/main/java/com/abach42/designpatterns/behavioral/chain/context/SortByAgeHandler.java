package com.abach42.designpatterns.behavioral.chain.context;

import java.util.Comparator;

public class SortByAgeHandler extends AbstractHandler {

    public SortByAgeHandler(MemberList data) {
        super(data);
    }

    @Override
    public void handle() {
        if (data.isEmpty()) {
            handleNext();
            return;
        }

        data.sort(Comparator.comparingInt(Member::age));

        handleNext();
    }
}

package com.abach42.designpatterns.behavioral.chain.context;

import java.util.function.Predicate;

public class FilterHandler extends AbstractHandler {
    private int minAge = 40;

    public FilterHandler(MemberList data, int minAge) {
        super(data);
        this.minAge = minAge;
    }

    @Override
    public void handle() {
        if (data.isEmpty()) {
            handleNext();
        }

        Predicate<AbstractHandler.Member> filteredMember = member -> member.age() < minAge;
        data.removeIf(filteredMember);

        handleNext();
    }
}

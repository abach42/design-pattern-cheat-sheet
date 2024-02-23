package com.abach42.designpatterns.behavioral.chain.delegation;

import java.util.function.Predicate;

public class FilterHandler implements Handable {
    private int minAge = 40;

    public FilterHandler(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public Chain.MemberList handle(Chain.MemberList memberList) {
        Predicate<Chain.Member> filteredMember = member -> member.age() < minAge;
        memberList.removeIf(filteredMember);

        return memberList;
    }
}

package com.abach42.designpatterns.behavioral.chain.delegation;

import java.util.Collections;
import java.util.Comparator;

public class SortByAgeHandler implements Handable {
    
    @Override
    public Chain.MemberList handle(Chain.MemberList memberList) {
        if (memberList.isEmpty()) {
            return memberList;
        }
        
        Collections.sort(memberList, Comparator.comparingInt(Chain.Member::age));

        return memberList;
    }
}

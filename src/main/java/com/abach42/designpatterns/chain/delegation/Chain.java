package com.abach42.designpatterns.chain.delegation;

import java.util.ArrayList;
import java.util.List;

public class Chain {
    private List<Handable> handlers = new ArrayList<>();

    public record Member(String name, int age) {}

    public static class MemberList extends ArrayList<Member> {}

    public Chain add(Handable handler) {
        handlers.add(handler);
        return this; 
    }
    
    public MemberList process(MemberList memberList) {
        for (Handable handler : handlers) {
            memberList = handler.handle(memberList);
        }

        return memberList;
    }
}

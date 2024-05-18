package com.abach42.designpatterns.behavioral.chain.context;

import java.util.ArrayList;

public abstract class AbstractHandler {
    protected AbstractHandler next;
    protected MemberList data;

    public record Member(String name, int age) {}

    public static class MemberList extends ArrayList<Member> {}

    protected AbstractHandler(MemberList data) {
        this.data = data;
    }

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public abstract void handle();

    public static AbstractHandler initializeChain(AbstractHandler firstHandler, AbstractHandler... moreHandlers) {
        AbstractHandler handler = firstHandler;
        for (AbstractHandler nextHandler: moreHandlers) {
            handler.setNext(nextHandler);
            handler = nextHandler;
        }

        return firstHandler;
    }

    protected void handleNext() {
        if(null != this.next) {
            this.next.handle();
        }
    }
}

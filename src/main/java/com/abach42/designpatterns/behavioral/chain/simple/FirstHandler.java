package com.abach42.designpatterns.behavioral.chain.simple;

public class FirstHandler extends AbstractHandler {

    @Override
    public void handle() {
        System.out.println("first handler");
        handleNext();
    }
}

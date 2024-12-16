package com.abach42.designpatterns.behavioral.chain.simple;

public class SecondHandler extends AbstractHandler {
    
    @Override
    public void handle() {
        System.out.println("second handler");
        handleNext();
    }
}

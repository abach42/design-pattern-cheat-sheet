package com.abach42.designpatterns.behavioral.mediator;

public class ConcretePolishColleague extends Colleague {

    public ConcretePolishColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        setLastReceivedMessage("Witaj świecie: " + message);
    }
}
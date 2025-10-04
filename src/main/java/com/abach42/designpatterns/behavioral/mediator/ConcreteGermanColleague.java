package com.abach42.designpatterns.behavioral.mediator;

public class ConcreteGermanColleague extends Colleague {

    public ConcreteGermanColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        setLastReceivedMessage("Hallo Welt: " + message);
    }
}
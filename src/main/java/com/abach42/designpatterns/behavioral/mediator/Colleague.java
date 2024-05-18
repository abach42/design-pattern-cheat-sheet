package com.abach42.designpatterns.behavioral.mediator;

public abstract class Colleague {
    protected Mediator mediator;
    protected String lastReceivedMessage;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(String message);

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void setLastReceivedMessage(String lastReceivedMessage) {
        this.lastReceivedMessage = lastReceivedMessage;
    }

    public String getLastReceivedMessage() {
        return lastReceivedMessage;
    }
}

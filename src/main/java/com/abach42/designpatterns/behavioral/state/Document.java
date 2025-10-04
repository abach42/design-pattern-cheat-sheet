package com.abach42.designpatterns.behavioral.state;

public class Document {

    private State state;

    public Document() {
        this.state = new DraftState();
    }

    public void publish() {
        state.publish(this);
    }

    public void archive() {
        state.archive(this);
    }

    public String getStateName() {
        return state.getName();
    }

    void setState(State state) {
        this.state = state;
    }
}

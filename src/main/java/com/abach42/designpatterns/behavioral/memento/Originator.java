package com.abach42.designpatterns.behavioral.memento;

public class Originator {

    private String state;

    public Originator(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void changeState(String state) {
        this.state += ", " + state;
    }

    public Memento createSnapshot() {
        return new Memento(state);
    }

    public void restoreSnapshot(Memento memento) {
        state = memento.state();
    }
}
 
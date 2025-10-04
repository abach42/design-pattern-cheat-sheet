package com.abach42.designpatterns.behavioral.state;

public class DraftState implements State {

    @Override
    public void publish(Document context) {
        context.setState(new PublishedState());
    }

    @Override
    public void archive(Document context) {
        throw new IllegalStateException("DraftState can't be archived directly");
    }

    @Override
    public String getName() {
        return "Draft";
    }
}

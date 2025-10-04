package com.abach42.designpatterns.behavioral.state;

public class ArchiveState implements State {

    @Override
    public void publish(Document context) {
        throw new IllegalStateException("Archived documents cannot be published again.");
    }

    @Override
    public void archive(Document context) {
        throw new IllegalStateException("Document already is archived.");
    }

    @Override
    public String getName() {
        return "Archived";
    }
}

package com.abach42.designpatterns.behavioral.state;

public class PublishedState implements State {

    @Override
    public void publish(Document document) {
        throw new IllegalStateException("Document is already published");
    }

    @Override
    public void archive(Document context) {
        context.setState(new ArchiveState());
    }

    @Override
    public String getName() {
        return "Published";
    }
}

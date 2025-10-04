package com.abach42.designpatterns.behavioral.state;

public interface State {

    void publish(Document context);

    void archive(Document context);

    String getName();
}

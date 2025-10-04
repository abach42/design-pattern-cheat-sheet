package com.abach42.designpatterns.behavioral.visitor;

public interface Element {

    void accept(Visitor visitor);

    boolean isFedUp();

    boolean isHealthChecked();
}
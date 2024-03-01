package com.abach42.designpatterns.behavioral.visitor;

public interface Visitor {
    void visit(LionElement lion);
    void visit(ElephantElement elephant);
}
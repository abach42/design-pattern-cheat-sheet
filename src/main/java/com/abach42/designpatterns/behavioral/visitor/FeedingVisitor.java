package com.abach42.designpatterns.behavioral.visitor;

public class FeedingVisitor implements Visitor {
    @Override
    public void visit(LionElement lion) {
        lion.feedLion();
    }

    @Override
    public void visit(ElephantElement elephant) {
        elephant.feedElephant();
    }
}
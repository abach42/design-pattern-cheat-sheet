package com.abach42.designpatterns.behavioral.visitor;

public class VeterinarianVisitor implements Visitor {

    @Override
    public void visit(LionElement lion) {
        lion.careLion();
    }

    @Override
    public void visit(ElephantElement elephant) {
        elephant.careElephant();
    }
}
package com.abach42.designpatterns.behavioral.visitor;

public class ElephantElement implements Element {

    private boolean isElephantFed = false;
    private boolean isElephantWeightOk = false;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public boolean isFedUp() {
        return isElephantFed;
    }

    public void feedElephant() {
        isElephantFed = true;
    }

    public boolean isHealthChecked() {
        return isElephantWeightOk;
    }

    public void careElephant() {
        isElephantWeightOk = true;
    }
}
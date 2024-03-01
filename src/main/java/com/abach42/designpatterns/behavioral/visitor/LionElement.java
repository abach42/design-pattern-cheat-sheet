package com.abach42.designpatterns.behavioral.visitor;

public class LionElement implements Element {
    private boolean isLionFed = false;
    private boolean isLionTheethHealthy = false;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public boolean isFedUp() {
        return isLionFed;
    }

    public void feedLion() {
        isLionFed = true;
    }

    public boolean isHealthChecked() {
        return isLionTheethHealthy;
    }

    public void careLion() {
        isLionTheethHealthy = true;
    }
}
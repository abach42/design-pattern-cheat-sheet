package com.abach42.designpatterns.structural.bridge;

// "Abstraction"
public abstract class Shape {

    //dependency Renderer makes the bridge
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract Object draw();
}

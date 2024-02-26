package com.abach42.designpatterns.creational.factorymethod;

import java.awt.Point;

public class CircleCreator implements Creator {
    @Override
    public Product createProduct(Point position) {
        return new CircleProduct(position, 20);
    }
}
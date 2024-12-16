package com.abach42.designpatterns.creational.factorymethod;

import java.awt.Point;

public class SquareCreator implements Creator {
    
    @Override
    public Product createProduct(Point position) {
        return new SquareProduct(position, 50);
    }
}
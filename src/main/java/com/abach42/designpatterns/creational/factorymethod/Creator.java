package com.abach42.designpatterns.creational.factorymethod;

import java.awt.Point;

public interface Creator {

    Product createProduct(Point position);
}
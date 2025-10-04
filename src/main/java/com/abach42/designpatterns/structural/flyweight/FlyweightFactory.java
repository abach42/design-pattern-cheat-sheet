package com.abach42.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private final Map<String, Flyweight> pool = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        return pool.computeIfAbsent(key, ConcreteFlyweight::new);
    }

    public int poolSize() {
        return pool.size();
    }
}

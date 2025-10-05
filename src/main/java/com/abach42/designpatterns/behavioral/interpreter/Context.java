package com.abach42.designpatterns.behavioral.interpreter;

import java.util.Map;

public record Context(Map<String, Boolean> variables) {

    public boolean lookup(String name) {
        return variables.getOrDefault(name, false);
    }
}

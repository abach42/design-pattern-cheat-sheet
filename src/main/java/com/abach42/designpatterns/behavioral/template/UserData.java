package com.abach42.designpatterns.behavioral.template;

public class UserData extends Data {

    private final String name;

    public UserData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
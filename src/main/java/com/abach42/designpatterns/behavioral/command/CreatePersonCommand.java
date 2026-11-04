package com.abach42.designpatterns.behavioral.command;

public class CreatePersonCommand implements Command {

    private final PersonReceiver receiver;
    private final String name;
    private final Integer age;

    public CreatePersonCommand(PersonReceiver receiver, String name, Integer age) {
        this.receiver = receiver;
        this.name = name;
        this.age = age;
    }

    @Override
    public void execute() {
        receiver.createPerson(name, age);
    }
}

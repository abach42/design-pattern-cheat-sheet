package com.abach42.designpatterns.behavioral.command;

public class UpdatePersonCommand implements Command {

    private final PersonReceiver receiver;
    private final Person person;

    public UpdatePersonCommand(PersonReceiver receiver, Person person) {
        this.receiver = receiver;
        this.person = person;
    }

    @Override
    public void execute() {
        receiver.updatePerson(person);
    }
}
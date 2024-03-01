package com.abach42.designpatterns.behavioral.command;

public class UpdatePersonCommand implements Command {
    private PersonSetReceiver receiver;
    private Person person;

    public UpdatePersonCommand(PersonSetReceiver receiver, Person person) {
        this.receiver = receiver;
        this.person = person;
    }

    @Override
    public void execute() {
        receiver.deletePersonById(person);
        receiver.addPerson(person);
    }
}
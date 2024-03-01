package com.abach42.designpatterns.behavioral.command;

public class DeletePersonCommand implements Command {
    private PersonSetReceiver receiver;
    private Person person;

    public DeletePersonCommand(PersonSetReceiver receiver, Person person) {
        this.receiver = receiver;
        this.person = person;
    }

    @Override
    public void execute() {
        receiver.deletePersonById(person);
    }
}
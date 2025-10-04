package com.abach42.designpatterns.behavioral.command;

public class DeletePersonCommand implements Command {

    private final PersonSetReceiver receiver;
    private final Person person;

    public DeletePersonCommand(PersonSetReceiver receiver, Person person) {
        this.receiver = receiver;
        this.person = person;
    }

    @Override
    public void execute() {
        receiver.deletePersonById(person);
    }
}
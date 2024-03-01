package com.abach42.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class PersonInvoker {
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command command) {
        this.commands.add(command);
    }

    public void runCommand() {
        this.commands.forEach(Command::execute);
    }

    //todo implement undo of command
    //todo log errors
}

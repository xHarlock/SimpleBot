package com.xharlock.simplebot.core;

import java.util.HashMap;
import java.util.Map;

import com.xharlock.simplebot.commands.HelpCommand;
import com.xharlock.simplebot.commands.PingCommand;

public class CommandManager {
    
    // Map with all the commands and the name associated with each command
    private Map<String, Command> commands;

    public CommandManager() {
        commands = new HashMap<>();

        // Add commands
        addCommand(new PingCommand("ping"));
        addCommand(new HelpCommand("help"));
    }

    public void addCommand(Command command) {
        commands.put(command.getName(), command);
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public boolean isValidName(String name) {
        return commands.containsKey(name);
    }
}
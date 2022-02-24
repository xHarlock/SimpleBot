package com.xharlock.simplebot.commands;

import com.xharlock.simplebot.core.Command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class PingCommand extends Command {

    public PingCommand(String name) {
        super(name);
    }

    @Override
    public void execute(GuildMessageReceivedEvent ev) {
        ev.getChannel().sendMessage("Pong!").queue();
    }
}
package com.xharlock.simplebot.core;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public abstract class Command {
	
	protected String name;
	protected String[] args;

	public Command(String name) {
		this.name = name;
	}

	public abstract void execute(GuildMessageReceivedEvent ev);

	public String getName() {
		return name;
	}
}
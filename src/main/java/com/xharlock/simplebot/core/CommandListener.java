package com.xharlock.simplebot.core;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

import com.xharlock.simplebot.Bot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

// A class that decides if a command has been called and manages the interaction between user and command
public class CommandListener extends ListenerAdapter {

    private CommandManager manager;

    public CommandListener(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent ev){

        // Ignore bots and webhooks
        if (ev.getAuthor().isBot() || ev.isWebhookMessage()) {
            return;
        }

        // Prefix hasn't been used
        if (!ev.getMessage().getContentRaw().startsWith(Bot.getPrefix())) {
            return;
        }

        String[] split = ev.getMessage().getContentRaw().replaceFirst("(?i)" + Pattern.quote(Bot.getPrefix()), "").split("\\s+");
	String invoke = split[0].toLowerCase(Locale.UK);

        // Not a valid name
        if (!manager.isValidName(invoke)) {
            return;
        }

        Command cmd = manager.getCommand(invoke);
        cmd.args = Arrays.copyOfRange(split, 1, split.length);
        cmd.execute(ev);
    }
}

package com.xharlock.simplebot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import com.xharlock.simplebot.core.CommandListener;
import com.xharlock.simplebot.core.CommandManager;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

// The heart of the bot
public class Bot {

    private static JDA jda;
    private static String prefix;

    private static CommandManager manager;

    public static void main(String[] args) throws LoginException, FileNotFoundException {
        prefix = ".";
        
        // Get the token from a file
	Scanner scanner = new Scanner(new File("./token.txt"));
	String token = scanner.next();

        // Initialize a new manager
        manager = new CommandManager();

        // Create a new JDA instance
        jda = JDABuilder.createDefault(token)
            .addEventListeners(new CommandListener(manager))
            .setActivity(Activity.watching(prefix + "help"))
            .build();
    }

    public JDA getJDA() {
        return jda;
    }

    public static String getPrefix() {
        return prefix;
    }
}

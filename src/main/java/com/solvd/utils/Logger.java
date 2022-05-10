package com.solvd.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class Logger extends java.util.logging.Logger {

    public Logger(String name) {
        super(name, null);

        this.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new SimpleFormatter());
        ch.setLevel(Level.INFO);

        addHandler(ch);
    }
}

package me.NickP0is0n;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.File;
import java.io.IOException;

public class JFuck {

    public static void main(String[] args) throws IOException {
        var settings = new Settings();
        var parser = new CmdLineParser(settings);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println("e = " + e.toString());
            parser.printUsage(System.out);
            System.exit(1);
        }
        System.out.println("jFuck v1.2");
        System.out.println("Java open-source esoteric language interpreter");
        System.out.println("By Mykola Chaikovskyi (github.com/NickP0is0n)");
        System.out.println(" ");
        System.out.println("Program started");
        System.out.println(" ");

        Interpreter interpreter = null;
        if (settings.isOOK()) {
            interpreter = new OokInterpreter(new File(settings.getFileName()));
        }
        else if (settings.isHQ9()) {
            interpreter = new HQ9Interpreter(new File(settings.getFileName()));
        }
        else {
            interpreter = new BrainfuckInterpreter(new File(settings.getFileName()));
        }
        interpreter.execute();

        System.out.println(" ");
        System.out.println("Program finished");
    }
}

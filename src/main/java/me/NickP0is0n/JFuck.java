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
        System.out.println("jFuck v1.1");
        System.out.println("Java open-source Brainfuck/Ook! interpreter");
        System.out.println("By NickP0is0n (nickp0is0n.me)");
        System.out.println(" ");
        System.out.println("Program started");
        System.out.println(" ");
        if (settings.isOOK())
        {
            OokInterpreter sourceCode = new OokInterpreter(new File(settings.getFileName()));
            sourceCode.execute();
        }
        else
        {
            BrainfuckInterpreter sourceCode = new BrainfuckInterpreter(new File(settings.getFileName()));
            sourceCode.execute();
        }
        System.out.println(" ");
        System.out.println("Program finished");
    }
}

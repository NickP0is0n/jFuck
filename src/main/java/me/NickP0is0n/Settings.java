package me.NickP0is0n;

import org.kohsuke.args4j.Option;

import java.io.Serializable;

public class Settings implements Serializable {
    @Option(name = "--filename", usage = "Set file name", required = true)
    private String fileName;

    @Option(name = "--ook", usage = "Set OOK as programming language", required = false)
    private boolean isOOK = false;

    boolean isOOK() {
        return isOOK;
    }

    String getFileName() {
        return fileName;
    }
}

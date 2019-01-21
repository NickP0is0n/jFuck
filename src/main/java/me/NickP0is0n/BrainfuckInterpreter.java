package me.NickP0is0n;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class BrainfuckInterpreter {
    File sourceFile;
    String code;

    BrainfuckInterpreter(File sourceFile) throws IOException {
        this.sourceFile = sourceFile;
        this.code = readFile();
    }

    BrainfuckInterpreter() {
    }

    @SuppressWarnings("Duplicates")
    void execute() throws IOException {
        int j = 0;
        byte[] cpu = new byte[30000];
        for (byte i: cpu) {
            i = 0;
        }
        char[] acc = parseCode(code);
        int brc = 0;
        var in = new Scanner(System.in);
        for (int i = 0; i < acc.length; i++) {
            if (acc[i] == '>') j++;
            if (acc[i] == '<') j--;
            if (acc[i] == '+') cpu[j]++;
            if (acc[i] == '-') cpu[j]--;
            if (acc[i] == '.') System.out.print((char) cpu[j]);
            if (acc[i] == ',') cpu[j] = (byte)in.next().charAt(0);
            if (acc[i] == '[') {
                if (cpu[j] == 0) {
                    ++brc;
                    while (brc != 0) {
                        ++i;
                        if (acc[i] == '[')
                            ++brc;
                        if (acc[i] == ']')
                            --brc;
                    }
                }
                else continue;
            } else if (acc[i] == ']') {
                if (cpu[j] == 0)
                    continue;
                else {
                    if (acc[i] == ']')
                        brc++;
                    while (brc != 0) {
                        --i;
                        if (acc[i] == '[')
                            brc--;
                        if (acc[i] == ']')
                            brc++;
                    }
                    --i;
                }
            }
        }
    }

    String readFile() throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(sourceFile.getPath()));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    private char[] parseCode(String code)
    { return code.toCharArray(); }
}

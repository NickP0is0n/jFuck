package me.NickP0is0n;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OokInterpreter extends BrainfuckInterpreter {

    OokInterpreter(File sourceFile) throws IOException {
        super.sourceFile = sourceFile;
        super.code = readFile();
    }

    @Override
    @SuppressWarnings("Duplicates")
    void execute() throws IOException {
        int j = 0;
        byte[] cpu = new byte[30000];
        for (byte i: cpu) { i = 0; }
        String[] acc = parseCode(code);
        int brc = 0;
        var in = new Scanner(System.in);
        for (int i = 0; i < acc.length; i++) {
            if (acc[i].equals("Ook. Ook?")) j++;
            if (acc[i].equals("Ook? Ook.")) j--;
            if (acc[i].equals("Ook. Ook.")) cpu[j]++;
            if (acc[i].equals("Ook! Ook!")) cpu[j]--;
            if (acc[i].equals("Ook! Ook.")) System.out.print((char) cpu[j]);
            if (acc[i].equals("Ook. Ook!")) cpu[j] = (byte)in.next().charAt(0);
            if (acc[i].equals("Ook! Ook?")) {
                if (cpu[j] == 0) {
                    ++brc;
                    while (brc != 0) {
                        ++i;
                        if (acc[i].equals("Ook! Ook?"))
                            ++brc;
                        if (acc[i].equals("Ook? Ook!"))
                            --brc;
                    }
                }
            } else if (acc[i].equals("Ook? Ook!")) {
                if (cpu[j] != 0) {
                    if (acc[i].equals("Ook? Ook!"))
                        brc++;
                    while (brc != 0) {
                        --i;
                        if (acc[i] .equals("Ook! Ook?"))
                            brc--;
                        if (acc[i].equals("Ook? Ook!"))
                            brc++;
                    }
                    --i;
                }
            }
        }
    }

    private String[] parseCode(String code) throws FileNotFoundException {
        int position = 0;
        var in = new Scanner(sourceFile);
        ArrayList<String> codeParts = new ArrayList<>();
        ArrayList<String> instructions = new ArrayList<>();
        while (in.hasNext()) instructions.add(in.next());
        while (position < instructions.size())
        {
            codeParts.add(instructions.get(position) + " " + instructions.get(position+1));
            position += 2;
        }
        String[] codeArray = new String[codeParts.size()];
        codeParts.toArray(codeArray);
        return codeArray;
    }

}

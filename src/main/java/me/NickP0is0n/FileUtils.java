package me.NickP0is0n;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    public static String readFile(File sourceFile) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(sourceFile.getPath()));
        return new String(encoded, StandardCharsets.UTF_8);
    }
}

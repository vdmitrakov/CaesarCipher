package com.vdmitrakov.javasytax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


 class FileService {
    static String readFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

     static void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Path.of(filePath), content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
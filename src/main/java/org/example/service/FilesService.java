package org.example.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FilesService {
    public List<File> findTxtFiles(String pathToFolder) {
        File folder = new File(pathToFolder);

        if (!folder.isDirectory())
            throw new IllegalArgumentException("Provided path: " + pathToFolder + " must lead to the folder!");

        return Optional.ofNullable(folder.listFiles())
                .map(Arrays::stream)
                .map(file -> file
                        .filter(f -> !f.isDirectory() && f.getName().endsWith(".txt"))
                        .toList()
                )
                .orElse(Collections.emptyList());
    }


    public int countWords(File file, String word) {
        int sum = 0;
        try (Stream<String> lines = Files.lines(file.toPath())) {
            sum += lines.flatMap(l -> Arrays.stream(l.split(" ")))
                    .filter(word::equals)
                    .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }
}

package org.example.service;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class CounterService {
    private final FilesService filesService;

    public int count(String pathToFolder, String word) {
        return filesService.findTxtFiles(pathToFolder).stream()
                .sorted(Comparator.comparing(File::lastModified).reversed())
                .map(s -> filesService.countWords(s, word))
                .filter(count -> count != 0)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("not found files with word: :" + word + " in it"));

    }

}

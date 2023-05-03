package org.example;

import org.example.service.CounterService;
import org.example.service.FilesService;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));

        FilesService filesService = new FilesService();
        CounterService counterService = new CounterService(filesService);

        if (args != null && args.length == 2)
            System.out.println(counterService.count(args[0], args[1]));
        else throw new IllegalArgumentException("path and word mast be in args...");

    }
}

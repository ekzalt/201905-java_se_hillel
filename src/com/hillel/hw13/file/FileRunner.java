package com.hillel.hw13.file;

import com.hillel.hw10.FileService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileRunner {
    public void run() {
        String inputFilePath = "input_cars.txt";
        String outputFilePath = "output_cars.txt";
        FileService fs = new FileService();

        String text = fs.readFile(inputFilePath);

        List<String> lines = Arrays.asList(text.split(System.lineSeparator()));
        Collections.reverse(lines);

        fs.writeFile(outputFilePath, String.join(System.lineSeparator(), lines));
    }
}

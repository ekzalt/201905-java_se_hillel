package com.hillel.hw10;

import java.io.*;
import java.util.Arrays;

public class FileService {
    String WINDOWS_LINE_SEPARATOR = "\r\n";
    String CHARSET = "UTF-8";

    public void writeFile(String path, String text) {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path))) {
            bufferedOutputStream.write(text.getBytes());
            bufferedOutputStream.write(WINDOWS_LINE_SEPARATOR.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String path) {
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(path))) {
            byte[] bytes = input.readAllBytes();
            String string = new String(bytes, CHARSET);
            System.out.println(string);

            return string;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String[] split(String text, String regex) {
        String[] lines = text.split(regex);
        System.out.println(Arrays.toString(lines));

        return lines;
    }
}
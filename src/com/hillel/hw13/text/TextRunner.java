package com.hillel.hw13.text;

import java.util.*;

public class TextRunner {
    private String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public ArrayList<String> splitTextToWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        String[] parts = text.split("[;:,.-]+");

        for (String part : parts) {
            words.addAll(Arrays.asList(part.trim().split(" ")));
        }

        return words;
    }

    public Map<String, Integer> countRepetitions(ArrayList<String> words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }

    public void printResults(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        for (Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void run() {
        printResults(countRepetitions(splitTextToWords(text)));
    }
}

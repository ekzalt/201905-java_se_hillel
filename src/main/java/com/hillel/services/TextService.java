package com.hillel.services;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService {
    public static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public void run() {
        List<String> words = splitTextToWords(TEXT);

        System.out.println("\ntask 1\n");
        printMap(countRepetitions(words));

        System.out.println("\ntask 2\n");
        printList(copyAndReplaceAll(words, 1, 'i'));

        System.out.println("\ntask 3\n");
        printSet(collectFirstLastLetterMatch(words));

        System.out.println("\ntask 4\n");
        System.out.println(countPunctuationMarks(TEXT));
    }

    public List<String> splitTextToWords(String text) {
        return new ArrayList<>(Arrays.asList(text.split("\\W+")));
    }

    public Map<String, Integer> countRepetitions(List<String> words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }

    public String copyAndReplace(String target, int index, char letter) {
        if (index >= target.length()) {
            return String.valueOf(target);
        }

        StringBuilder sb = new StringBuilder(target);
        sb.setCharAt(index, letter);

        return sb.toString();
    }

    public List<String> copyAndReplaceAll(List<String> words, int index, char letter) {
        List<String> copy = new ArrayList<>();

        words.forEach((String word) -> copy.add(copyAndReplace(word, index, letter)));

        return copy;
    }

    public Set<String> collectFirstLastLetterMatch(List<String> words) {
        Set<String> set = new HashSet<>();

        words.forEach((String word) -> {
            if (word.charAt(0) == word.charAt(word.length() - 1)) {
                set.add(word);
            }
        });

        return set;
    }

    public int countPunctuationMarks(String text) {
        Pattern pattern = Pattern.compile("[.,:;!?-]");
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public void printSet(Set set) {
        System.out.println(Arrays.toString(set.toArray()));
    }

    public void printList(List list) {
        System.out.println(Arrays.toString(list.toArray()));
    }

    public void printMap(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        for (Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

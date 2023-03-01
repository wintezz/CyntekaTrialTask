package com.petrov.service;

import java.util.HashSet;
import java.util.Set;

public class TrimService {

    public static Set<String> trimSet(Set<String> set) {

        Set<String> trimStringSet = new HashSet<>();

        for (String str : set) {
            trimStringSet.add(TrimService.trimString(str));
        }
        return trimStringSet;
    }

    private static String trimString(String string) {

        double length = string.length();
        double trimLength = string.length();

        if (length >= 10) {
            trimLength = 8;
        }
        if (length >= 8 && length < 10) {
            trimLength = 7;
        }
        if (length >= 6 && length < 8) {
            trimLength = 5;
        }

        return string.substring(0, (int) trimLength);
    }
}

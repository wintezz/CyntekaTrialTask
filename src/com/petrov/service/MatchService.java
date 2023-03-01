package com.petrov.service;

import java.util.*;
import java.util.stream.Collectors;

public class MatchService {

    public static Map<Integer, Integer> matchesSearch(List<Set<String>> firstPartSetsList, List<Set<String>> secondPartSetsList) {

        Map<Integer, Integer> matchesMap = new HashMap<>();
        List<Set<String>> tmpSetsList = firstPartSetsList.stream().map(HashSet::new).collect(Collectors.toList());

        if (firstPartSetsList.size() == secondPartSetsList.size() && secondPartSetsList.size() == 1) {
            matchesMap.put(0, 0);
            return matchesMap;
        }

        for (int x = 0; x < firstPartSetsList.size(); x++) {
            int numberOfMatches = 0;
            for (int y = 0; y < secondPartSetsList.size(); y++) {
                firstPartSetsList.get(x).retainAll(secondPartSetsList.get(y));
                if (firstPartSetsList.get(x).isEmpty()) {
                    firstPartSetsList.get(x).addAll(tmpSetsList.get(x));
                } else if (numberOfMatches < firstPartSetsList.get(x).size()) {
                    numberOfMatches = firstPartSetsList.get(x).size();
                    matchesMap.put(x, y);
                    firstPartSetsList.get(x).addAll(tmpSetsList.get(x));
                }
            }
        }
        return matchesMap;
    }
}

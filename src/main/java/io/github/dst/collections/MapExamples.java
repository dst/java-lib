package io.github.dst.collections;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {

    public void merge() {
        Map<Character, Integer> charCounter = new HashMap<>();

        charCounter.merge('a', 1, Integer::sum);
        assert charCounter.get('a') == 1;

        charCounter.merge('a', 1, Integer::sum);
        assert charCounter.get('a') == 2;
    }

    public void removeIf() {
        Map<String, Integer> wordsCounter = new HashMap<>(Map.of(
                "darek", 4,
                "dariusz", 2,
                "dario", 9
        ));
        assert wordsCounter.size() == 3;

        wordsCounter.entrySet()
                .removeIf(entry -> entry.getKey().endsWith("rio"));
        assert wordsCounter.size() == 2;
    }
}

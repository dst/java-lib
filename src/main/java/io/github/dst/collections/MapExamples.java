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
}

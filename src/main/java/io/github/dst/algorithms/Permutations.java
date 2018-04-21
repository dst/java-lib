package io.github.dst.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

class Permutations<T> {

    List<List<T>> findAll(List<T> elements) {
        if (elements.isEmpty()) {
            return asList(emptyList());
        } else {
            return elements.stream().flatMap(elt -> {
                List<T> restOfElements = new ArrayList<>(elements);
                restOfElements.remove(elt);
                return findAll(restOfElements).stream()
                        .map(permutedRestOfElements -> Stream.concat(Stream.of(elt), permutedRestOfElements.stream())
                                .collect(toList()));
            }).collect(toList());
        }
    }
}

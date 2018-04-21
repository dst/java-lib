package io.github.dst.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

/**
 * It is very inefficient and can only work in reasonable time for size <= 10.
 *
 * @author Dariusz Stefanski
 * @since 21 Apr 2018
 */
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

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
class PermutationFinder<T> {

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

    List<List<T>> findAllWithBacktracking(List<T> elements) {
        boolean[] used = new boolean[elements.size()];
        List<T> currentPermutation = new ArrayList<>();
        List<List<T>> permutations = new ArrayList<>();
        backtrack(permutations, currentPermutation, elements, used);
        return permutations;
    }

    private void backtrack(List<List<T>> permutations, List<T> currentPermutation,
                           List<T> elements, boolean[] used) {
        if (currentPermutation.size() == elements.size()) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            currentPermutation.add(elements.get(i));
            backtrack(permutations, currentPermutation, elements, used);
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }
}

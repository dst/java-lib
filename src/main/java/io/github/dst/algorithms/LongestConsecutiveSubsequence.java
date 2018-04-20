package io.github.dst.algorithms;

import java.util.HashSet;
import java.util.List;

/**
 * @author Dariusz Stefanski
 * @since 20 Apr 2018
 */
class LongestConsecutiveSubsequence {

    int find(List<Integer> numbers) {
        int longest = 0;
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        for (Integer n : numbers) {
            if (!numbers.contains(n - 1)) {
                int next = n + 1;
                while (numbersSet.contains(next)) {
                    next++;
                }
                int length = next - n;
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}

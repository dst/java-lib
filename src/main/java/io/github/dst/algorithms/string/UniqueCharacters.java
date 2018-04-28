package io.github.dst.algorithms.string;

import java.util.BitSet;

/**
 * @author Dariusz Stefanski
 * @since 28 Apr 2018
 */
class UniqueCharacters {

    static boolean check(String word) {
        BitSet chars = new BitSet();
        for (char c: word.toCharArray()) {
            if (chars.get(c)) {
                return false;
            }
            chars.set(c);
        }
        return true;
    }
}

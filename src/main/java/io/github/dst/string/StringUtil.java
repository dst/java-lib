package io.github.dst.string;

import java.util.Arrays;

public class StringUtil {

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static String removeSuffix(String word, String suffix) {
        if (!word.endsWith(suffix)) {
            throw new IllegalArgumentException("Suffix doesn't exist");
        }
        return word.substring(0, word.length() - suffix.length());
    }

    public static String removePrefix(String word, String prefix) {
        if (!word.startsWith(prefix)) {
            throw new IllegalArgumentException("Prefix doesn't exist");
        }
        return word.substring(prefix.length());
    }
}

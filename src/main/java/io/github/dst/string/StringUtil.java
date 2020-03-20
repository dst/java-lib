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
}

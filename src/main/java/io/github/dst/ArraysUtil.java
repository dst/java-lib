package io.github.dst;

import java.util.Arrays;

public class ArraysUtil {

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}

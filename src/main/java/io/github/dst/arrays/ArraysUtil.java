package io.github.dst.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysUtil {

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static int[][] sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        return intervals;
    }
}

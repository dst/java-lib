package io.github.dst.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysUtil {

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    // [1, 2, 3, 4]
    // [0, 1, 3, 6, 10]
    public static int[] prefixSums(int[] nums) {
        int[] prefixSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        return prefixSums;
    }

    // [1, 2, 3, 4]
    // [0, 4, 7, 9, 10]
    public static int[] suffixSums(int[] nums) {
        int n = nums.length;
        int[] suffixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            suffixSums[i + 1] = suffixSums[i] + nums[n - 1 - i];
        }
        return suffixSums;
    }

    public static int[] toArray(List<Integer> nums) {
        return nums.stream().mapToInt(n -> n).toArray();
    }

    public static int[][] createMatrix(int rowCount, int columnCount, int value) {
        int[][] matrix = new int[rowCount][columnCount];
        for (int[] row : matrix) {
            Arrays.fill(row, value);
        }
        return matrix;
    }

    public static <T> List<List<T>> matrixToListOfLists(T[][] matrix) {
        return Arrays.stream(matrix)
                .map(Arrays::asList)
                .collect(Collectors.toList());
    }

    public static int[][] sortByFirstRowElements(int[][] matrix) {
        Arrays.sort(matrix, Comparator.comparing(row -> row[0]));
        return matrix;
    }
}

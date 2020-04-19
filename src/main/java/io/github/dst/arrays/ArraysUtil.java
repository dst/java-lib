package io.github.dst.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysUtil {

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
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

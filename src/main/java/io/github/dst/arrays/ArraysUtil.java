package io.github.dst.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysUtil {

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static int[][] createMatrix(int rowCount, int columnCount, int value) {
        int[][] matrix = new int[rowCount][columnCount];
        for (int[] row: matrix) {
            Arrays.fill(row, value);
        }
        return  matrix;
    }

    public static int[][] sortByFirstRowElements(int[][] matrix) {
        Arrays.sort(matrix, Comparator.comparing(row -> row[0]));
        return matrix;
    }
}

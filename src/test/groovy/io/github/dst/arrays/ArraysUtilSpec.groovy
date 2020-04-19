package io.github.dst.arrays

import spock.lang.Specification
import spock.lang.Unroll

class ArraysUtilSpec extends Specification {

    def "Truncating array"() {
        when:
            int[] array = [1, 2, 3, 4]
            int[] truncatedArray = new int[2]
            System.arraycopy(array, 0, truncatedArray, 0, truncatedArray.length)
        then:
            truncatedArray == [1, 2]
    }

    def "Comparing arrays"() {
        expect:
            Arrays.equals([1, 2, 3] as int[], [1, 2, 3] as int[])
    }

    @Unroll
    def "sum of '#array' is '#sum'"() {
        expect:
            ArraysUtil.sum(array as int[]) == sum
        where:
            array   || sum
            []      || 0
            [0]     || 0
            [-1]    || -1
            [1]     || 1
            [1, -1] || 0
    }

    @Unroll
    def "matrix with #rows rows and #columns columns filled with #value is #matrix"() {
        expect:
            ArraysUtil.createMatrix(rows, columns, value) == matrix
        where:
            rows | columns | value || matrix
            1    | 1       | 0     || [[0]]
            1    | 1       | 1     || [[1]]
            1    | 1       | -2    || [[-2]]
            2    | 3       | 4     || [[4, 4, 4], [4, 4, 4]]
    }

    def "matrix to list of lists"() {
        given:
            String[][] matrix = [
                    ["name", "age"],
                    ["Natalia", "86"],
                    ["Kazimierz", "45"]
            ]
        expect:
            ArraysUtil.matrixToListOfLists(matrix) == [
                    ["name", "age"],
                    ["Natalia", "86"],
                    ["Kazimierz", "45"]
            ]
    }

    @Unroll
    def "sorted by first row elements of '#matrix' is '#sorted'"() {
        expect:
            ArraysUtil.sortByFirstRowElements(matrix as int[][]) == sorted
        where:
            matrix                   || sorted
            []                       || []
            [[1, 2]]                 || [[1, 2]]
            [[2, 4], [1, 3], [6, 9]] || [[1, 3], [2, 4], [6, 9]]
    }
}

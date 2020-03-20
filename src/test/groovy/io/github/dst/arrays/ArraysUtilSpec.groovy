package io.github.dst.arrays

import spock.lang.Specification
import spock.lang.Unroll

class ArraysUtilSpec extends Specification {

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
    def "sorted intervals of '#intervals' is '#sorted'"() {
        expect:
            ArraysUtil.sortIntervals(intervals as int[][]) == sorted
        where:
            intervals                || sorted
            []                       || []
            [[1, 2]]                 || [[1, 2]]
            [[2, 4], [1, 3], [6, 9]] || [[1, 3], [2, 4], [6, 9]]
    }
}

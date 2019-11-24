package io.github.dst

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
}

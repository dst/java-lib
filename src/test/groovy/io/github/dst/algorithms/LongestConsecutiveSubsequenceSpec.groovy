package io.github.dst.algorithms

import spock.lang.Specification
import spock.lang.Unroll

class LongestConsecutiveSubsequenceSpec extends Specification {

    @Unroll
    def "Longest consecutive sub-sequence of #numbers is #longest"() {
        expect:
            new LongestConsecutiveSubsequence().find(numbers) == longest
        where:
            numbers                                      || longest
            []                                           || 0
            [1]                                          || 1
            [1, 2]                                       || 2
            [2, 1]                                       || 2
            [1, 3]                                       || 1
            [1, 9, 3, 10, 4, 20, 2]                      || 4 // 1, 3, 4, 2
            [36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42] || 5 // 36, 35, 33, 34, 32
    }
}

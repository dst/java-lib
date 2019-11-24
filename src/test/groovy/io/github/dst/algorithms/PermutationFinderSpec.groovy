package io.github.dst.algorithms

import spock.lang.Specification
import spock.lang.Unroll

class PermutationFinderSpec extends Specification {

    private def permutationFinder = new PermutationFinder<Integer>()

    @Unroll
    def "recursion + stream, permutations of #list = #permutations"() {
        expect:
            permutationFinder.findAll(list) == permutations
        where:
            list      || permutations
            []        || [[]]
            [1]       || [[1]]
            [1, 2]    || [[1, 2], [2, 1]]
            [1, 1]    || [[1, 1], [1, 1]]
            [5, 1, 9] || [[5, 1, 9], [5, 9, 1], [1, 5, 9], [1, 9, 5], [9, 5, 1], [9, 1, 5]]
    }

    @Unroll
    def "backtracking algorithm, permutations of #list = #permutations"() {
        expect:
            permutationFinder.findAllWithBacktracking(list) == permutations
        where:
            list      || permutations
            []        || [[]]
            [1]       || [[1]]
            [1, 2]    || [[1, 2], [2, 1]]
            [1, 1]    || [[1, 1], [1, 1]]
            [5, 1, 9] || [[5, 1, 9], [5, 9, 1], [1, 5, 9], [1, 9, 5], [9, 5, 1], [9, 1, 5]]
    }
}

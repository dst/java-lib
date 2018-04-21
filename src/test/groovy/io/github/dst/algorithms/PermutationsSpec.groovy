package io.github.dst.algorithms

import spock.lang.Specification
import spock.lang.Unroll

class PermutationsSpec extends Specification {

    @Unroll
    def "Permutations of #list should be #permutations"() {
        expect:
            new Permutations<Integer>().findAll(list) == permutations
        where:
            list      || permutations
            []        || [[]]
            [1]       || [[1]]
            [1, 2]    || [[1, 2], [2, 1]]
            [1, 1]    || [[1, 1], [1, 1]]
            [5, 1, 9] || [[5, 1, 9], [5, 9, 1], [1, 5, 9], [1, 9, 5], [9, 5, 1], [9, 1, 5]]
    }
}

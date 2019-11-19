package io.github.dst.binary

import spock.lang.Specification

class BinarySearchSpec extends Specification {

    def "searching existing element"() {
        expect:
            Arrays.binarySearch([1, 3, 9, 14, 15].toArray(), 9) == 2
    }

    def "searching existing element which is duplicated"() {
        expect:
            Arrays.binarySearch([1, 3, 9, 9, 14, 15].toArray(), 9) == 2
    }

    def "searching not existing element"() {
        expect:
            Arrays.binarySearch([1, 3, 9, 9, 14, 15].toArray(), 10) == -4 - 1
    }

    def "searching not existing element which is lower than min"() {
        expect:
            Arrays.binarySearch([1, 3, 9, 9, 14, 15].toArray(), 0) == 0 - 1
    }

    def "searching not existing element which is higher than max"() {
        expect:
            Arrays.binarySearch([1, 3, 9, 9, 14, 15].toArray(), 16) == -6 - 1
    }
}

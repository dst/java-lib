package io.github.dst.list

import spock.lang.Specification
import spock.lang.Unroll

class SinglyLinkedListSpec extends Specification {

    @Unroll
    def "size of '#list' is '#size'"() {
        expect:
            new SinglyLinkedList<Integer>(list).size() == size
        where:
            list      || size
            []        || 0
            [1]       || 1
            [1, 2]    || 2
            [1, 2, 3] || 3
    }

    @Unroll
    def "'#elements' with removed #n-th element is '#expectedList'"() {
        given:
            def list = new SinglyLinkedList<Integer>(elements)
        expect:
            list.removeNth(n).toList() == expectedList
        where:
            elements | n || expectedList
            []       | 0 || []
            []       | 1 || []
            [1]      | 0 || []
            [1]      | 1 || [1]
            [1, 2]   | 0 || [2]
            [1, 2]   | 1 || [1]
            [1, 2]   | 2 || [1, 2]

    }
}
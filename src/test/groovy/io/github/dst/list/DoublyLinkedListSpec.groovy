package io.github.dst.list

import spock.lang.Specification

class DoublyLinkedListSpec extends Specification {

    def "addFirst empty list"() {
        given:
            def list = new DoublyLinkedList<Integer>()
        expect:
            list.isEmpty()
            list.first() == null
            list.last() == null
    }

    def "addFirst singleton"() {
        given:
            def list = new DoublyLinkedList<Integer>()
        when:
            list.addFirst(2)
        then:
            !list.isEmpty()
            list.first() == 2
            list.last() == 2
    }

    def "addFirst 2 elements"() {
        given:
            def list = new DoublyLinkedList<Integer>()
        when:
            list.addFirst(2)
            list.addFirst(1)
        then:
            !list.isEmpty()
            list.first() == 1
            list.last() == 2
    }

    def "addLast and addFirst can create the same list"() {
        given:
            def list1 = new DoublyLinkedList<Integer>()
            list1.addLast(1)
            list1.addLast(2)

            def list2 = new DoublyLinkedList<Integer>()
            list2.addFirst(2)
            list2.addFirst(1)

        expect:
            list1 == list2
    }

    def "removing first from empty list doesn't explode"() {
        given:
            def list = new DoublyLinkedList<>()
        when:
            list.removeFirst()
        then:
            list.isEmpty()
    }

    def "removing last from empty list doesn't explode"() {
        given:
            def list = new DoublyLinkedList<>()
        when:
            list.removeLast()
        then:
            list.isEmpty()
    }
}

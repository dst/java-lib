package io.github.dst.graph

import spock.lang.Specification

/**
 * @author Dariusz Stefanski
 * @since 04 Feb 2017
 */
class ConnectionsFinderSpec extends Specification {

    def 'node should be its own connection'() {
        given:
            ConnectionsFinder connectionsFinder = new ConnectionsFinder()
            Node node = new Node(1)
        expect:
            connectionsFinder.find(node) == [node] as Set
    }

    def 'should find all connections in list node1->node2->node3'() {
        given:
            ConnectionsFinder connectionsFinder = new ConnectionsFinder()
            Node node1 = new Node(1)
            Node node2 = new Node(2)
            Node node3 = new Node(3)
            node1.addNeighbour(node2)
            node2.addNeighbour(node3)
        expect:
            connectionsFinder.find(node1) == [node1, node2, node3] as Set
            connectionsFinder.find(node2) == [node2, node3] as Set
            connectionsFinder.find(node3) == [node3] as Set
    }

    def 'should find all connections in tree'() {
        given:
            //     node1
            //   \/_   _\|
            // node2   node3
            ConnectionsFinder connectionsFinder = new ConnectionsFinder()
            Node node1 = new Node(1)
            Node node2 = new Node(2)
            Node node3 = new Node(3)
            node1.addNeighbour(node2)
            node1.addNeighbour(node3)
        expect:
            connectionsFinder.find(node1) == [node1, node2, node3] as Set
            connectionsFinder.find(node2) == [node2] as Set
            connectionsFinder.find(node3) == [node3] as Set
    }
}

package io.github.dst.graph

import spock.lang.Specification

/**
 * @author Dariusz Stefanski
 * @since 04 Feb 2017
 */
class MostValuedConnectionsFinderSpec extends Specification {

    def 'should find most valued connections in tree'() {
        given:
            //     node(1, 1)
            //    /         \
            // node(2, 2)   node(3, 3)
            MostValuedConnectionsFinder finder = new MostValuedConnectionsFinder()
            Node node1 = new Node(1, 1)
            Node node2 = new Node(2, 2)
            Node node3 = new Node(3, 3)
            node1.addNeighbour(node2)
            node1.addNeighbour(node3)
        expect:
            finder.find(node1, 0) == [] as Set
            finder.find(node1, 1) == [node3] as Set
            finder.find(node1, 2) == [node2, node3] as Set
            finder.find(node1, 3) == [node2, node3] as Set
    }
}

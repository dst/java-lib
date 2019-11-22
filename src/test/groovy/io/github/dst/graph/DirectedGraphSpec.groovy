package io.github.dst.graph

import spock.lang.Specification

import io.github.dst.graph.DirectedGraph.Node

class DirectedGraphSpec extends Specification {

    def 'single node has no cycle'() {
        given:
            DirectedGraph graph = new DirectedGraph()
            graph.addNode(1)
        expect:
            !graph.hasCycle()
    }

    def 'list node1->node2->node3 has no cycle'() {
        given:
            DirectedGraph graph = new DirectedGraph()
            Node node1 = graph.addNode(1)
            Node node2 = graph.addNode(2)
            Node node3 = graph.addNode(3)
            graph.addEdge(node1, node2)
            graph.addEdge(node2, node3)
        expect:
            !graph.hasCycle()
    }

    def 'tree has no cycle'() {
        given:
            //     node1
            //   \/_   _\|
            // node2   node3
            DirectedGraph graph = new DirectedGraph()
            Node node1 = graph.addNode(1)
            Node node2 = graph.addNode(2)
            Node node3 = graph.addNode(3)
            graph.addEdge(node1, node2)
            graph.addEdge(node1, node3)
        expect:
            !graph.hasCycle()
    }

    def 'forest node1->node2 node3->node4 has no cycle'() {
        given:
            DirectedGraph graph = new DirectedGraph()
            Node node1 = graph.addNode(1)
            Node node2 = graph.addNode(2)
            Node node3 = graph.addNode(3)
            Node node4 = graph.addNode(4)
            graph.addEdge(node1, node2)
            graph.addEdge(node3, node4)
        expect:
            !graph.hasCycle()
    }

    def 'graph node1<->node2 has cycle'() {
        given:
            DirectedGraph graph = new DirectedGraph()
            Node node1 = graph.addNode(1)
            Node node2 = graph.addNode(2)
            graph.addEdge(node1, node2)
            graph.addEdge(node2, node1)
        expect:
            graph.hasCycle()
    }
}

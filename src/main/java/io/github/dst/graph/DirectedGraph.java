package io.github.dst.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.github.dst.graph.DirectedGraph.NodeState.BEING_VISITED;
import static io.github.dst.graph.DirectedGraph.NodeState.NOT_VISITED;
import static io.github.dst.graph.DirectedGraph.NodeState.VISITED;

public class DirectedGraph {

    enum NodeState {
        NOT_VISITED,
        BEING_VISITED,
        VISITED
    }

    class Node {
        private int key;
        private NodeState state = NOT_VISITED;
        private List<Node> neighbours = new ArrayList<>();

        Node(int key) {
            this.key = key;
        }


        void addNeighbour(Node node) {
            neighbours.add(node);
        }

        List<Node> getNeighbours() {
            return Collections.unmodifiableList(neighbours);
        }

        @Override
        public String toString() {
            return String.format("Node(%s)", key);
        }
    }

    private List<Node> nodes = new ArrayList<>();

    public Node addNode(int key) {
        Node node = new Node(key);
        nodes.add(node);
        return node;
    }

    public void addEdge(Node from, Node to) {
        from.addNeighbour(to);
    }

    public boolean hasCycle() {
        return nodes.stream().anyMatch(node -> node.state == NOT_VISITED && hasCycle(node));
    }

    private boolean hasCycle(Node node) {
        if (node.state == VISITED) {
            return false;
        }
        if (node.state == BEING_VISITED) {
            return true;
        }
        node.state = BEING_VISITED;
        boolean hasCycle = node.getNeighbours().stream().anyMatch(this::hasCycle);
        node.state = VISITED;
        return hasCycle;
    }
}

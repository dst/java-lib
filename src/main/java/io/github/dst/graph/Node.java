package io.github.dst.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Dariusz Stefanski
 * @since 04 Feb 2017
 */
class Node {

    static final Comparator<Node> VALUE_COMPARATOR = (a, b) ->
            Double.valueOf(b.getValue()).compareTo(a.getValue());

    private final int id;
    private double value;
    private List<Node> neighbours;

    Node(int id) {
        this.id = id;
        this.neighbours = new ArrayList<>();
    }

    Node(int id, double value) {
        this.id = id;
        this.value = value;
        this.neighbours = new ArrayList<>();
    }

    void addNeighbour(Node node) {
        neighbours.add(node);
    }

    int getId() {
        return id;
    }

    double getValue() {
        return value;
    }

    List<Node> getNeighbours() {
        return Collections.unmodifiableList(neighbours);
    }

    @Override
    public String toString() {
        return String.format("Node(%s)", id);
    }
}

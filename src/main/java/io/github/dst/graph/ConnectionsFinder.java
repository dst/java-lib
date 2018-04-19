package io.github.dst.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dariusz Stefanski
 * @since 04 Feb 2017
 */
class ConnectionsFinder {

    private Set<Integer> visitedNodeIds;
    private Set<Node> connectedNodes;

    Set<Node> find(Node node) {
        visitedNodeIds = new HashSet<>();
        connectedNodes = new HashSet<>();
       return doFind(node);
    }

    private Set<Node> doFind(Node node) {
        int movieId = node.getId();
        if (!visitedNodeIds.contains(movieId)) {
            visitedNodeIds.add(movieId);
            connectedNodes.add(node);
            node.getNeighbours().forEach(this::doFind);
        }
        return connectedNodes;
    }
}

package io.github.dst.graph;

import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

/**
 * @author Dariusz Stefanski
 * @since 04 Feb 2017
 */
class MostValuedConnectionsFinder {

    /**
     * Finds n most valued connections of node (excluding itself).
     */
    public Set<Node> find(Node node, int n) {
        Set<Node> connections = new ConnectionsFinder().find(node);
        return connections.stream()
                .sorted(Node.MOST_VALUED_COMPARATOR)
                .filter(not(node::equals))
                .limit(n)
                .collect(toSet());
    }

    private <T> Predicate<T> not(Predicate<T> predicate) {
        return predicate.negate();
    }
}

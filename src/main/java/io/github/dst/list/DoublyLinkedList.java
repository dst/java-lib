package io.github.dst.list;

import java.util.Objects;

/**
 * With sentinels / guards / dummy nodes.
 * X <-> 5 <-> 7 <-> 2 <-> X
 *     <-prev- 7 -next->
 */
public class DoublyLinkedList<E> {

    class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node() {}
        Node(E element) {
            this.element = element;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        } else {
            return head.next.element;
        }
    }

    public E last() {
        if (isEmpty()) {
            return null;
        } else {
            return tail.prev.element;
        }
    }

    public void addFirst(E element) {
        addBetween(element, head, head.next);
    }

    public void addLast(E element) {
        addBetween(element, tail.prev, tail);
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        remove(head.next);
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        remove(tail.prev);
    }

    public void remove(Node<E> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addBetween(E element, Node<E> prev, Node<E> next) {
        Node node = new Node(element);
        node.prev = prev;
        node.next = next;
        prev.next = node;
        next.prev = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        // TODO: It should be ?, but doesn't work
        DoublyLinkedList<E> that = (DoublyLinkedList<E>) o;
        Node<E> thisNode = this.head.next;
        Node<?> thatNode = that.head.next;
        while (thisNode.next != null && thatNode.next != null) {
            if (!thisNode.element.equals(thatNode.element)) {
                return false;
            }
            thisNode = thisNode.next;
            thatNode = thatNode.next;
        }
        return thisNode.next == null && thatNode.next == null; // The same length
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }
}

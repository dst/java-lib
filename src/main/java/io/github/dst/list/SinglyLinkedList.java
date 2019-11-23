package io.github.dst.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * With sentinels / guards / dummy nodes.
 * X -> 5 -> 7 -> 2 <-> X
 */
public class SinglyLinkedList<E> {

    class Node<E> {
        E element;
        Node<E> next;

        Node() {}
        Node(E element) {
            this.element = element;
        }
    }

    private Node<E> head;

    public SinglyLinkedList() {
        head = new Node<>();
    }

    public SinglyLinkedList(List<E> elements) {
        head = new Node<>();
        Collections.reverse(elements);
        elements.stream().forEach(this::addFirst);
    }

    private void addFirst(E element) {
        Node node = new Node<>(element);
        node.next = head.next;
        head.next = node;
    }

    public SinglyLinkedList<E> removeNth(int n) {
        if (n >= size()) {
            return this;
        }
        Node prev = head;
        int index = 0;
        while (index != n) {
            prev = prev.next;
            index++;
        }
        prev.next = prev.next.next;
        return this;
    }

    public int size() {
        int size = 0;
        Node node = head.next;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public List toList() {
        List<E> list = new LinkedList<>();
        Node<E> node = head.next;
        while (node != null) {
            list.add(node.element);
            node = node.next;
        }
        return list;
    }
}

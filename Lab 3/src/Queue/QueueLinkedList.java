package Queue;

import md.kubuntu.Node;

public class QueueLinkedList implements IQueue {

    private Node current;
    private Node first;

    public QueueLinkedList() {
    }

    @Override
    public void add(Object element) {
        Node node = new Node();
        node.variable = (Integer) element;

        if (first == null) {
            first = node;
        } else {
            node.previous = current;
            current.next = node;
        }
        current = node;

    }

    @Override
    public void peek() {
        System.out.println(first.variable);
    }

    @Override
    public void poll() {
        System.out.println(first.variable);
        first = (Node) first.next;
    }
}

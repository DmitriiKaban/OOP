package Queue;

import md.kubuntu.Node;

public class QueueLinkedList<T> implements IQueue<T> {

    private Node current;
    private Node first;

    public QueueLinkedList() {
    }

    @Override
    public void add(Object element) {
        Node node = new Node();
        node.variable = element;

        if (first == null) {
            first = node;
        } else {
            node.previous = current;
            current.next = node;
        }
        current = node;

    }

    @Override
    public T peek() {
        return (T) first.variable;
    }

    @Override
    public T poll() {
        T element = (T) first.variable;
        first = (Node) first.next;
        return element;
    }
}

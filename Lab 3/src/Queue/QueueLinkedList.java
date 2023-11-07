package Queue;

import md.kubuntu.Node;

public class QueueLinkedList<T> implements IQueue<T> {

    private Node current;
    private Node first;
    private int capacity;
    private int currentNumber = 0;

    public QueueLinkedList() {
        capacity = 5;
    }

    public QueueLinkedList(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void add(Object element) {
        if (!isFull()) {
            Node node = new Node();
            node.variable = element;

            if (first == null) {
                first = node;
            } else {
                node.previous = current;
                current.next = node;
            }
            current = node;
            currentNumber++;
        } else {
            System.out.println("Queue is full!");
        }
    }

    @Override
    public T peek() {
        return (T) first.variable;
    }

    @Override
    public T poll() {
        if (!isEmpty()) {
            T element = (T) first.variable;
            first = (Node) first.next;
            currentNumber--;
            return element;
        } else {
            System.out.println("Queue is empty!");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return currentNumber == 0;
    }

    @Override
    public boolean isFull() {
        return currentNumber == capacity;
    }
}

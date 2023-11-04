package Stack;

import md.kubuntu.Node;

public class StackLinkedList<T> implements IStack<T>{

    private Node current;

    public StackLinkedList() {
        this.current = new Node();
        this.current.next = null;
    }

    @Override
    public void push(Object element) {
        Node node = new Node();
        node.variable = element;
        node.previous = current;
        current.next = node;

        current = node;
    }

    @Override
    public T pop() {
        T t = (T) current.variable;
        current = (Node) current.previous;
        return t;
    }

    @Override
    public T peek() {
        return (T) current.variable;
    }
}

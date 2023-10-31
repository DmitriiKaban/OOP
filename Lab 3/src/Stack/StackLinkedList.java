package Stack;

import md.kubuntu.Node;

public class StackLinkedList implements IStack{

    private Node current;

    public StackLinkedList() {
        this.current = new Node();
        this.current.next = null;
    }

    @Override
    public void push(Object element) {
        Node node = new Node();
        node.variable = (Integer) element;
        node.previous = current;
        current.next = node;

        current = node;
    }

    @Override
    public void pop() {
        System.out.println(current.variable);
        current = (Node) current.previous;
    }

    @Override
    public void peek() {
        System.out.println(current.variable);
    }
}

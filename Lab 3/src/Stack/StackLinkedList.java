package Stack;

import md.kubuntu.Node;

public class StackLinkedList<T> implements IStack<T>{

    private Node current;
    private int capacity;
    private int currentNumber = 0;

    public StackLinkedList() {
        capacity = 5;
        this.current = new Node();
        this.current.next = null;
    }

    public StackLinkedList(int capacity) {
        this.capacity = capacity;
        this.current = new Node();
        this.current.next = null;
    }

    @Override
    public void push(Object element) {
        if (!isFull()) {
            Node node = new Node();
            node.variable = element;
            node.previous = current;
            current.next = node;

            current = node;
            currentNumber++;
        } else {
            System.out.println("Stack is full!");
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T t = (T) current.variable;
            current = (Node) current.previous;
            currentNumber--;
            return t;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return (T) current.variable;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    @Override
    public boolean isFull() {
        return capacity == currentNumber;
    }

    @Override
    public boolean isEmpty() {
        return currentNumber == 0;
    }
}

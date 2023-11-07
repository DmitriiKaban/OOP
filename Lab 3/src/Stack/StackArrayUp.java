package Stack;

public class StackArrayUp<T> implements IStack<T> {
    private final T[] elements;
    private Integer top = -1;
    private final Integer capacity;

    public StackArrayUp(Integer capacity) {
        this.capacity = capacity;
        elements = (T[])new Object[capacity];
    }

    public StackArrayUp() {
        this.capacity = 5;
        elements = (T[])new Object[capacity];
    }

    @Override
    public void push(Object element) {
        if (top + 1 < capacity) {
            elements[++top] = (T) element;
        } else {
            System.out.println("Stack is full!");
        }
    }

    @Override
    public T pop() {
        if (top >= 0) {
            return elements[top--];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    @Override
    public T peek() {
        return elements[top];
    }

    @Override
    public boolean isFull() {
        return !(top + 1 < capacity);
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }
}

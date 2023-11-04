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
        if (top < capacity) {
            elements[++top] = (T) element;
        }
    }

    @Override
    public T pop() {
        return top >= 0 ? elements[top--] : null;
    }

    @Override
    public T peek() {
        return elements[top];
    }
}

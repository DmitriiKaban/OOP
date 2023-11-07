package Stack;

import java.util.Objects;

public class StackArrayDown<T> implements IStack<T>{
    private final T[] elements;
    private Integer free;
    private final Integer capacity;

    public StackArrayDown(Integer capacity) {
        this.capacity = capacity;
        elements = (T[])new Object[capacity];
        free = capacity;

        System.out.println(free.hashCode());
        System.out.println(capacity.hashCode());
    }

    public StackArrayDown() {
        this.capacity = 5;
        elements = (T[])new Object[capacity];
        free = capacity;
    }

    @Override
    public void push(Object element) {
        if (!isFull()) {
            elements[--free] = (T) element;
        } else {
            System.out.println("Stack is full");
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            return elements[free++];
        }

        return null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return elements[free];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    @Override
    public boolean isFull() {
        return free <= 0;
    }

    @Override
    public boolean isEmpty() {
        return Objects.equals(free, capacity);
    }
}

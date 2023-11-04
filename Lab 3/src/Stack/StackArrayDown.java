package Stack;

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
        if (free > 0) {
            elements[--free] = (T) element;
        }
    }

    @Override
    public T pop() {
        if (free < capacity) {
            return elements[free++];
        }

        return null;
    }

    @Override
    public T peek() {
        return elements[free];
    }
}

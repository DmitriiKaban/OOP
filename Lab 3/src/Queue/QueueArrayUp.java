package Queue;

public class QueueArrayUp<T> implements IQueue<T>{

    private final T[] elements;
    private Integer top = -1;
    private final Integer capacity;
    private Integer head = 0;

    public QueueArrayUp(Integer capacity) {
        this.capacity = capacity;
        elements = (T[])new Object[capacity];
    }

    public QueueArrayUp() {
        this.capacity = 5;
        elements = (T[])new Object[capacity];
    }

    @Override
    public void add(Object element) {
        top++;
        if (top.equals(capacity))
            top = 0;
        elements[top] = (T) element;
    }

    @Override
    public T peek() {
        return elements[head];
    }

    @Override
    public T poll() {
        T element = elements[head];
        head++;
        if (head.equals(capacity))
            head = 0;

        return element;
    }
}

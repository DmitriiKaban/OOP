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
    public void add(T element) {
        top++;
        if (top.equals(capacity)) {
            System.out.println("Queue is full");
            top--;
            return;
        }
        elements[top] = element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return elements[head];
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T element = elements[head];
        head++;
        if (isEmpty()) {
            // reset head and top
            head = 0;
            top = -1;
        }
        return element;
    }

    public boolean isEmpty() {
        return head > top;
    }

    @Override
    public boolean isFull() {
        return top.equals(capacity);
    }
}

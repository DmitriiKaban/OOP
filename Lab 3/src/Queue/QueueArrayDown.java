package Queue;

public class QueueArrayDown<T> implements IQueue<T>{

    private final T[] elements;
    private Integer free;
    private final Integer capacity;
    private Integer head;

    public QueueArrayDown(Integer capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        free = capacity - 1;
        head = capacity - 1;
    }

    public QueueArrayDown() {
        this.capacity = 5;
        elements = (T[])new Object[capacity];
        free = capacity - 1;
        head = capacity - 1;
    }

    @Override
    public void add(T element) {
        elements[free--] = element;

        if (free == 0) {
            System.out.println("Queue is full!");
        }
    }

    @Override
    public T peek() {
        return elements[head];
    }

    @Override
    public T poll() {
        if (head == 0) {
            System.out.println("Queue is empty!");
            return null;
        }
        return elements[head--];
    }
}

package Queue;

public class QueueArrayDown<T> implements IQueue<T>{

    private final T[] elements;
    private Integer free;
    private final Integer capacity;
    private Integer head;

    public QueueArrayDown(Integer capacity) {
        this.capacity = capacity;
        elements = new T[capacity];
        free = capacity - 1;
        head = capacity - 1;
    }

    public QueueArrayDown() {
        this.capacity = 5;
        elements = new T[capacity];
        free = capacity - 1;
        head = capacity - 1;
    }

    @Override
    public void add(T element) {
        elements[free--] = element;

        if (free == 0)
            free = capacity - 1;
    }

    @Override
    public T peek() {
        return elements[head];
    }

    @Override
    public T poll() {
        T returnT = elements[head--];
        if (head == 0)
            head = capacity - 1;
        return returnT;
    }
}

package Queue;

public class QueueArrayDown<T> implements IQueue<T> {

    private final T[] elements;
    private int free;
    private final int capacity;
    private int head;

    public QueueArrayDown(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        free = 0;
        head = 0;
    }

    public QueueArrayDown() {
        this.capacity = 5;
        elements = (T[]) new Object[capacity];
        free = 0;
        head = 0;
    }

    @Override
    public void add(T element) {
        if (free == capacity) {
            System.out.println("Queue is full!");
            return;
        }
        elements[free++] = element;
    }

    @Override
    public T peek() {
        if (head == free) {
            System.out.println("Queue is empty!");
            return null;
        }
        return elements[head];
    }

    @Override
    public T poll() {
        if (head == free) {
            System.out.println("Queue is empty!");
            return null;
        }
        T element = elements[head++];
        if (head == free) {
            // Reset the pointers when the queue becomes empty
            head = 0;
            free = 0;
        }
        return element;
    }
}

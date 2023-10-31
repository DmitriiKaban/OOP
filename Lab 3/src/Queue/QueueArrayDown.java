package Queue;

public class QueueArrayDown implements IQueue{

    private final Integer[] elements;
    private Integer free;
    private final Integer capacity;
    private Integer head;

    public QueueArrayDown(Integer capacity) {
        this.capacity = capacity;
        elements = new Integer[capacity];
        free = capacity - 1;
        head = capacity - 1;
    }

    public QueueArrayDown() {
        this.capacity = 5;
        elements = new Integer[capacity];
        free = capacity - 1;
        head = capacity - 1;
    }

    @Override
    public void add(Object element) {
        elements[free--] = (Integer) element;

        if (free == 0)
            free = capacity - 1;
    }

    @Override
    public void peek() {
        System.out.println(elements[head]);
    }

    @Override
    public void poll() {
        System.out.println(elements[head--]);
        if (head == 0)
            head = capacity - 1;
    }
}

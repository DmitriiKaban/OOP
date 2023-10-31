package Queue;

public class QueueArrayUp implements IQueue{

    private final Integer[] elements;
    private Integer top = -1;
    private final Integer capacity;
    private Integer head = 0;

    public QueueArrayUp(Integer capacity) {
        this.capacity = capacity;
        elements = new Integer[capacity];
    }

    public QueueArrayUp() {
        this.capacity = 5;
        elements = new Integer[capacity];
    }

    @Override
    public void add(Object element) {
        top++;
        if (top.equals(capacity))
            top = 0;
        elements[top] = (Integer) element;
    }

    @Override
    public void peek() {
        System.out.println(elements[head]);
    }

    @Override
    public void poll() {
        System.out.println(elements[head]);
        head++;
        if (head.equals(capacity))
            head = 0;
    }
}

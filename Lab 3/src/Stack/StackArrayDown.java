package Stack;

public class StackArrayDown implements IStack{
    private final Integer[] elements;
    private Integer free;
    private final Integer capacity;

    public StackArrayDown(Integer capacity) {
        this.capacity = capacity;
        elements = new Integer[capacity];
        free = capacity;

        System.out.println(free.hashCode());
        System.out.println(capacity.hashCode());
    }

    public StackArrayDown() {
        this.capacity = 5;
        elements = new Integer[capacity];
        free = capacity;
    }

    @Override
    public void push(Object element) {
        if (free > 0) {
            elements[--free] = (Integer) element;
        }
    }

    @Override
    public void pop() {
        if (free < capacity) {
            System.out.println(elements[free++]);
        }
    }

    @Override
    public void peek() {
        System.out.println(elements[free]);
    }
}

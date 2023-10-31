package Stack;

public class StackArrayUp implements IStack {
    private final Integer[] elements;
    private Integer top = -1;
    private final Integer capacity;

    public StackArrayUp(Integer capacity) {
        this.capacity = capacity;
        elements = new Integer[capacity];
    }

    public StackArrayUp() {
        this.capacity = 5;
        elements = new Integer[capacity];
    }

    @Override
    public void push(Object element) {
        if (top < capacity) {
            elements[++top] = (Integer) element;
        }
    }

    @Override
    public void pop() {
        if (top >= 0) {
            System.out.println(elements[top--]);
        }
    }

    @Override
    public void peek() {
        System.out.println(elements[top]);
    }
}

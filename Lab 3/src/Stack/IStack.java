package Stack;

public interface IStack<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isFull();
    boolean isEmpty();
}

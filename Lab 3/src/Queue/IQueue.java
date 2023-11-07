package Queue;

public interface IQueue<T> {
    void add(T element);
    T peek();
    T poll();
    boolean isEmpty();
    boolean isFull();
}

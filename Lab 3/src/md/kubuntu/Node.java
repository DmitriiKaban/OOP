package md.kubuntu;

public class Node<T> {
    public Object previous;
    public Object next;
    public T variable;

    public Node() {
        this.previous = null;
        this.next = null;
        this.variable = null;
    }
}

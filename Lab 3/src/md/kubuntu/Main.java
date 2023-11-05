package md.kubuntu;

import Stack.IStack;
import Stack.StackLinkedList;

public class Main {

    static public void main(String[] args) {

        IStack<Integer> stack = new StackLinkedList<>();
        stack.push(1);
        System.out.println(stack.peek());
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.peek());
        stack.push(5);
        System.out.println(stack.peek());
        stack.push(6);
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.peek());
    }
}

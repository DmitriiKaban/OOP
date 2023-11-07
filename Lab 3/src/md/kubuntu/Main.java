package md.kubuntu;

import Queue.IQueue;
import Queue.QueueArrayDown;
import Queue.QueueArrayUp;
import Queue.QueueLinkedList;
import Stack.IStack;
import Stack.StackArrayDown;
import Stack.StackArrayUp;
import Stack.StackLinkedList;

public class Main {

    static public void main(String[] args) {

//        IStack<Integer> stack = new StackLinkedList<>();
//        stack.push(1);
//        System.out.println(stack.peek());
//        stack.push(2);
//        System.out.println(stack.peek());
//        stack.push(3);
//        System.out.println(stack.peek());
//        stack.push(4);
//        System.out.println(stack.peek());
//        stack.push(5);
//        System.out.println(stack.peek());
//        stack.push(6);
//        System.out.println(stack.peek());
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        stack.push(3);
//        System.out.println(stack.peek());
//        stack.push(4);
//        System.out.println(stack.peek());

        IQueue<Integer> queue = new QueueLinkedList<>();
        queue.add(1);
        System.out.println(queue.peek());
        queue.add(2);
        System.out.println(queue.peek());
        queue.add(3);
        System.out.println(queue.peek());
        queue.add(4);
        System.out.println(queue.peek());
        queue.add(5);
        System.out.println(queue.peek());
        queue.add(6);
        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(3);
        System.out.println(queue.peek());
        queue.add(4);
        System.out.println(queue.peek());
    }
}

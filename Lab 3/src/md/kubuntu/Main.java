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

        IQueue<Integer> queue = new QueueLinkedList();
        testQueue(queue);
        queue = new QueueArrayDown();
        testQueue(queue);
        queue = new QueueArrayUp();
        testQueue(queue);


        IStack<Integer> stack = new StackArrayDown();
        testStack(stack);
        stack = new StackArrayUp();
        testStack(stack);
        stack = new StackLinkedList();
        testStack(stack);

    }

    private static void testStack(IStack<Integer> stack) {

        stack.push(1);
        stack.push(2);
        stack.peek();
        stack.pop();
        stack.push(3);
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        System.out.println("==============");
    }

    private static void testQueue(IQueue<Integer> queue) {
        queue.add(1);
        queue.add(2);
        queue.peek();
        queue.poll();
        queue.add(3);
        queue.peek();
        queue.poll();
        queue.peek();
        queue.poll();
        System.out.println("==============");
    }
}

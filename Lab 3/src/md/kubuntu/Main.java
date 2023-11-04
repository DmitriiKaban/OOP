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

        IQueue<Integer> queue = new QueueLinkedList<>();
        testQueue(queue);
        queue = new QueueArrayDown<>();
        testQueue(queue);
        queue = new QueueArrayUp<>();
        testQueue(queue);


        System.out.println("QUEUE");
        IQueue<String> queueStr = new QueueLinkedList<>();
        queueStr.add("1");
        queueStr.add("2");
        System.out.println(queueStr.peek());
        System.out.println(queueStr.poll());
        queueStr.add("3");
        System.out.println(queueStr.peek());
        System.out.println(queueStr.poll());
        System.out.println(queueStr.peek());
        System.out.println(queueStr.poll());
        System.out.println("==============");


        IStack<Integer> stack = new StackArrayDown<>();
        testStack(stack);
        stack = new StackArrayUp<>();
        testStack(stack);
        stack = new StackLinkedList<>();
        testStack(stack);

        System.out.println("STACK");
        IStack<String> stackStr = new StackLinkedList<>();
        stackStr.push("1");
        stackStr.push("2");
        System.out.println(stackStr.peek());
        System.out.println(stackStr.pop());
        stackStr.push("3");
        System.out.println(stackStr.peek());
        System.out.println(stackStr.pop());
        System.out.println(stackStr.peek());
        System.out.println(stackStr.pop());

    }

    private static void testStack(IStack<Integer> stack) {

        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println("==============");
    }

    private static void testQueue(IQueue<Integer> queue) {
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println("==============");
    }
}

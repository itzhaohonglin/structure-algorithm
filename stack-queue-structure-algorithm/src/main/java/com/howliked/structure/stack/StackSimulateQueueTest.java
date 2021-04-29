package com.howliked.structure.stack;

public class StackSimulateQueueTest<T> {
    public static void main(String[] args) {
        StackSimulateQueue stackSimulateQueue = new StackSimulateQueue();
        stackSimulateQueue.push(1);
        stackSimulateQueue.push(2);
        System.out.println(stackSimulateQueue.peek());
        System.out.println(stackSimulateQueue.peek());
        System.out.println(stackSimulateQueue.pop());
        stackSimulateQueue.push(3);
        stackSimulateQueue.push(4);
        System.out.println(stackSimulateQueue.pop());
        System.out.println(stackSimulateQueue.pop());
        System.out.println(stackSimulateQueue.pop());
        System.out.println(stackSimulateQueue.empty());
    }
}

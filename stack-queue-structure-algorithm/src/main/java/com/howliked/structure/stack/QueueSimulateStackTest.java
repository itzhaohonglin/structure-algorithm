package com.howliked.structure.stack;

/**
 * 225. 用队列实现栈
 * 栈的特性:后进先出
 */
public class QueueSimulateStackTest {
    public static void main(String[] args) {
        QueueSimulateStack<Integer> queue = new QueueSimulateStack<>();
        queue.push(1);
        queue.push(2);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

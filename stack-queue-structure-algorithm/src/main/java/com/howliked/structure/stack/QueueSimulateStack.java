package com.howliked.structure.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 栈的特性:后进先出
 */
public class QueueSimulateStack<T> {
    private Queue<T> queue; //入队列的数据
    private Queue<T> help;  //辅助操作

    public QueueSimulateStack() {
        this.queue = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    public T push(T t) {
        queue.offer(t);
        return t;
    }

    public T pop() {
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        T poll = queue.poll();
        Queue<T> temp = queue;
        queue = help;
        help = temp;
        return poll;
    }

    public T peek() {
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        T peek = queue.peek();
        Queue<T> temp = queue;
        queue = help;
        help = temp;
        return peek;
    }
}

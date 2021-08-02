package com.howliked.structure.stack;

/**
 * 数组模拟栈
 */
public class ArraySimulateStackTest {
    public static void main(String[] args) {
        ArraySimulateQueue<Integer> arrayQueue = new ArraySimulateQueue<>(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        arrayQueue.push(4);
        arrayQueue.push(5);
        arrayQueue.push(6);
        System.out.println(arrayQueue.pop());
    }
}

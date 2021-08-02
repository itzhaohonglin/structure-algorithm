package com.howliked.structure.stack;

/**
 * 获取最小的栈
 * getMin()获取栈中最小值
 */
public class GetMinStackTest<T> {
    public static void main(String[] args) {
        GetMinStack stack = new GetMinStack();
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}

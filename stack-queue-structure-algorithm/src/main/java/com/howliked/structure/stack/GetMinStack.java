package com.howliked.structure.stack;

import java.util.Stack;

/**
 * 获取最小的栈
 * getMin()获取栈中最小值
 */
public class GetMinStack {
    private Stack<Integer> inStack;
    private Stack<Integer> minStack;

    public GetMinStack() {
        this.inStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    /**
     * minStack:只存放最小值
     *
     * @param val
     * @return
     */
    public Integer push(Integer val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (val <= this.getMin()) {
            minStack.push(val);
        } else {
            Integer minVal = minStack.peek();
            minStack.push(minVal);
        }
        inStack.push(val);
        return val;
    }

    public Integer pop() {
        minStack.pop();
        return inStack.pop();
    }

    public Integer getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return minStack.peek();
    }
}

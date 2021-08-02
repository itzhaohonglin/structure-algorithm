package com.howliked.structure.stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 队列的特性:先进先出
 * 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * <p>
 * 示例:
 * <p>
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 在push数据的时候，只要数据放进输入栈就好，「但在pop的时候，操作就复杂一些，输出栈如果为空，就把进栈数据全部导入进来（注意是全部导入）」，再从出栈弹出数据，如果输出栈不为空，则直接从出栈弹出数据就可以了。
 * <p>
 * 最后如何判断队列为空呢？「如果进栈和出栈都为空的话，说明模拟的队列为空了。」
 */
public class StackSimulateQueue<T> {
    private Stack<T> stIn;  //入栈
    private Stack<T> stOut; //出栈

    public StackSimulateQueue() {
        stIn = new Stack<>();
        stOut = new Stack<>();
    }

    public T push(T t) {
        stIn.push(t);
        return t;
    }

    public T pop() {
        //1.出栈为空,则一次发生 将入栈中的数据全部压入到出栈中
        if (stOut.empty()) {
            while (!stIn.empty()) {
                stOut.push(stIn.pop());
            }
        }
        //取出栈数据
        T pop = stOut.pop();
        return pop;
    }

    public T peek() {
        T pop = this.pop();
        T push = stOut.push(pop);
        return push;
    }

    public boolean empty() {
        return stIn.empty() && stOut.empty();
    }

}

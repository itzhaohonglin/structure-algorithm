package com.howliked.structure.stack;

/**
 * 数组模拟栈
 */
public class ArraySimulateQueue<T> {
    private Object[] array;
    private int pushi;
    private int polli;
    private int size;
    private int limit;

    public ArraySimulateQueue(int limit) {
        pushi = 0;
        polli = 0;
        array = new Object[limit];
        size = 0;
        this.limit = limit;
    }

    public T push(T t) {
        if (size == limit) {
            throw new RuntimeException("队列满了，不能再加了");
        }
        size++;
        array[pushi] = t;
        pushi = nextIndex(pushi);
        return t;
    }

    public T pop() {
        if (size == 0) {
            return null;
        }
        T ans = (T) array[polli];
        size--;
        polli = nextIndex(polli);
        return ans;
    }

    // 如果现在的下标是i，返回下一个位置
    private int nextIndex(int i) {
        return i < limit - 1 ? i + 1 : 0;
    }

}

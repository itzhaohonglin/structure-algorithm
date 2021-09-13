package com.howliked.structure.algorithm.sorting.heap;

/**
 * 返回堆中最大的值,并且移除这个元素
 * 堆的计算法则:
 * 父节点: (index-1) / 2
 * 左节点:index * 2+1;
 * 右节点:index * 2+ 2
 */
public class Code02_MaxHeap {
    private int[] heap;
    private int limit;
    private int size;

    public Code02_MaxHeap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    public void push(int value) {
        if (size >= limit) {
            throw new RuntimeException("heap is full !");
        }
        heap[size++] = value;
        heapInsert(heap, size++);
    }

    /**
     * (index-1) /2 :当前index 的父类节点
     * heapInsert:当前节点与父类节点比较,如果大,则进行交换
     *
     * @param heap
     * @param index
     */
    private void heapInsert(int[] heap, int index) {
        //当前index比它的父类大,则交换
        while (heap[index] > heap[(index - 1) >> 1]) {
            swap(heap, heap[index], heap[(index - 1) / 2]);
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆化:
     *
     * @param arr
     * @param index
     * @param size
     */
    private void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;   //左子树
        while (left < size) {
            //-- 找出最大的索引
            //1. left + 1 = 右子树. -->判断当前是否有右子树
            //2. 如果右子树比左子树大,则为右子树,否则是左子树
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //找出最大值
            largest = arr[largest] > arr[index] ? largest : index;
            // index和较大孩子，要互换
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    /**
     * 返回堆中最大值
     *
     * @return
     */
    public int pop() {
        int ans = heap[0];
        swap(heap, 0, --size);
        heapify(heap, 0, size);
        return ans;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}

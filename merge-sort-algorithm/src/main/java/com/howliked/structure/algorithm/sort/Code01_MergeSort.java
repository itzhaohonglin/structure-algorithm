package com.howliked.structure.algorithm.sort;

/**
 * 归并排序
 */
public class Code01_MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 1, 2};
        process(array, 0, array.length - 1);
        printArray(array);
    }


    private static void process(int[] arr, int L, int R) {
        if (L == R) return;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        //p1指针
        int p1 = L;
        //p2指针
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }

        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }

    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}

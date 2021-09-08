package com.howliked.algorithm.sorting.quick;

public class QuickSort01_ParationAndQuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3, 6, 5, 7, 0};
        quickSortV1(array);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    private static void quickSortV1(int[] array) {
        process1(array, 0, array.length - 1);
    }

    private static void process1(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(array, L, R);
        process1(array, L, M-1);
        process1(array, M + 1, R);
    }

    private static int partition(int[] array, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (array[index] <= array[R]) {
                swap(array, index, ++lessEqual);
            }
            index++;
        }
        swap(array, ++lessEqual, R);
        return lessEqual;
    }

    private static void swap(int[] array, int L, int R) {
        int tmp = array[L];
        array[L] = array[R];
        array[R] = tmp;
    }
}

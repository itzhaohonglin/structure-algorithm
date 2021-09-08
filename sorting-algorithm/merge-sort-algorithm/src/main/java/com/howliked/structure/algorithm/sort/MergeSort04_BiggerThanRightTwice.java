package com.howliked.structure.algorithm.sort;

/**
 * 大于右边的数
 * num的右边有多少个数*2后依然比num小
 * [1,3,0,4,3,1]
 */
public class MergeSort04_BiggerThanRightTwice {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 0, 4, 3, 1};
        System.out.println(process(array, 0, array.length-1));
    }

    private static int process(int[] array, int L, int R) {
        if (L == R) {
            return 0;
        }
        int m = L + ((R - L) >> 1);
        return process(array, L, m) + process(array, m + 1, R) + merge(array, L, m, R);
    }

    private static int merge(int[] array, int L, int m, int R) {
        int res = 0;
        int windowR = m + 1;
        for (int i = L; i <= m; i++) {
            while (windowR <= R && array[i] > (array[windowR] << 1)) {
                windowR++;
            }
            res += windowR - m - 1;
        }
        int i = 0;
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = m + 1;
        while (p1 <= m && p2 <= R) {
            help[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= m) {
            help[i++] = array[p1++];
        }

        while (p2 <= R) {
            help[i++] = array[p2++];
        }

        for (i = 0; i < help.length; i++) {
            array[L + i] = help[i++];
        }
        return res;
    }

}

package com.howliked.structure.algorithm.sort;

/**
 * 逆序对
 */
public class Code03_ReversePair {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 4, 1, 5};
        System.out.println(process(array, 0, array.length - 1));
    }

    private static int process(int[] array, int l, int r) {
        if (l == r) return 0;
        int m = l + ((r - l) >> 1);
        return process(array, l, m) + process(array, m + 1, r) + merge(array, l, m, r);
    }

    private static int merge(int[] array, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = help.length - 1;
        int res = 0;
        int p1 = m;
        int p2 = r;
        while (p1 >= l && p2 > m) {
            res += array[p1] > array[p2] ? (p2 - m + 1) * array[p2] : 0;
            help[i--] = array[p1] > array[p2] ? array[p1--] : array[p2--];
        }
        while (p1 >= l) {
            help[i--] = array[p1--];
        }
        while (p2 > m) {
            help[i--] = array[p2--];
        }

        for (i = 0; i < help.length; i++) {
            array[l + i] = help[i];
        }

        return res;
    }
}

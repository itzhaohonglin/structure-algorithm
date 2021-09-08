package com.howliked.structure.algorithm.sort;

/**
 * 小和
 * 在一个数组中,每一个数左边比当前数小的数累加起来,叫做这个数组的小和。求一个数组 的小和。
 * 例子:[2,3,4,1,5]
 * 2左边比2小的元素：无
 * 3左边比3小的元素：2
 * 4左边比4小的元素：2，3
 * 1左边比1小的元素：无
 * 5左边比5小的元素：2,3,4,1
 * 小和small_sum = 2 + 2 + 3 + 2 + 3 + 4 + 1 = 17
 */
public class MergeSort02_SmallSum {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 1, 5};
        System.out.println(process(array, 0, array.length - 1));
    }

    private static int process(int[] array, int L, int R) {
        if (L == R) return 0;
        int middle = L + ((R - L) >> 1);
        return process(array, L, middle) + process(array, middle + 1, R) + merge(array, L, middle, R);
    }

    private static int merge(int[] array, int l, int middle, int r) {
        int res = 0;
        int p1 = l;
        int p2 = middle + 1;
        int i = 0;
        int[] help = new int[r - l + 1];
        while (p1 <= middle && p2 <= r) {
            res += array[p1] < array[p2] ? (r - p2 + 1) * array[p1] : 0;
            help[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }

        while (p1 <= middle) {
            help[i++] = array[p1++];
        }

        while (p2 <= r) {
            help[i++] = array[p2++];
        }

        for (i = 0; i < help.length; i++) {
            array[l + i] = help[i];
        }
        return res;
    }
}

package com.howliked.structure.algorithm.sort;

/**
 * https://leetcode.com/problems/count-of-range-sum/
 * 范围总和的计数:
 * 给定一个整数数组nums和两个整数lower and upper，返回包含在 [lower, upper] inclusive 中的范围和的数量。
 * 范围总和S(i, j)定义为nums索引i和j包含之间的元素的总和，其中i <= j。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [-2,5,-1]，lower = -2，upper = 2
 * 输出： 3
 * 解释：三个范围是：[0,0]、[2,2] 和 [0,2]它们各自的总和是：-2、-1、2。
 * 示例 2：
 * <p>
 * 输入： nums = [0]，lower = 0，upper = 0
 * 输出： 1
 */
public class MergeSort05_CountOfRangeSum {
    public static void main(String[] args) {
        int[] array = new int[]{-2, 5, -1};
        int lower = -2, upper = 2;
        System.out.println(countRangeSum(array, lower, upper));
    }

    /**
     * 计算前缀和
     * 前缀和:每一个位置保存着和前一个数相减之后的数
     *
     * @param array
     * @param lower
     * @param upper
     * @return
     */
    private static int countRangeSum(int[] array, int lower, int upper) {
        int[] sum = new int[array.length];
        sum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            sum[i] = sum[i - 1] + array[i];
        }

        return process(sum, 0, sum.length - 1, lower, upper);
    }

    private static int process(int[] sum, int L, int R, int lower, int upper) {
        if (L == R) {
            return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
        }
        int M = L + ((R - L) >> 1);
        return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper) + merge(sum, L, M, R, lower, upper);
    }

    private static int merge(int[] sum, int L, int M, int R, int lower, int upper) {
        int res = 0;
        int windowL = L;
        int windowR = L;
        //寻找右边的数,找左边
        for (int i = M + 1; i <= R; i++) {
            int min = sum[i] - upper;   //最小值
            int max = sum[i] - lower;   //最大值
            while (windowR <= M && sum[windowR] <= max) {
                windowR++;
            }
            while (windowL <= M && sum[windowL] < min) {
                windowL++;
            }

            res = windowR - windowL;
        }
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = sum[p1] < sum[p2] ? sum[p1++] : sum[p2++];
        }

        while (p1 <= M) {
            help[i++] = sum[p1++];
        }

        while (p2 <= R) {
            help[i++] = sum[p2++];
        }

        for (i = 0; i < help.length; i++) {
            sum[L + i] = help[i];
        }
        return res;
    }
}

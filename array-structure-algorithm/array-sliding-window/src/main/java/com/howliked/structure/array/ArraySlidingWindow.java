package com.howliked.structure.array;

/**
 * 滑动窗口
 * 题目209.长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class ArraySlidingWindow {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(maxLengthSub(array, 7));
    }

    private static int minLengthSub(int[] array, int value) {
        int result = Integer.MAX_VALUE;
        int subLength = 0;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            sum += array[j];    //每次循环累加值,是否已经超过预期值value
            while (sum >= value) {  //  思考:此处为什么循环?
                subLength = j - i + 1;      //记录满足条件的子数组长度
                result = result < subLength ? result : subLength;   //result为返回的数组,如果后续还有存在比subLength小的,则记录最小的值
                sum -= array[i++];  //此处是整块的精髓。 从i中去每一步寻找是否有满足预期value的结果
            }
        }
        return result == Integer.MAX_VALUE ? result : subLength;
    }

    private static int maxLengthSub(int[] array, int value) {
        int result = 0;
        int subLength = 0;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            sum += array[j];    //每次循环累加值,是否已经超过预期值value
            while (sum >= value) {  //  思考:此处为什么循环?
                subLength = j - i + 1;      //记录满足条件的子数组长度
                result = result > subLength ? result : subLength;   //result为返回的数组,如果后续还有存在比subLength小的,则记录最小的值
                sum -= array[i++];  //此处是整块的精髓。 从i中去每一步寻找是否有满足预期value的结果
            }
        }
        return result >0 ? result : subLength;
    }
}

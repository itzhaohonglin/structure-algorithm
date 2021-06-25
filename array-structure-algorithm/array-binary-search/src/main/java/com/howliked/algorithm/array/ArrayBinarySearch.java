package com.howliked.algorithm.array;

/**
 * 数组-二分查找法
 * 编号35：搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class ArrayBinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(array, 4));
    }

    /**
     * @param array  输入的数组
     * @param target 目标值
     * @return 返回应该所在index 位置
     */
    private static int searchInsert(int[] array, int target) {
        int length = array.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            //二分查找，从中间开始找,一分为2
            int middle = left + ((right - left) >> 1);
            if (array[middle] > target) { //中值比目标值大,则去左边查
                right = middle - 1;     //比中值大,肯定在[left,middle)之间,所以最大值为中间位置-1
            } else if (array[middle] < target) {    //中值比目标值小,则去右边查找
                left = middle + 1;  //中值比目标值小,肯定是在(middle,right]之间,所以最小值为中间位置+1
            } else {  //否则相等的情况,
                return middle;
            }
        }
        return right + 1;
    }
}

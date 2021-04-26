package com.howliked.structure.hash;

import java.util.*;

/**
 * 第349题. 两个数组的交集
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 * 示例1:
 * 输入:nums1=[1,2,2,1] ,nums=[2,2]
 * 输出:[2]
 * 示例2:
 * 输入:nums1=[4,9,5] ,nums=[9,4,9,8,4]
 * 输出:[9,4]
 * 「说明：」
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class HashTwoArrayIntersection {
    public static void main(String[] args) {
        System.out.println(intersection(Arrays.asList(4,9,5),Arrays.asList(9,4,9,8,4)));
    }

    private static Set<Integer> intersection(List<Integer> num1, List<Integer> num2) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> numsSet = new HashSet<>();
        numsSet.addAll(num1);
        for (Integer item : num2) {
            if (numsSet.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
}

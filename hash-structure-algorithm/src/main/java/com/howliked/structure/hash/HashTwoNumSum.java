package com.howliked.structure.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和
 */
public class HashTwoNumSum {

    public static void main(String[] args) {
        System.out.println();
    }

    private static List<Integer> twoSum(int[] array, int target) {
        Map map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            Object o = map.get(target - array[i]);
        }
        return null;
    }
}

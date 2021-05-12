package com.howliked.structure.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和
 */
public class HashTwoNumSum {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; result != null && i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[]{map.get(target - array[i]), i};
            }
            map.put(array[i], i);
        }
        return null;
    }
}

package com.howliked.structure.hash;

/**
 * 第242题. 有效的字母异位词
 */
public class HashEffectiveAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("tees", "eset"));
    }

    private static boolean isAnagram(String s, String t) {
        int[] array = new int[26];

        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            array[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

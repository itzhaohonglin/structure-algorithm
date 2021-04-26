package com.howliked.structure.string;

/**
 * 简单反转字符串
 */
public class SimpleStringReverse {

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }

    private static String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}

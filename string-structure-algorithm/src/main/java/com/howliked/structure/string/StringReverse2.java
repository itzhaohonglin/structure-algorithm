package com.howliked.structure.string;

/**
 * 字符串反转II
 * 给定一个字符串,两两反转
 * 示例:
 * abcdefg -> badcfeg
 */
public class StringReverse2 {
    public static void main(String[] args) {
        System.out.println(reverse("abcdefg", 1));
    }

    private static String reverse(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        // 每2k个元素为一组进行反转
        for (int i = 0; i < n; i += k*2) {
            int left = i;
            int right = (i + k - 1 < n) ? i + k - 1 : n - 1; //判断下标是否越界
            while (left < right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        String str = new String(ch);
        return str;
    }
}

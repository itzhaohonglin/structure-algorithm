package com.howliked.structure.string;

/**
 * KMP算法:当出现字符串不匹配时，可以记录一部分之前已经匹配的文本内容，利用这些信息避免从头再去做匹配
 * 题目：28. 实现 strStr()
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StringKMP {
    public static void main(String[] args) {
        System.out.println(strStr("aabaabaafa", "aabaaf"));
    }

    private static void getNext(int[] next, String s) {
        //1.初始化,值为-1,为没有前缀
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            //前后缀不相同的情况
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];    //回溯
            }
            //前后缀相同的情况
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }

    private static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {   //在haystack字符串中,从0开始匹配
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {  //匹配前后缀不相同的情况,是原字符串haystack的每一个字符,和needle模式串中去匹配
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == (needle.length() - 1)) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

}

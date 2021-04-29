package com.howliked.structure.stack;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 */
public class StackRemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    private static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || !stack.peek().equals(c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}

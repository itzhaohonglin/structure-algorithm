package com.howliked.structure.stack;

import sun.jvm.hotspot.runtime.VM;

import java.awt.geom.FlatteningPathIterator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 说明：
 * <p>
 * 整数除法只保留整数部分。给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * <p>
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", " * ", "/", " * ", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * 该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * 逆波兰表达式：是一种后缀表达式，所谓后缀就是指算符写在后面。
 * <p>
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * <p>
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * <p>
 * 逆波兰表达式主要有以下两个优点：
 * <p>
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * <p>
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 */
public class StackEvalRPN {

    public static void main(String[] args) {
        System.out.println(evalRPN(Arrays.asList("2", "1", "+", "3", "*")));
    }

    /**
     * @param tokens
     * @return
     */
    private static BigDecimal evalRPN(List<String> tokens) {
        Stack<BigDecimal> floatStack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                BigDecimal num1 = floatStack.pop();
                BigDecimal num2 = floatStack.empty() ? BigDecimal.ZERO : floatStack.pop();
                if ("+".equals(token)) {
                    floatStack.push((num1.add(num2)));
                } else if ("-".equals(token)) {
                    floatStack.push((num1.subtract(num2)));
                } else if ("*".equals(token)) {
                    floatStack.push(num1.multiply(num2));
                } else if ("-".equals(token)) {
                    floatStack.push(num1.divide(num2));
                }
            } else {
                floatStack.push(new BigDecimal(token));
            }
        }
        BigDecimal result = floatStack.peek();
        return result;
    }
}

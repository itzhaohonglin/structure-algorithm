package com.howliked.structure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树迭代遍历法(栈)
 */
public class BinaryTreeIterate {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        List<Integer> result = postorderTraversal(treeNode);
        result.forEach(System.out::println);
    }

    /**
     * 前序迭代 (中左右)
     *
     * @param root
     * @return
     */
    private static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            result.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return result;
    }

    /**
     * 中序迭代(左中右)
     *
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                cur = node.right;
            }
        }
        return result;
    }

    /**
     * 后序迭代(左右中)
     *
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            result.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }
}

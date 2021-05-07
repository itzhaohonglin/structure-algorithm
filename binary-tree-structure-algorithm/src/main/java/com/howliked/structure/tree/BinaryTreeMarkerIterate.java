package com.howliked.structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树标记遍历法
 */
public class BinaryTreeMarkerIterate {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        List<Integer> result = preorderMarkerTraversal(treeNode);
        result.forEach(System.out::println);
    }

    /**
     * 前序迭代 (中左右)
     *
     * @param root
     * @return
     */
    private static List<Integer> preorderMarkerTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) { //右
                    stack.push(node.right);
                }
                if (node.left != null) { //左
                    stack.push(node.left);
                }
                stack.push(node);//中
                stack.push(null);
            } else {
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    /**
     * 中序迭代(左中右)
     *
     * @param root
     * @return
     */
    private static List<Integer> inorderMarkerTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                node = stack.pop();
                result.add(node.val);
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
    private static List<Integer> postorderMarkerTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);   //中
                stack.push(null);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}

package com.howliked.structure.tree;

import java.util.Stack;

/**
 * 404.左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * 示例:
 * [3,9,null,null,20,15,7] -> 24 （两个左叶子,分别是9和15,所以返回）
 */
public class BinaryTreeLeftSum {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        //System.out.println(leftSumByTraversal(root));
        System.out.println(leftSumByIterate(root));
    }

    private static int leftSumByTraversal(TreeNode root) {
        if (root == null) return 0;
        int left = leftSumByTraversal(root.left); //1
        int right = leftSumByTraversal(root.right);//
        int middle = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            middle = root.left.val;
        }
        int sum = middle + left + right;
        return sum;
    }

    private static int leftSumByIterate(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sum;
    }
}

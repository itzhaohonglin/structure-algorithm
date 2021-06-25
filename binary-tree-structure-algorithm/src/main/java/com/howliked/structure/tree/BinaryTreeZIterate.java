package com.howliked.structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树Z字形遍历
 */
public class BinaryTreeZIterate {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println(zIterate(root));
    }

    private static List<Integer> zIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> left2Right = new Stack<>();
        Stack<TreeNode> right2left = new Stack<>();
        left2Right.push(root);
        boolean order = true;
        while (!left2Right.isEmpty() || !right2left.isEmpty()) {
            if (order) {
                while (!left2Right.isEmpty()) {
                    TreeNode node = left2Right.pop();
                    result.add(node.val);
                    if (node.left != null) {
                        right2left.push(node.left);
                    }
                    if (node.right != null) {
                        right2left.push(node.right);
                    }
                }
            } else {
                while (!right2left.isEmpty()) {
                    TreeNode node = right2left.pop();
                    result.add(node.val);
                    if (node.right != null) {
                        left2Right.push(node.right);
                    }
                    if (node.left != null) {
                        left2Right.push(node.left);
                    }
                }
            }
            order = !order;
        }
        return result;
    }
}

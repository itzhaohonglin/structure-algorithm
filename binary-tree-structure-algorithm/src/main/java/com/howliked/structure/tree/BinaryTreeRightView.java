package com.howliked.structure.tree;

import java.util.*;

/**
 * 199.二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例:
 * 5,3,8,1,2,6,9 -> 5,8,9
 */
public class BinaryTreeRightView {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        List<Integer> result = rightView(treeNode);
        result.forEach(System.out::println);
    }

    private static List<Integer> rightView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == (size - 1)) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}

package com.howliked.structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 104.二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]， ->  3
 */
public class BinaryTreeMaxDepth {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println(traversal(root));
        System.out.println(iterate(root));
    }

    /**
     * 递归方式实现
     *
     * @param root
     * @return
     */
    private static Integer traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1 + Math.max(traversal(root.left), traversal(root.right)); //中
        return depth;
    }

    private static Integer iterate(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

}

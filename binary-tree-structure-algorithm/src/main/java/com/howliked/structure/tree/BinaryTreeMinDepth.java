package com.howliked.structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]  -> 最小深度为2
 */
public class BinaryTreeMinDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(2);
        TreeNode rightNodeChildren1 = new TreeNode(15);
        TreeNode rightNodeChildren2 = new TreeNode(7);

        root.left = leftNode;
        root.right = rightNode;
        rightNode.left = rightNodeChildren1;
        rightNode.right = rightNodeChildren2;
        System.out.println(minDepthByTraversal(root));
        System.out.println(minDepthByIterate(root));
    }

    private static Integer minDepthByTraversal(TreeNode root) {
        if (root == null) return 0;
        int left = minDepthByTraversal(root.left);
        int right = minDepthByTraversal(root.right);
        if (root.left == null && root.right != null) {
            return 1 + right;
        }
        if (root.right == null && root.left != null) {
            return 1 + left;
        }
        return 1 + Math.min(left, right);
    }


    private static Integer minDepthByIterate(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int flag = 0;
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //左右两个子节点都为空,则表示已经到最底层了
                if (node.left == null && node.right == null) {
                    flag = 1;
                    break;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (flag == 1) break;
        }
        return depth;
    }
}

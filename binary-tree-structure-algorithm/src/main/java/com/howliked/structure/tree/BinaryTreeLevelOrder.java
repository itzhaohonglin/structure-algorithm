package com.howliked.structure.tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode leftNode = new TreeNode(4);
        TreeNode leftNodeChildren1 = new TreeNode(1);
        TreeNode leftNodeChildren2 = new TreeNode(2);
        TreeNode rightNode = new TreeNode(8);
        TreeNode rightNodeChildren1 = new TreeNode(6);
        TreeNode rightNodeChildren2 = new TreeNode(9);

        treeNode.left = leftNode;
        leftNode.left = leftNodeChildren1;
        leftNode.right = leftNodeChildren2;
        treeNode.right = rightNode;
        rightNode.left = rightNodeChildren1;
        rightNode.right = rightNodeChildren2;
        levelOrder(treeNode).forEach(System.out::println);
    }

    private static List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.addAll(temp);
        }
        return result;
    }
}

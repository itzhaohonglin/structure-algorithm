package com.howliked.structure.tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
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

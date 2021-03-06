package com.howliked.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637.二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例:
 * [3,9,20,null,null,15,7] -> [3,14.5,11]
 * 解释:第一层的平均值为3,第二层的平均值为14.5,第三层的平均值为11
 */
public class BinaryTreeLevelAvg {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        List<Double> result = averageOfLevels(treeNode);
        result.forEach(System.out::println);
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(sum / size);
        }

        return result;
    }
}

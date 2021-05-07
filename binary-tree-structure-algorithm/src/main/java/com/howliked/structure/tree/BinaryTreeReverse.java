package com.howliked.structure.tree;

import java.util.*;

/**
 * 226.翻转二叉树
 * [4,2,7,1,3,6,9]  -> 4,7,2,9,6,3,1
 */
public class BinaryTreeReverse {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println("原二叉树:" + treeNode);
        //TreeNode treeTraversal = invertTreeTraversal(treeNode);
        //System.out.println("反转后的二叉树(递归):" + treeTraversal);
        //TreeNode treeIterate = invertTreeIterate(treeNode);
        //System.out.println("反转后的二叉树(迭代):" + treeIterate);
        //TreeNode treeMarker = invertTreeMarker(treeNode);
        //System.out.println("反转后的二叉树(标记):" + treeMarker);
        TreeNode levelOrder = levelOrder(treeNode);
        System.out.println("反转后的二叉树(广度优先):" + levelOrder);
    }

    /**
     * 递归反转
     *
     * @param root
     * @return
     */
    private static TreeNode invertTreeTraversal(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeTraversal(root.left);
        invertTreeTraversal(root.right);
        return root;
    }

    /**
     * 迭代反转
     *
     * @param root
     * @return
     */
    private static TreeNode invertTreeIterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    /**
     * 统一迭代反转法
     *
     * @param root
     * @return
     */
    private static TreeNode invertTreeMarker(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            } else {
                node = stack.pop();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }

    /**
     * 广度优先反转
     *
     * @param root
     * @return
     */
    private static TreeNode levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}

package com.howliked.structure.tree;

import java.util.Stack;

/**
 * 二叉搜索树
 */
public class BinaryTreeSearch {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(searchBSTByIterate(treeNode, 10));
    }

    private static TreeNode searchBSTByTraversal(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) return searchBSTByTraversal(root.left, val);
        else if (root.val < val) return searchBSTByTraversal(root.right, val);
        else return root;
    }

    private static TreeNode searchBSTByIterate(TreeNode root, int val) {
        if (root == null) return null;
        while (root != null) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}

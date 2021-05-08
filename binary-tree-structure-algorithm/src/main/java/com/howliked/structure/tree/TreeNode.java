package com.howliked.structure.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static TreeNode getTreeNode() {
        TreeNode treeNode = new TreeNode(3);
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
        return treeNode;
    }
}

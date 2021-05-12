package com.howliked.structure.tree;

/**
 * 110.平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]  返回 true 。
 * <p>
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4] 返回 false 。
 * <p>
 * 这里强调一波概念：
 * 二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数。
 * 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数。
 */
public class BinaryTreeBalance {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(4);
        TreeNode leftNodeChildren1 = new TreeNode(1);
        TreeNode leftNodeChildren2 = new TreeNode(2);
        TreeNode leftNodeChildren3 = new TreeNode(6);
        TreeNode leftNodeChildren4 = new TreeNode(9);

        root.left = leftNode;
        leftNodeChildren1.left = leftNodeChildren3;
        leftNodeChildren3.left = leftNodeChildren2;
        leftNodeChildren2.left = leftNodeChildren4;
        leftNode.left = leftNodeChildren1;
        System.out.println(isBalance(root));
    }


    private static int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left); //左
        int right = getDepth(root.right);   //右
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }

    private static boolean isBalance(TreeNode root) {
        if (root == null) return true;
        return getDepth(root) == -1 ? false : true;
    }

}

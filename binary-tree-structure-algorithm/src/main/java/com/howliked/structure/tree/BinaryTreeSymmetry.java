package com.howliked.structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 101. 对称二叉树
 */
public class BinaryTreeSymmetry {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode leftNodeChildren1 = new TreeNode(3);
        TreeNode leftNodeChildren2 = new TreeNode(4);
        TreeNode rightNode = new TreeNode(2);
        TreeNode rightNodeChildren1 = new TreeNode(4);
        TreeNode rightNodeChildren2 = new TreeNode(3);

        root.left = leftNode;
        leftNode.left = leftNodeChildren1;
        leftNode.right = leftNodeChildren2;
        root.right = rightNode;
        rightNode.left = rightNodeChildren1;
        rightNode.right = rightNodeChildren2;
        //TreeNode root = TreeNode.getTreeNode();
        System.out.println(isSymmetric(root));
        System.out.println(iterate(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        return traversal(root.left, root.right);
    }

    /**
     * 递归方式实现
     * 1.确定递归函数的参数和返回值
     * 因为我们要比较的是根节点的两个子树是否是相互翻转的，进而判断这个树是不是对称树，所以要比较的是两个树，参数自然也是左子树节点和右子树节点。
     * 返回值自然是bool类型。
     * 2.确定终止条件
     * 要比较两个节点数值相不相同，首先要把两个节点为空的情况弄清楚！否则后面比较数值的时候就会操作空指针了。
     * 左节点为空，右节点不为空，不对称，return false
     * 左不为空，右为空，不对称 return  false
     * 左右都为空，对称，返回true
     * 左右都不为空，比较节点数值，不相同就return false
     * <p>
     * 3.确定单层递归的逻辑
     * 此时才进入单层递归的逻辑，单层递归的逻辑就是处理 右节点都不为空，且数值相同的情况。
     * 比较二叉树外侧是否对称：传入的是左节点的左孩子，右节点的右孩子。
     * 比较内测是否对称，传入左节点的右孩子，右节点的左孩子。
     * 如果左右都对称就返回true ，有一侧不对称就返回false 。
     *
     * @param left
     * @param right
     * @return
     */
    private static boolean traversal(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        boolean outside = traversal(left.left, right.right);
        boolean inside = traversal(left.right, right.left);
        boolean isSame = outside && inside;
        return isSame;
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    private static boolean iterate(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            //左右都为空,说明对称
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if ((leftNode == null || rightNode == null) || (leftNode.val != rightNode.val)) {
                return false;
            }
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

}

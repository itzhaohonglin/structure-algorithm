package com.howliked.structure.tree;

/**
 * 98.验证二叉搜索树
 */
public class BinaryTreeSearchCheck {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println(checkBTS(root));
    }

    private static int maxVal = 0;

    private static boolean checkBTS(TreeNode root) {
        if (root == null) return true;
        boolean left = checkBTS(root.left);
        if (maxVal < root.val){
            maxVal = root.val;
        }else{
            return false;
        }
        boolean right = checkBTS(root.right);
        return left && right;
    }
}

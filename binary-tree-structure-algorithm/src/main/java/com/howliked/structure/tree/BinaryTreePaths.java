package com.howliked.structure.tree;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * [1,2,null,5,3]
 * <p>
 * 输出:["1->2-5","1->3"]
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode roLeftNode = new TreeNode(2);
        TreeNode roRightNode = new TreeNode(3);
        TreeNode rlRightNode1 = new TreeNode(5);
        roLeftNode.right = rlRightNode1;
        root.left = roLeftNode;
        root.right = roRightNode;
        System.out.println(binaryTreePaths(root));
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> result = new LinkedList<>();
        if (root == null) return result;
        traversal(root, "", result);
        return result;
    }

    private static void traversal(TreeNode cur, String path, LinkedList<String> result) {
        path += cur.val;
        if (cur.left == null && cur.right == null) {    //叶子节点
            result.add(path);
            return;
        }
        if (cur.left != null) {
            traversal(cur.left, path + "->", result);
        }
        if (cur.right != null) {
            traversal(cur.right, path + "->", result);
        }
    }
}

package com.howliked.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归算法 -二叉树的前、中、后序遍历
 * 「确定递归函数的参数和返回值：」确定哪些参数是递归的过程中需要处理的，那么就在递归函数里加上这个参数， 并且还要明确每次递归的返回值是什么进而确定递归函数的返回类型。
 * <p>
 * 「确定终止条件：」写完了递归算法,  运行的时候，经常会遇到栈溢出的错误，就是没写终止条件或者终止条件写的不对，操作系统也是用一个栈的结构来保存每一层递归的信息，如果递归没有终止，操作系统的内存栈必然就会溢出。
 * <p>
 * 「确定单层递归的逻辑：」确定每一层递归需要处理的信息。在这里也就会重复调用自己来实现递归的过程。
 */
public class BinaryTreeTraversal {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode leftNode = new TreeNode(5);
        TreeNode rightNode = new TreeNode(8);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        List<Integer> result = new ArrayList<>();
        traversalByBack(treeNode, result);
        result.forEach(val -> {
            System.out.println(val);
        });
    }

    /**
     * 「确定递归函数的参数和返回值」：因为要打印出前序遍历节点的数值，所以参数里需要传入vector在放节点的数值，除了这一点就不需要在处理什么数据了也不需要有返回值，所以递归函数返回类型就是void
     * 「确定终止条件」：在递归的过程中，如何算是递归结束了呢，当然是当前遍历的节点是空了，那么本层递归就要要结束了，所以如果当前遍历的这个节点是空，就直接return，代码如下：
     * 「确定单层递归的逻辑」：前序遍历是中左右的循序，所以在单层递归的逻辑，是要先取中节点的数值，代码如下：
     *
     * @param root
     * @param valList
     */

    /**
     * 前序遍历
     *
     * @param root
     * @param valList
     */
    private static void traversalByFront(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        valList.add(root.val);
        traversalByFront(root.left, valList);
        traversalByFront(root.right, valList);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param valList
     */
    private static void traversalByMiddle(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        traversalByFront(root.left, valList);
        valList.add(root.val);
        traversalByFront(root.right, valList);
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param valList
     */
    private static void traversalByBack(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        traversalByFront(root.left, valList);
        traversalByFront(root.right, valList);
        valList.add(root.val);
    }
}

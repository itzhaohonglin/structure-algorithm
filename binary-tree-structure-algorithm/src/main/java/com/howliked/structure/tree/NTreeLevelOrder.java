package com.howliked.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N层二叉树遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。(即从左到右，逐层遍历)。
 * [[1],[3,2,4],[5,6]]
 */
public class NTreeLevelOrder {
    public static void main(String[] args) {
        NTreeNode root = NTreeNode.getNTreeNode();
        System.out.println(nLevelOrder(root));
    }

    private static List<ArrayList<Integer>> nLevelOrder(NTreeNode root) {
        Queue<NTreeNode> queue = new LinkedList<>();
        List<ArrayList<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NTreeNode node = queue.poll();
                level.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    for (int j = 0; j < node.children.size(); j++) {
                        if (node.children.get(j) != null) {
                            queue.offer(node.children.get(j));
                        }
                    }
                }
            }
            result.add(level);
        }
        return result;
    }
}

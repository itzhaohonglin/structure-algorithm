package com.howliked.structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 559.N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class NTreeMaxDepth {
    public static void main(String[] args) {
        NTreeNode root = NTreeNode.getNTreeNode();
        System.out.println(maxDepthByTraversal(root));
        System.out.println(maxDepthByIterate(root));
    }

    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    private static Integer maxDepthByTraversal(NTreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        if (root.children != null && root.children.size() > 0) {
            int size = root.children.size();
            for (int i = 0; i < size; i++) {
                depth = Math.max(depth, maxDepthByTraversal(root.children.get(i)));
            }
        }
        return depth + 1;
    }

    private static Integer maxDepthByIterate(NTreeNode root) {
        int depth = 0;
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                NTreeNode nNode = queue.poll();
                if (nNode.children != null && nNode.children.size() > 0) {
                    for (int j = 0; j < nNode.children.size(); j++) {
                        if (nNode.children.get(j) != null) {
                            queue.offer(nNode.children.get(j));
                        }
                    }
                }
            }
        }
        return depth;
    }
}

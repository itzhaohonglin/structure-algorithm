package com.howliked.structure.tree;

import java.util.ArrayList;
import java.util.List;

public class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {
    }

    public NTreeNode(int val) {
        this.val = val;
    }

    public NTreeNode(int val, List<NTreeNode> children) {
        this.val = val;
        this.children = children;
    }

    @Override
    public String toString() {
        return "NTreeNode{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }


    public static NTreeNode getNTreeNode() {
        NTreeNode treeNode = new NTreeNode(1);
        NTreeNode childNode1 = new NTreeNode(3);
        NTreeNode childNode2 = new NTreeNode(2);
        NTreeNode childNode3 = new NTreeNode(4);

        List<NTreeNode> treeChild1 = new ArrayList<>();
        treeChild1.add(childNode1);
        treeChild1.add(childNode2);
        treeChild1.add(childNode3);

        NTreeNode childNode11 = new NTreeNode(5);
        NTreeNode childNode12 = new NTreeNode(6);

        List<NTreeNode> treeChild11 = new ArrayList<>();
        treeChild11.add(childNode11);
        treeChild11.add(childNode12);
        childNode1.children = treeChild11;
        treeNode.children = treeChild1;
        return treeNode;
    }
}

package com.tusk.tree;

/**
 * @author tusk
 * @desc
 * @date 2021/5/24 11:24
 */
public class BinaryTreeNode {
    public int key;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(int key) {
        this.key = key;
    }

    public BinaryTreeNode(int key, BinaryTreeNode left, BinaryTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

package com.tusk.tree;


import java.util.TreeMap;

/**
 * @author tusk
 * @desc leetcode-226:翻转二叉树
 * @date 2021/12/22 9:06
 */
public class P226_InverseTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode result = new P226_InverseTree().invertTree(root);
        System.out.println(result);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;

            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }
}

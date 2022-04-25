package com.tusk.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tusk
 * @desc leetcode-106:根据中序和后续序列构建二叉树，然后返回根节点
 * @date 2021/12/30 9:03
 */
public class P106_BuildTree {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};

        inorder = new int[]{1,2};
        postorder = new int[]{2,1};

        TreeNode root = new P106_BuildTree().buildTree(inorder, postorder);
        System.out.println(root);
    }

    /**
     * 后续节点的最后一个为根
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }

        int n = inorder.length;

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int ioleft, int ioright, int postleft, int postright) {
        if (postleft > postright) {
            return null;
        }

        int postroot = postorder[postright];

        int inrootIndex = indexMap.get(postroot);

        int leftSubtreeSize = inrootIndex - ioleft;

        TreeNode root = new TreeNode(postroot);
        root.left = build(postorder,inorder,ioleft,inrootIndex - 1,postleft,postleft + leftSubtreeSize -1);
        root.right = build(postorder,inorder,inrootIndex+1,ioright,postleft + leftSubtreeSize,postright - 1 );

        return root;
    }
}
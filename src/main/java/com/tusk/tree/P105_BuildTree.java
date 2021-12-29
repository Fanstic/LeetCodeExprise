package com.tusk.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tusk
 * @desc
 * @date 2021/12/29 10:17
 */
public class P105_BuildTree {
    public Map<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        P105_BuildTree obj = new P105_BuildTree();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = obj.buildTree(preorder, inorder);
        System.out.println(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }

        int n = preorder.length;

        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
        if (preleft > preright) {
            return null;
        }

        //先序遍历的第一个元素就是根
        int preroot = preorder[preleft];

        //中序序列根节点索引
        int inroot = indexMap.get(preroot);

        TreeNode root = new TreeNode(preroot);

        int sizeLeftSubtree = inroot - inleft;


        //递归构造左子树，先序：[root+1,root+1+n(left)],中序[left,root-1]
        root.left = build(preorder, inorder, preleft + 1, preleft + sizeLeftSubtree, inleft, inroot - 1);

        //递归构造右子树，先序：[
        root.right = build(preorder, inorder, preleft + sizeLeftSubtree + 1, preright, inroot + 1, inright);

        return root;
    }
}

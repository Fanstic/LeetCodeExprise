package com.tusk.tree;

import java.util.Arrays;

/**
 * @author tusk
 * @desc
 * @date 2021/5/24 11:29
 */
public class BinaryTree {
    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        BinaryTreeNode root = PM(pre, mid, pre.length);

        System.out.println(root);
    }

    /**
     * 根据 先序序列和中序序列创建一棵二叉树
     *
     * @param pre 先序序列
     * @param mid 中序序列
     * @param len
     * @return
     */
    public static BinaryTreeNode PM(int[] pre, int[] mid, int len) {
        if (pre == null || mid == null) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode();
        int rootKey = pre[0];

        //先序遍历序列的第一个元素就是根元素
        root.key = rootKey;

        //长度为1,先序遍历和中序遍历序列相同
        if (len == 1 && Arrays.equals(pre, mid)) {
            return root;
        }

        boolean isMatch = false;
        int leftLen = 0;

        //中序序列根节点左侧的便是左子树的节点,右侧的便是右子树的节点
        int midOrder = -1;

        for (int i = 0; i < mid.length; i++) {
            if (mid[i] == rootKey) {
                isMatch = true;
                midOrder = i;
                break;
            }
            leftLen++;
        }

        //在中序遍历序列中未找到根节点,说明中序序列与先序序列不匹配
        if (!isMatch) {
            return null;
        }

        //右边自述节点长度 = len - root - leftLen
        int rightLen = len - leftLen - 1;
        //构建左子树
        if (leftLen > 0) {
            //pre[1,1 + leftLen)
            int[] temPre = Arrays.copyOfRange(pre, 1, 1 + leftLen);

            //mid[0,leftLen)
            int[] temMid = Arrays.copyOfRange(mid, 0, leftLen);

            root.left = PM(temPre, temMid, leftLen);
        }

        //构建右子树
        if (rightLen > 0) {
            //先序序列 pre[len - rightLen,len)
            int[] temPre = Arrays.copyOfRange(pre, midOrder + 1, midOrder + 1 + rightLen);
            //中序序列根节点右侧元素(不包含根元素)
            int[] temMid = Arrays.copyOfRange(mid, midOrder + 1, midOrder + 1 + rightLen);

            root.right = PM(temPre, temMid, rightLen);
        }

        return root;
    }

    public static void preOrderTraversal(BinaryTreeNode root) {

    }
}

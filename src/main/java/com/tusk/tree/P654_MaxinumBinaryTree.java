package com.tusk.tree;

import java.nio.channels.NotYetBoundException;

/**
 * @author tusk
 * @desc
 * leetcode-654:构建最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/29 9:16
 */
public class P654_MaxinumBinaryTree {
    public static void main(String[] args) {
        P654_MaxinumBinaryTree obj = new P654_MaxinumBinaryTree();
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode root = obj.constructMaximumBinaryTree(nums);
        System.out.println(root);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int left, int right) {

        if (left >= right) {
            return null;
        }

        int max = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }

        TreeNode node = new TreeNode(nums[max]);

        node.left = construct(nums, left, max);
        node.right = construct(nums, max + 1, right);


        return node;
    }
}

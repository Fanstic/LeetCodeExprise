package com.tusk.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tusk
 * @desc P112  给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * @date 2021/5/27 8:45
 */
public class P112_HasPathSum {
    /**
     * 深度优先遍历
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(BinaryTreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.key == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.key)
                || hasPathSum(root.right, targetSum - root.key);
    }

    public boolean hasPathSum01(BinaryTreeNode root,int sum){
        if(root == null){
            return false;
        }

        Queue<BinaryTreeNode> nodes_q = new LinkedList<>();
        Queue<Integer> val_q = new LinkedList<>();

        nodes_q.offer(root);
        val_q.offer(root.key);

        while (!nodes_q.isEmpty()){
            BinaryTreeNode node = nodes_q.poll();
            int val = val_q.poll();

            if(node.right == null&&node.left == null){
                if(val == sum){
                    return true;
                }
                continue;
            }

            if(node.left!=null){
                nodes_q.offer(node.left);
                val_q.offer(node.left.key + val);
            }

            if(node.right!=null){
                nodes_q.offer(node.right);
                val_q.offer(node.right.key + val);
            }
        }

        return false;
    }
}

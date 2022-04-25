package com.tusk.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tusk
 * @desc leetcode-114:二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *  
 * <p>
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/22 9:55
 */
public class P114_Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> list = new ArrayList<>();
        pre_traverse(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode cur = list.get(i);
            cur.left = null;
            cur.right = list.get(i + 1);
        }
    }

    /**
     * @param root 先序遍历当前节点的下一个节点
     *             1.如果当前节点存在左孩子，则下一个节点就是其左孩子
     *             2.如果不存在左孩子，则下一个节点就是其右孩子
     *             3.如果左孩子和右孩子都不存在，则下一个节点为其父节点的父节点的右孩子
     *
     *             时间复杂度:O(N)
     *             空间复杂度：O(1)
     */
    public void flattenV1(TreeNode root) {
        /*
        如果当前节点没有左孩子，则无需展开
        当前节点的左子树的最右节点为当前节点右孩子的前驱
         */
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    private void pre_traverse(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            pre_traverse(root.left, list);
            pre_traverse(root.right, list);
        }
    }
}

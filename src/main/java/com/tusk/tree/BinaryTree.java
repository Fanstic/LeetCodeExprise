package com.tusk.tree;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tusk
 * @desc
 * @date 2021/5/24 11:29
 */
public class BinaryTree {
    public static void main(String[] args) {
//        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
//        int[] mid = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        int[] pre = new int[]{5, 4, 3, 2, 1, 6, 7, 8, 11};
        int[] mid = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 11};

        BinaryTreeNode root = PM(pre, mid, pre.length);
//        insert(root, 9);
        levelTraversal(root);


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

    /**
     * 递归先序遍历 二叉树
     *
     * @param root
     */
    public static void preOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.key);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 递归中序遍历二叉树
     *
     * @param root
     */
    public static void midOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        midOrderTraversal(root.left);
        System.out.println(root.key);
        midOrderTraversal(root.right);
    }

    /**
     * 递归后续遍历二叉树
     *
     * @param root
     */
    public static void lastOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        lastOrderTraversal(root.right);
        lastOrderTraversal(root.left);
        System.out.println(root.key);
    }

    /**
     * 按照层级遍历
     *
     * @param root
     */
    public static void levelTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();


        queue.add(root);

        /*
         * 打印当前节点,如果节点左节点不为null,将左节点入队,
         * 如果右节点不为 null,将右节点入队
         * 执行上述流程直至队列为空
         */
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.println(node.key);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    //TODO:获取 key 在 二叉树 root 中的前驱节点

    /**
     * 获取 key 在 二叉树 root 中的前驱节点
     *
     * @param root
     * @param key
     * @param triversaltype 遍历的类型
     * @return
     */
    public static BinaryTreeNode getPre(BinaryTreeNode root, int key, TRIVERSALTYPE triversaltype) {
        return null;
    }

    //TODO:获取 key 在二叉树 root 中的后继节点

    /**
     * 获取 key 在二叉树 root 中的后继节点
     *
     * @param root
     * @param key
     * @param triversaltype 遍历类型
     * @return
     */
    public static BinaryTreeNode getNext(BinaryTreeNode root, int key, TRIVERSALTYPE triversaltype) {
        return null;
    }

    /**
     * 在二叉查找树种查找key
     *
     * @param root
     * @param key
     * @return 查找成功返回 true,否则返回 false
     */
    public static BinaryTreeNode searchTree(BinaryTreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key == root.key) {
            return root;
        } else if (root.left != null && key < root.key) {
            return searchTree(root.left, key);
        } else if (root.right != null && key > root.key) {
            return searchTree(root.right, key);
        }

        return null;
    }

    /**
     * 在二叉树中插入 key
     *
     * @param root
     * @param key
     * @return
     */
    public static BinaryTreeNode insert(BinaryTreeNode root, int key) {
        if (root == null) {
            root = new BinaryTreeNode();
            root.key = key;

            return root;
        }

        BinaryTreeNode node = searchTree(root, key);

        if (node != null) {
            return node;
        } else {
            return insertInternal(root, key);
        }
    }

    private static BinaryTreeNode insertInternal(BinaryTreeNode root, int key) {

        if (key < root.key) {
            if (root.left == null) {
                root.left = new BinaryTreeNode(key);
                return root.left;
            } else {
                return insertInternal(root.left, key);
            }
        } else {
            if (root.right == null) {
                root.right = new BinaryTreeNode(key);
                return root.right;
            } else {
                return insertInternal(root.right, key);
            }

        }
    }

    /**
     * 遍历的类型
     */
    static enum TRIVERSALTYPE {
        /**
         * 先序
         */
        PRE,
        /**
         * 中序
         */
        MID,
        /**
         * 后续
         */
        LAST,
        /**
         * 层级遍历
         */
        LEVEL
    }
}

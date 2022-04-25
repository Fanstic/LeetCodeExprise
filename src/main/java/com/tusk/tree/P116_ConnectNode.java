package com.tusk.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tusk
 * @desc leetcode-116:填充每个节点的下一个右侧指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量少于 4096
 * -1000 <= node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/22 13:42
 */
public class P116_ConnectNode {
    /**
     * 采用层序遍历方式处理
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            //当前一层的节点数
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();


                //连接当前一层
                if (i < size - 1) {
                    cur.next = queue.peek();
                }

                //扩展下一层
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        return root;
    }

    /**
     * 利用已有的next指针建立下一层的next指针
     *
     * @param root
     * @return
     */
    public Node connectV1(Node root) {
        Node mostLeft = root;

        while (mostLeft.left != null) {

            //遍历当前层，建立下一层的next指针
            Node head = mostLeft;
            while (head != null) {

                //第一种情况：要连接的两个节点属于同一个父节点
                if (head.left != null) {
                    head.left.next = head.right;
                }

                //第二种情况：要连接的两个节点属于相邻的两个不同的父节点
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                //当前节点向后移
                head = head.next;
            }

            //移动到下一层
            mostLeft = mostLeft.left;
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}



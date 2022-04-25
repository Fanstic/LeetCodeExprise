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

//        int[] pre = new int[]{5, 4, 3, 2, 1, 6, 7, 8, 11};
//        int[] mid = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 11};

        int[] pre = new int[]{40, 20, 70, 60, 75, 71, 73};
        int[] mid = new int[]{20, 40, 60, 70, 71, 73, 75};

        TreeNode root = PM(pre, mid, pre.length);
//        insert(root, 9);
//        midOrderTraversal(root);
//        System.out.println(getNext(root, 40).key);
//        System.out.println(maxDepth(root));


    }

    /**
     * 根据 先序序列和中序序列创建一棵二叉树
     *
     * @param pre 先序序列
     * @param mid 中序序列
     * @param len
     * @return
     */
    public static TreeNode PM(int[] pre, int[] mid, int len) {
        if (pre == null || mid == null) {
            return null;
        }

        TreeNode root = new TreeNode();
        int rootKey = pre[0];

        //先序遍历序列的第一个元素就是根元素
        root.val = rootKey;

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
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 递归中序遍历二叉树
     *
     * @param root
     */
    public static void midOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrderTraversal(root.left);
        System.out.println(root.val);
        midOrderTraversal(root.right);
    }

    /**
     * 递归后续遍历二叉树
     *
     * @param root
     */
    public static void lastOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        lastOrderTraversal(root.right);
        lastOrderTraversal(root.left);
        System.out.println(root.val);
    }

    /**
     * 按照层级遍历
     *
     * @param root
     */
    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();


        queue.add(root);

        /*
         * 打印当前节点,如果节点左节点不为null,将左节点入队,
         * 如果右节点不为 null,将右节点入队
         * 执行上述流程直至队列为空
         */
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    /**
     * 获取 key 在 二叉树 root 中的前驱节点(中序遍历序列中当前元素的前一个元素)
     * 1. 当前节点左子树不为空，则前驱为左子树中的最右节点
     * 2. 当前节点左子树为空
     * 2.1 当前节点为父节点的右孩子，则前驱节点为当前节点的父节点
     * 2.2 当前节点为父节点的左孩子，则前驱节点为当前节点的父节点的最近父节点，即当前节点的最近祖父节点
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode getPre(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode cur = null;
        TreeNode p = null;
        TreeNode next = root;

        while (next != null) {
            if (next.val == key) {
                cur = next;
                break;
            } else if (key < next.val) {
                p = next;
                next = next.left;
            } else {
                p = next;
                next = next.right;
            }
        }

        if (cur.left == null) {
            //左孩子为 null，且当前节点为父节点的右孩子，前驱节点为当前节点的父节点
            if (p != null && p.right == cur) {
                return p;
            } else if (p != null && p.left == cur) {
                //左孩子为null，且当前节点为父节点的右孩子，则前驱节点为当前节点的最近祖父节点
                next = root;
                cur = p;
                while (next != null) {
                    if (next.val == cur.val) {
//                        p = next;
                        break;
                    } else if (cur.val < next.val) {
                        p = next;
                        next = next.left;
                    } else {
                        p = next;
                        next = next.right;
                    }
                }

                return p;
            }
        } else {
            next = cur.left;
            while (next.right != null) {
                next = next.right;
            }

            return next;
        }

        return null;
    }

    /**
     * 获取 key 在二叉树 root 中的后继节点(中序遍历序列)
     * 1. 如果当前节点的右子树不为null，则后继节点便为右子树的最左节点
     * 2. 如果当前节点的右子树为null
     * 2.1 如果当前节点为父节点的左孩子，则后继节点为当前节点的父节点
     * 2.2 如果当前节点为父节点的右孩子，则后继节点为当前节点父节点的父节点，即当前节点的最近祖父节点
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode getNext(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode p = null;
        TreeNode cur = null;
        TreeNode next = root;

        while (next != null) {
            if (next.val == key) {
                cur = next;
                break;
            } else if (key < next.val) {
                p = next;
                next = next.left;
            } else {
                p = next;
                next = next.right;
            }
        }

        if (cur != null) {
            if (cur.right != null) {
                next = cur.right;
                while (next.left != null) {
                    next = next.left;
                }

                return next;
            } else {
                if (p != null && cur == p.left) {
                    return p;
                } else {
                    cur = p;
                    next = root;
                    p = null;
                    while (next != null) {
                        if (cur.val == next.val) {
                            break;
                        } else if (cur.val < next.val) {
                            p = next;
                            next = next.left;
                        } else {
                            p = next;
                            next = next.right;
                        }
                    }

                    return p;
                }
            }
        }

        return null;
    }

    /**
     * 在二叉查找树种查找key
     *
     * @param root
     * @param key
     * @return 查找成功返回 true,否则返回 false
     */
    public static TreeNode searchTree(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key == root.val) {
            return root;
        } else if (root.left != null && key < root.val) {
            return searchTree(root.left, key);
        } else if (root.right != null && key > root.val) {
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
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode();
            root.val = key;

            return root;
        }

        TreeNode node = searchTree(root, key);

        if (node != null) {
            return node;
        } else {
            return insertInternal(root, key);
        }
    }

    //TODO:在查找二叉树中删除 key 指定的节点

    /**
     * 在查找二叉树中删除 key 指定的节点
     * 参考：https://www.cnblogs.com/xfgnongmin/p/10860492.html
     *
     * @param root
     * @param key
     * @return
     */
    public static void del(TreeNode root, int key) {
        if (root == null) {
            return;
        }

        //记录当前节点的父节点
        TreeNode p = null;

        //记录当前节点
        TreeNode next = root;

        //记录目标节点
        TreeNode target = null;

        if (root.val == key) {
            target = root;
        } else {
            //查找要删除的节点及其父节点
            while (next != null) {
                if (key < next.val) {
                    p = next;
                    next = next.left;
                } else if (key > next.val) {
                    p = next;
                    next = next.right;
                } else {
                    target = next;
                    break;
                }
            }
        }

        if (target != null) {
            if (target.left == null) {
                if (target.right == null) {
                    //即目标节点为 root 节点，并且为树中的唯一节点，直接将当前节点清空
                    if (p == null) {
                        root = null;

                    } else {
                        //目标节点为叶子节点
                        if (p.left == target) {
                            p.left = null;
                        } else {
                            p.right = null;
                        }
                    }
                } else {
                    if (p == null) {
                        target = target.right;
                    } else {
                        if (p.left == target) {
                            p.left = target.right;
                        } else {
                            p.right = target.right;
                        }
                    }

                }
            } else {
                if (target.right == null) {
                    if (p == null) {
                        root = root.left;
                    } else {
                        if (p.left == target) {
                            p.left = target.left;
                        } else {
                            p.right = target.left;
                        }
                    }

                } else {
                    //左右节点都不为空，需要找到比目标节点大的所有节点中的最小节点,即中继后续节点,来替换当前节点
                    //(或比目标节点小的所有节点中的最大值节点)
                    //中继后续节点即当前节点的右子树的最左节点，因此，中继后续节点一定没有左孩子

                    TreeNode relayTreeNode = getRelayNextNode(target);

                    if (target == root) {
                        root = relayTreeNode;
                    } else if (p.left == target) {
                        p.left = relayTreeNode;
                    } else {
                        p.right = relayTreeNode;
                    }

                    relayTreeNode.left = target.left;

                }
            }
        }
    }

    /**
     * 获取二叉树的深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        return P104_MaxDepth.maxDepth(root);
    }

    /**
     * 获取指定节点的中继后续节点
     *
     * @param node
     * @return
     */
    private static TreeNode getRelayNextNode(TreeNode node) {
        TreeNode cur = node.right;
        TreeNode p = null;
        TreeNode relayNode = cur;

        while (cur != null) {
            p = cur;
            relayNode = cur;
            cur = cur.left;
        }

        if (relayNode != node.right) {
            //将中继后续节点的孩子节点替补到中继后续节点上,中继后续节点没有左孩子，因此将右孩子替补上去
            p.left = relayNode.right;

            //将被删除节点的右孩子连接到中继节点的右孩子上
            relayNode.right = node.right;

            //将被删除节点的左孩子连接到中继节点的左孩子上
//        relayNode.left = node.left;
        }


        return relayNode;
    }

    private static TreeNode insertInternal(TreeNode root, int key) {

        if (key < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(key);
                return root.left;
            } else {
                return insertInternal(root.left, key);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(key);
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

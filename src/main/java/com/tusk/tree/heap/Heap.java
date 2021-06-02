package com.tusk.tree.heap;

/**
 * @author tusk
 * @desc
 * 堆定义：
 * 1.堆是一个完全二叉树
 * 2.所有节点都大于等于(或小于等于)其子树中每个节点的值，前者称为大顶堆，后者称为小顶堆
 * ==========================================================
 * 大顶堆的堆顶元素就是所有元素中的最大元素
 * 小顶堆的堆顶元素就是所有元素中的最小元素
 * ==========================================================
 * 用数组存储时：左节点 2i,右节点2i+1,父节点 i/2
 * @date 2021/6/1 9:44
 */
public class Heap {
    private int[] data;
    /*
    最大容量
     */
    private int n;

    /*
    当前节点数
     */
    private int count;

    public Heap(int capacity) {
        data = new int[capacity + 1];//下标0位置不存储数据
        n = capacity;
        count = 0;
    }


    /**
     * 构建堆
     * 时间复杂度O(n)
     * @param data
     * @param n
     * @return
     */
    public static Heap buildHeap(int[] data,int n){
        Heap heap = new Heap(n);
        heap.data = data;

        //堆从 n/2 + 1 到 n都是叶子节点，无需堆化
        for(int i = n/2;i>=1;i--){
            heapify(data, n,i);
        }


        return heap;
    }

    /**
     * 插入数据
     * 时间复杂度：O(LogN)
     *
     * @param n
     */
    public void insert(int n) {
        if (count >= n)
            return;

        ++count;//下标0不存储，因此要先 ++count;
        data[count] = n;
        int i = count;

        //自下而上堆化,大顶堆，当前元素比父节点大就交互两者,往复执行，直至根节点
        while (i / 2 > 0 && data[i] > data[i / 2]) {
            swap(data, i, i / 2);
            i = i / 2;
        }
    }

    //TODO:堆排序，不是很理解
    /**
     * 堆排序
     * 时间复杂度：O(nlogN)
     * 空间复杂度：原地排序，空间复杂度O(1)
     * 思路：将下标n的元素与堆顶元素交换，然后堆化
     *      将下标n - 1的元素与上一步堆化后的堆顶元素交换，然后堆化
     *      循环往复执行如上的步骤
     */
    public void sort(){
        int k = count;
        while (k>1){
            swap(data,1,k);
            k--;
            heapify(data,k,1);
        }
    }

    /**
     * 移除堆顶元素
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }

        data[1] = data[count];
        --count;
        heapify(data, count, 1);
    }

    /**
     * 自顶向下堆化(大顶堆)
     *
     * @param data
     * @param n
     * @param i
     */
    private static void heapify(int[] data, int n, int i) {
        while (true) {
            int maxPos = i;

            //当前节点小于左孩子节点，记录交互节点为当前节点和左孩子节点
            if (2 * i <= n && data[i] < data[2 * i]) {
                maxPos = 2 * i;
            }

            //这里比对的是 maxPos和右节点，如果左右孩子节点都不小于当前节点，则maxPos记录为当中的较大者
            if (2 * i + 1 <= n && data[maxPos] < data[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }

            //maxPos == i 说明已满足大顶堆的条件，退出循环
            if (maxPos == i) {
                break;
            }

            //将当前节点与较大的节点交换
            Heap.swap(data, i, maxPos);

            //从新的位置从新开始处理
            i = maxPos;
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

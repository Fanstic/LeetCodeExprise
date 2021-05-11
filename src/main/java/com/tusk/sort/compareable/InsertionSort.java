package com.tusk.sort.compareable;

/**
 * @author tusk
 * @desc 插入排序
 * 整个操作有点类似扑克牌抓牌时的操作
 * 将排序数据分为两个区间，有序区和无序区
 * 核心思想就是在将无序区的元素在有序区找到合适的位置并插入，往复操作直至
 * 所有元素全部有序
 * ======================================
 * 最好时间复杂度：O(n)
 * 最坏时间复杂度:O(n^2)
 * 平均时间复杂度:O(n^2)
 * 空间复杂度：O(1) 原地排序
 * 是否稳定: 稳定
 * <p>
 * =======================================
 * @date 2021/5/11 9:52
 */
public class InsertionSort {
    public void sort(int[] data) {
        int len = data.length;

        if (len > 1) {
            for (int i = 1; i < len; i++) {
                int j = i - 1;
                int val = data[i];

                for (; j >= 0; j--) {
                    //移动数据
                    if (val < data[j]) {
                        data[j + 1] = data[j];
                    }else{
                        break;
                    }
                }
                //数据插入
                data[j + 1] = val;
            }
        }
    }
}

package com.tusk.sort.compareable;

/**
 * @author tusk
 * @desc 冒泡排序
 * <p>
 * 比较相邻的两个元素，如果不满足条件则交换
 * ======================================
 * 最好时间复杂度：O(n)
 * 最坏时间复杂度:O(n^2)
 * 平均时间复杂度:O(n^2)
 * 空间复杂度：O(1) 原地排序
 * 是否稳定: 稳定
 * <p>
 * =======================================
 * @date 2021/5/11 9:19
 */
public class BudbbleSort {

    public void sort(int[] data) {
        int len = data.length;
        boolean flag = false;

        if (len > 1) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len - i - 1; j++) {
                    if (data[j] > data[j + 1]) {
                        int temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;

                        flag = true;
                    }
                }

                if (!flag) {
                    break;
                }
            }
        }
    }
}

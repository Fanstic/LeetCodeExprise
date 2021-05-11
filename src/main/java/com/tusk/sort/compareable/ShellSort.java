package com.tusk.sort.compareable;

import java.util.Arrays;

/**
 * @author tusk
 * @desc 希尔排序, 又称缩小增量排序，是简单插入排序的一种高效改进版本
 *  * ======================================
 *  * 最好时间复杂度：O(n)
 *  * 最坏时间复杂度:O(n^2)
 *  * 平均时间复杂度:O(n^3/2)
 *  * 空间复杂度：O(1) 原地排序
 *  * 是否稳定: 不稳定
 *  * <p>
 *  * =======================================
 * @date 2021/5/11 10:45
 */
public class ShellSort {
    public static void main(String[] args) {
        ShellSort obj = new ShellSort();
        int[] data = {10,7,9,6,3,5,1,4,2,8};
        obj.sort(data);

        System.out.println(Arrays.toString(data));
    }
    public void sort(int[] data) {
        int length = data.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = data[i];
                int j = i - step;
                while (j >= 0 && data[j] > temp) {
                    data[j + step] = data[j];
                    j -= step;
                }

                //元素插入
                data[j + step] = temp;
                System.out.println(Arrays.toString(data));
            }
        }
    }
}

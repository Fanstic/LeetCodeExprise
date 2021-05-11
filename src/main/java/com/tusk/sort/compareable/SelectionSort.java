package com.tusk.sort.compareable;

/**
 * @author tusk
 * @desc 选择排序
 * 选择排序算法的实现思路有点类似插入排序，
 * 也分已排序区间和未排序区间。但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾
 *  * ======================================
 *  * 最好时间复杂度：O(n^2)
 *  * 最坏时间复杂度:O(n^2)
 *  * 平均时间复杂度:O(n^2)
 *  * 空间复杂度：O(1) 原地排序
 *  * 是否稳定: 不稳定
 *  * <p>
 *  * =======================================
 * @date 2021/5/11 11:24
 */
public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        int[] data = {5,8,5,2,9};
        obj.sort(data);

        for (int i : data) {
            System.out.println(i);
        }
    }

    public void sort(int[] data) {
        int len = data.length;

        if (len > 1) {
            for (int i = 0; i < len; i++) {
                int j = i + 1;
                int min = i;
                for (; j < len; j++) {
                    if (data[j] < data[min]) {
                        min = j;
                    }
                }

                if (i != min) {
                    int temp = data[i];
                    data[i] = data[min];
                    data[min] = temp;
                }

            }

        }
    }
}

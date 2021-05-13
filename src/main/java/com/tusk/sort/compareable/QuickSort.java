package com.tusk.sort.compareable;

import java.util.Arrays;

/**
 * @author tusk
 * @desc 快速排序
 * <p>
 * ======================================
 * 最好时间复杂度：O(nlogn)
 * 最坏时间复杂度:O(n^2)
 * 平均时间复杂度:O(nlogn)
 * 空间复杂度：O(1)
 * 是否稳定: 不稳定
 * =======================================
 * </p>
 * @date 2021/5/13 13:43
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] data = {10, 3, 7, 9, 5, 2, 1, 8, 4, 6};
        int[] data2 = {3, 7, 10, 9, 8};

        data = data2;
        obj.quick_sort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    public void sort_recursive(int[] data, int left, int right) {
        if (left >= right)
            return;


        int pivot = partion(data, left, right);
        sort_recursive(data, left, pivot - 1);
        sort_recursive(data, pivot + 1, right);
    }

    public int partion(int[] data, int left, int right) {
        //以 data[left] 为分界点
        int index = left + 1;


        for (int i = index; i <= right; i++) {

            //以 left 为分界点，如果比 data[left] 小则将其放到左侧部分的尾部
            if (data[i] < data[left]) {
                if (i != index) {
                    swap(data, i, index);
                }
                index++;
            }
        }

        //使得 left 左边都是比 data[left] 小的，右边是比它大的
        swap(data, left, index - 1);
        return index - 1;
    }

    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 递归的另外一种解法
     *
     * @param src
     * @param begin
     * @param end
     */
    public void quick_sort(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quick_sort(src, begin, i - 1);
            quick_sort(src, i + 1, end);
        }
    }

}


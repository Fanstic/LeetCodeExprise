package com.tusk.sort.compareable;

import java.util.Arrays;

/**
 * @author tusk
 * @desc 归并排序
 * ======================================
 * 最好时间复杂度：O(nlogn)
 * 最坏时间复杂度:O(nlogn)
 * 平均时间复杂度:O(nlogn)
 * 空间复杂度：O(n)
 * 是否稳定: 稳定
 * <p>
 * =======================================
 * @date 2021/5/12 15:26
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int[] data = {10, 3, 7, 9, 5, 2, 1, 8, 4, 6};
        int[] result = new int[data.length];
        obj.sort_recursive(data, result, 0, data.length - 1);

        System.out.println(Arrays.toString(result));
    }

    /**
     * 递归法
     * @param data
     * @param result
     * @param start
     * @param end
     */
    public void sort_recursive(int[] data, int[] result, int start, int end) {

        if (start >= end) {
            return;
        }
        int len = end - start;
        int mid = (len >> 1) + start;

        int start1 = start;
        int end1 = mid;

        int start2 = mid + 1;
        int end2 = end;

        sort_recursive(data, result, start1, end1);
        sort_recursive(data, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = data[start1] < data[start2] ? data[start1++] : data[start2++];
        }

        //如果前半部分数组不为空，则将其复制到结果数组的尾部
        while (start1 <= end1) {
            result[k++] = data[start1++];
        }

        //如果后半部分数组不为空，则将其复制到结果数组的尾部
        while (start2 <= end2) {
            result[k++] = data[start2++];
        }

        //将结果数组复制到原数组
        for (k = start; k <= end; k++) {
            data[k] = result[k];
        }

    }
}

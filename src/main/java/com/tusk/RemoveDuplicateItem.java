package com.tusk;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * 题号：26 移除有序数组中的重复元素
 *
 * @author tusk
 * @desc 删除有序数组中的重复项
 * 给定一个排序数组，原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
 * @date 2020/11/26 10:58
 */
public class RemoveDuplicateItem {
    /**
     * 移除数组中的重复元素
     * 1. 数组有序，则相同元素一定是相邻的
     * 2.
     *
     * @param arr 有序数组
     * @return 新数组长度
     */
    public static int removeDuplicate(int[] arr) {
        if (arr == null || arr.length < 0) {
            return 0;
        }

        int size = arr.length;

        // 向前移动的指针
        int cursor = 1;
        // 当前元素
        int current = arr[0];
        while (cursor < arr.length) {
            for (int i = cursor; i < arr.length; i++) {
                if (current == arr[cursor]) {
                    if (cursor + 1 < arr.length) {
                        arr[cursor] = arr[cursor + 1];

                    }

                    size--;
                    cursor++;
                } else {
                    current = arr[cursor++];
                }
            }
        }

        return size;
    }

    /**
     * 官方解法，快慢双指针，很巧妙
     * 时间复杂度：O(n),假设数组长度 n，则 i 和 j 遍历最多走 n 步
     * 空间复杂度: O(1)
     *
     * @param arr 有序数组
     * @return 新数组长度
     */
    public static int removeDuplicateImprove(int[] arr) {
        if (arr == null || arr.length < 0) {
            return 0;
        }

        //慢指针
        int i = 0;

        //j 快指针
        for (int j = 1; j < arr.length; j++) {

            //arr[i] 与 arr[j] 不相等时将 arr[j] 复制到 arr[i + 1] 的位置
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        for(int n:arr){
            System.out.println(n);
        }
        return i + 1;

    }
}

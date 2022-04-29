package com.tusk;

import java.util.Arrays;

/**
 * 题号 27，移除元素
 *
 * @author tusk
 * @desc 给定一个数组 nums 和一个值 val，原地移除所有等于 val 的元素，并且返回溢出后数组的长度
 * 元素的顺序可以改变，不需要考虑数组中超出新长度后面的元素
 *
 * 解题思路：双指针，快慢指针
 * @date 2020/12/1 11:06
 */
public class P27_RemoveElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        arr = new int[] {1,3,8,3,6,2};
        int size = removeElementOffice(arr, 3);
        arr = Arrays.copyOf(arr, size);
        for (int e : arr) {
            System.out.println(e);
        }


    }

    /**
     * 移除数组中的指定元素,并返回新数组的长度
     *
     * @param nums 数组
     * @param val  指定元素
     * @return 移除后数组长度
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int size = nums.length;
        int rep = size - 1;

        for (int i = 0; i <= rep; i++) {
            if (nums[i] == val) {
                size--;
                while (nums[i] == nums[rep] && rep > i) {
                    rep--;
                    size--;
                }

                if (nums[i] != nums[rep]) {
                    int tmp = nums[i];
                    nums[i] = nums[rep];
                    nums[rep] = tmp;
                    rep--;
                }

            }
        }
        return size;
    }

    /**
     * 官方解法
     * 时间复杂度 O(n)
     * @param nums 数组
     * @param val 指定元素
     * @return 移除后数组新长度
     */
    public static int removeElementOffice(int[] nums,int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //i表示下一步要赋值的地方，j表示当前处理的位置
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

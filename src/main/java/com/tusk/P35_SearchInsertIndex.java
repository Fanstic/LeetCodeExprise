package com.tusk;

/**
 * 题号35，给定一个有序数组和一个目标值，在数组中找到目标值，并返回索引
 * 如果目标值不存在与数组中，则返回其插入的位置。假设数组中无重复元素
 *
 * @author tusk
 * @desc 搜索插入位置
 * @date 2020/12/3 9:09
 */
public class P35_SearchInsertIndex {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        System.out.println(searchInsert(arr, 4));
    }

    /**
     * 采用 二分查找法
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param nums 有序数组
     * @param target 目标值
     * @return 索引或插入位置
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            //除2可以变为位移运算
            int mid = (l + r)>>1;
            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        //退出循环时 l>r
        if (r < 0) {
            return 0;
        }
        if (nums[r] == target) {
            return r;
        }

        if (target > nums[r]) {
            return r + 1;
        } else {
            return r - 1;
        }
    }
}

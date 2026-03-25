package com.tusk.primary.array;


/**
 * @description: 搜索有序排序数组
 * 33. 搜索旋转排序数组
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * @author: asus
 * @date: 2026年03月25日 13:15
 * @version: 1.0
 */
public class P33_SearchRotateArray {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] < nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


}

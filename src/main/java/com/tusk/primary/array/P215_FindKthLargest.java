package com.tusk.primary.array;

/**
 * @author tusk
 * @desc 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/31 9:50
 */
public class P215_FindKthLargest {
    public static void main(String[] args) {
        int[] data = new int[]{3, 1, 6, 4, 5};
        P215_FindKthLargest obj = new P215_FindKthLargest();
        int k = 1;

        int result = obj.findKthLargest(data, data.length - k + 1);
        System.out.println(result);
    }

    /**
     * 快排思路
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return sort_rec(nums, 0, nums.length - 1, k);
    }


    private int sort_rec(int[] nums, int left, int right, int k) {

        int povit = partion(nums, left, right);
        if (k == povit + 1) {
            return nums[povit];
        } else if (k < povit + 1) {
            return sort_rec(nums, left, povit - 1, k);
        } else {
            return sort_rec(nums, povit + 1, right, k);
        }
    }

    private int partion(int[] nums, int left, int right) {
        int povit = nums[right];
        int index = left;
        for (int i = index; i <= right; i++) {
            if (nums[i] < povit) {
                swap(nums, i, index);
                index++;
            }

        }

        swap(nums, index, right);
        return index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package com.tusk.primary.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tusk
 * @desc leetcode-503:下一个更大的元素II
 * 解题思路：单调栈，存在循环数组的情况
 * <p>
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/15 10:19
 */
public class P503_NextGreaterElements {
    public static void main(String[] args) {
        P503_NextGreaterElements obj = new P503_NextGreaterElements();
        int[] nums = new int[]{1, 2, 1};

        System.out.println(Arrays.toString(obj.nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }

        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] result = new int[nums.length];

        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }

            result[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }

        return result;
    }
}

package com.tusk;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 *
 * @author tusk
 * @desc
 * @date 2020/12/11 10:30
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int[] arr1 = {1, 0, 1};

        int[] arg = arr1;
        moveZeroesV1(arg);

        for (int n : arg) {
            System.out.print(n + " ");
        }
    }

    /**
     * 思路：
     * 遍历nums,如果当前元素不为0，则与当前元素最前面的0交换位置
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums != null && nums.length > 1) {
            int cursor = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != 0) {
                    while (cursor < i && nums[cursor] != 0) {
                        cursor++;
                    }

                    if (nums[cursor] == 0) {
                        int tmp = nums[cursor];
                        nums[cursor] = nums[i];
                        nums[i] = tmp;
                    }
                }
            }
        }
    }

    /*
     * 把非0的往前挪，挪完之后，后面的就都是0了，然后在用0覆盖后面的。
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/san-chong-fang-shi-jie-jue-du-ji-bai-liao-100de-yo/
     */
    public static void moveZeroesV1(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int index = 0;
        //一次遍历，把非零的都往前挪
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        //后面的都是0,
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 双指针解法
     * https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode-solution/
     *
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 注意到以下性质：
     * 左指针左边均为非零数；
     * 右指针左边直到左指针处均为零。
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     * @param nums
     */
    public static void moveZeroesV2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }
}


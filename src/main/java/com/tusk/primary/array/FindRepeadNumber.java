package com.tusk.primary.array;

/*
剑指 Offer 03. 数组中重复的数字
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
 

限制：

2 <= n <= 100000

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeadNumber {
    public static void main(String[] args) {
        FindRepeadNumber obj = new FindRepeadNumber();

        int[] nums = new int[]{2, 3};
        int num = obj.findRepeatNumber(nums);
        System.out.println(num);
    }

    /**
     * 这个问题比较直观的解法有两种，
     * 第一种就是对数组排序，如果第n个元素等于n+1个元素，那么返回第n个元素即可，排序的时间复杂度为 nLog(N)
     * 第二种就是使用一个map，统计记录每一个num出现的次数，当遇到count(num)>1的元素时返回该元素，此时，空间复杂度和时间复杂度都是O(n)
     * <p>
     * 这里说一种非常规的空间复杂度为O(1)的解法，n个元素的数组，元素取值范围 0~n-1，如果不存在重复元素的前提下，则排序后标为i的位置的元素也是i，
     * 这也是解决这个问题的一个重要的条件
     * <p>
     * <p>
     * 思考问题时可以采用测试驱动的方式逆向的来编码，也即写代码前，先想场景下的测试用例，然后根据测试用例，反向的转换为代码
     * 这个场景下的 test-case
     * 1.输入空数组或空指针不报错
     * 2.数组中存在不符合条件的元素能正常运行
     * 3.数组中存在重复元素
     * 4.数组中不存在重复元素
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        //如果存在小于0或大于nums.length-1的值，则会发送数组越界的问题
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                return -1;
            }
        }

        int i = 0;
        while (i < nums.length) {

            int j = nums[i];

            //索引位置的数和索引值不相等
            if (j != i) {
                //判断j位置的数是否为j,如果是j,就说明j存在重复
                if (nums[j] == j) {
                    return j;
                } else {
                    //如果j位置的数不为j,就将i位置的数和j位置的数交换位置
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            } else {
                i++;
            }
        }

        return -1;
    }
}

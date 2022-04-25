package com.tusk.bit;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 * <p>
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 4：
 * <p>
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 *  
 * <p>
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P268_MissingNumber {
    public static void main(String[] args) {
        P268_MissingNumber obj = new P268_MissingNumber();
        int[] nums = new int[]{1, 0};

        System.out.println(obj.missingNumber(nums));

    }

    /**
     * 1. 异或运算满足交互律和结合律
     * 2. 任何数与本身异或，结果为0
     * 3. 任何数与0异或，结果为本身
     * <p>
     * 利用上面的结论来解决这个问题
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int res = 0;
        //先于最后的一个元素做异或
        res ^= n;

        //如果所有元素都存在的情况下，异或的情况应该为0
        //如果有缺失的话，最终的结果便是缺失的哪一个
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }

        return res;
    }
}

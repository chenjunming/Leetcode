package cn.cjm.leetcode;

import org.junit.Test;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Code_53MaxSubArray {
    public int maxSubArray(int[] nums) {
        // dp[i][j] 表示[i,j]子数组的值
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
            max = max < dp[i][i] ? dp[i][i] : max;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = dp[i][j - 1] + dp[j][j];
                max = max < dp[i][j] ? dp[i][j] : max;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i] + sum,nums[i]);
            max = max < sum ?sum:max;
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {-2, -1};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }
}

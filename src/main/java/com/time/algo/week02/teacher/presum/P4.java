package com.time.algo.week02.teacher.presum;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 */
public class P4 {


    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum > 0) {
                nums[i] += preSum;
            }
            ans = Math.max(ans, nums[i]);
            preSum = nums[i];
        }
        return ans;
    }


}

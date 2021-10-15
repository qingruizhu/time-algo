package com.time.algo.week.b;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class B4 {


    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int count = 0;
        Map<Integer, Integer> ans = new HashMap<Integer, Integer>();
        ans.put(0, 1);
        for (int num : nums) {
            preSum += num;
            if (ans.containsKey(preSum - k)) {
                count += ans.get(preSum - k);
            }
            //
            ans.put(preSum, ans.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

}

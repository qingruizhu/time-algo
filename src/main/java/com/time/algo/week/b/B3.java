package com.time.algo.week.b;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074. 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * <p>
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * <p>
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 */
public class B3 {


    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int ans = 0;
        // 二维转一维,枚举行
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = new int[matrix[0].length];
            for (int j = i; j >= 0; j--) {
                for (int k = 0; k < matrix[0].length; k++) {
                    arr[k] += matrix[j][k];
                }
                ans += subarraySum(arr, target);
            }
        }
        return ans;
    }

    // 一维
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

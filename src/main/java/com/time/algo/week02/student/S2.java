package com.time.algo.week02.student;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 */
public class S2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1};
        int ans = findShortestSubArray(arr);
        System.out.println(ans);
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!ans.containsKey(num)) {
                int[] arr = new int[3];
                arr[0] = 1;
                arr[1] = i;
                arr[2] = i;
                ans.put(num, arr);
            } else {
                int[] extArr = ans.get(num);
                extArr[0]++;
                extArr[2] = i;
                ans.put(num, extArr);
            }
        }
        Set<Map.Entry<Integer, int[]>> entries = ans.entrySet();
        int max = 0;
        int du = 0;
        for (Map.Entry<Integer, int[]> entry : entries) {
            int[] arr = entry.getValue();
            int count = arr[0];
            int curDu = arr[2] - arr[1] + 1;
            if (count > max) {
                max = count;
                du = curDu;
            } else if (count == max) {
                if (curDu < du) {
                    du = curDu;
                }
            }
        }
        return du;

    }


}

package com.time.algo.week03.student;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class S2 {


    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private List<Integer> temp = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int pos) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }


            temp.add(nums[i]);
            used[i] = true;
            recur(nums, pos + 1);
            //恢复
            used[i] = false;
            temp.remove(temp.size() - 1);

        }

    }
}

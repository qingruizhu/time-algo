package com.time.algo.week03.teacher.recu;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class R3 {


    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private List<Integer> temp = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
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
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                recur(nums, pos + 1);
                //恢复
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }
}

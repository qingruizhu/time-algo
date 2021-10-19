package com.time.algo.week03.teacher.recu;


import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class R2 {


    private List<Integer> tmp = new ArrayList<Integer>();
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();


    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }


    private void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (tmp.size() + (n - cur + 1) < k) {
            return;
        }
        //
        if (tmp.size() == k) {
            ans.add(new ArrayList<Integer>(tmp));
            return;
        }
        //要
        tmp.add(cur);
        dfs(cur + 1, n, k);
        //不要
        tmp.remove(tmp.size() - 1);
        dfs(cur + 1, n, k);
    }
}

package com.time.algo.week03.teacher.recu;


import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class R1 {

    private List<Integer> tmp = new ArrayList<Integer>();
    private  List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return ans;
    }


    private void dfs(int n,int[] nums){
        //
        if(n==nums.length){
            ans.add(new ArrayList<Integer>(tmp));
            return;
        }
        //要
        tmp.add(nums[n]);
        dfs(n+1,nums);
        //不要
        tmp.remove(tmp.size()-1);
        dfs(n+1,nums);
    }


}

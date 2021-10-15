package com.time.algo.week02.teacher.map;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class M3 {


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = String.valueOf(charArray);
            if (!ans.containsKey(sortStr)) {
                List<String> lst = new ArrayList<>();
                lst.add(str);
                ans.put(sortStr, lst);
            } else {
                ans.get(sortStr).add(str);
            }
        }
        return new ArrayList(ans.values());
    }

}

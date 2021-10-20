package com.time.algo.week03.teacher.separate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 */
public class S2 {


    public List<String> generateParenthesis(int n) {

        // s=(A)B
        if (n == 0) {
            return Arrays.asList("");
        }
        List<String> ans = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            List<String> a = generateParenthesis(i - 1);
            List<String> b = generateParenthesis(n - i);
            for (String s1 : a) {
                for (String s2 : b) {
                    ans.add("(" + s1 + ")" + s2);
                }
            }
        }
        return ans;
    }
}

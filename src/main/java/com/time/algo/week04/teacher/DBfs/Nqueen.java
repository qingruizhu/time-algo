package com.time.algo.week04.teacher.DBfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 */
public class Nqueen {


    public static void main(String[] args) {
        Nqueen nqueen = new Nqueen();
        List<List<String>> lists = nqueen.solveNQueens(4);
        System.out.println(lists.size());
    }

    private int n;
    private List<Integer> tmp;
    private List<List<Integer>> ans;
    //同列攻击
    private boolean[] used;
    //  \对角线攻击 i-j相等
    private Map<Integer, Boolean> minUsed;
    // /对角线攻击 i+j相等
    private Map<Integer, Boolean> plusUsed;


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.tmp = new ArrayList<>();
        this.ans = new ArrayList<>();
        this.used = new boolean[n];
        minUsed = new HashMap<>();
        plusUsed = new HashMap<>();

        for (int i = 0; i < n; i++) {
            used[i] = false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minUsed.put(i - j, false);
                plusUsed.put(i + j, false);
            }
        }
        dfs(0);
        List<List<String>> rs = new ArrayList<>();
        for (List<Integer> lst : ans) {
            List<String> strLst = new ArrayList<>();
            for (int pos : lst) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == pos) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                strLst.add(sb.toString());
            }
            rs.add(strLst);
        }
        return rs;
    }

    private void dfs(int row) {
        if (row == n) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int colum = 0; colum < n; colum++) {
            if (!used[colum] && !plusUsed.get(row + colum) && !minUsed.get(row - colum)) {
                tmp.add(colum);
                used[colum] = true;
                plusUsed.put(row + colum, true);
                minUsed.put(row - colum, true);
                dfs(row + 1);
                minUsed.put(row - colum, false);
                plusUsed.put(row + colum, false);
                used[colum] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

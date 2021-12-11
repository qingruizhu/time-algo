package com.time.algo.week04.teacher.DfsBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 329. 矩阵中的最长递增路径
 * 难度
 * 困难
 * <p>
 * 556
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * @Auther: qingruizhu
 * @Date: 2021/12/5 11:29
 */
public class MatrixIncr {

    public static void main(String[] args) {
        int[][] test = {{9, 9,}, {6, 6, 8}, {2, 1, 1}};
        int i = longestIncreasingPath(test);
        System.out.println(i);
    }


    static int m;//行
    static int n;//列
    static List<Integer>[] to;//边
    static int[] deg;//入度
    //static Map<Integer, Integer> dist;//深度

    public static int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        to = new ArrayList[m * n];
        for (int i = 0; i < m * n; i++) {
            to[i] = new ArrayList<>();
        }
        deg = new int[m * n];
        // 方向
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        //
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int ni = i + dx[k];// x方向移动
                    int nj = j + dy[k];// y方向移动
                    //如果递增，连边
                    if (valid(ni, nj) && matrix[ni][nj] > matrix[i][j]) {
                        addEdge(num(i, j), num(ni, nj));
                    }
                }
            }
        }
        int[] dist = new int[m * n];//深度
        // 找到所有的0度点,出发
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < m * n; i++) {
            if (deg[i] == 0) {//入度为0
                q.add(i);
                dist[i] = 1;
            }
        }
        while (!q.isEmpty()) {
            Integer x = q.pop();
            for (int y : to[x]) {
                deg[y]--;
                dist[y] = Math.max(dist[y], dist[x] + 1);
                if (deg[y] == 0) {
                    q.add(y);
                }
            }
        }
        int ans = 0;
        for (Integer val : dist) {
            ans = Math.max(ans, val);
        }
        return ans;
    }

    private static void addEdge(int u, int v) {
        deg[v]++;
        //to.getOrDefault(u, new ArrayList<>()).add(v);
        to[u].add(v);

    }

    private static int num(int i, int j) {
        return i * n + j;
    }

    // 验证格子有效
    private static boolean valid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

}

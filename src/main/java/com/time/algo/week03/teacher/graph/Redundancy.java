package com.time.algo.week03.teacher.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 684. 冗余连接
 * 树可以看成是一个连通且 无环 的 无向 图。
 * <p>
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * <p>
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: edges = [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 */
public class Redundancy {

    private List<Integer>[] to;

    public int[] findRedundantConnection(int[][] edges) {

        int n = 0;
        for (int[] edg : edges) {
            int x = edg[0];
            int y = edg[1];
            n = Math.max(n, Math.max(x, y));
        }
        to = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int[] edg : edges) {
            int x = edg[0];
            int y = edg[1];
            if (to[x] == null) {
                to[x] = new ArrayList<Integer>();
            }
            if (to[y] == null) {
                to[y] = new ArrayList<Integer>();
            }
            to[x].add(y);
            to[y].add(x);
            hasCycle = false;
            // 恢复访问
            for (int i = 1; i <= n; i++) {
                visited[i] = false;
            }
            dfs(x, 0);
            if (hasCycle) {
                return edg;
            }
        }
        return new int[2];
    }

    private boolean[] visited;
    private boolean hasCycle;

    // 深度遍历判断图中的环
    private void dfs(int x, int fa) {
        visited[x] = true;
        for (int y : to[x]) {
            if (y == fa) continue;
            if (!visited[y]) {
                dfs(y, x);
            } else {
                hasCycle = true;
            }
        }
    }
}

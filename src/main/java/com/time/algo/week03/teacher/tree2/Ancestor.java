package com.time.algo.week03.teacher.tree2;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */
public class Ancestor {

    private TreeNode p;
    private TreeNode q;
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        this.p = p;
        this.q = q;
        dfs(root);
        return ans;
    }

    private boolean[] dfs(TreeNode node) {
        if (node == null) {
            boolean[] arr = new boolean[2];
            arr[0] = false;
            arr[1] = false;
            return arr;
        }
        boolean[] bLeft = dfs(node.left);
        boolean[] bRight = dfs(node.right);
        boolean[] bAns = new boolean[2];
        bAns[0] = bLeft[0] || bRight[0] || node.val == p.val;
        bAns[1] = bLeft[1] || bRight[1] || node.val == q.val;
        if (bAns[0] && bAns[1] && ans == null) {
            ans = node;
        }
        return bAns;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

package com.time.algo.week03.teacher.tree;


/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3
 */
public class T3 {


    private int count;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return count;
    }

    private void dfs(TreeNode node, int curt) {
        if (node == null) {
            count = Math.max(count, curt);
            return;
        }
        curt++;
        dfs(node.left, curt);
        dfs(node.right, curt);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

package com.time.algo.week03.teacher.tree1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 297. 二叉树的序列化与反序列化
 * 难度
 * 困难
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * @Auther: qingruizhu
 * @Date: 2021/10/24 18:34
 */
public class TreeSerialize {
    public static void main(String[] args) {
        List[] nav = new ArrayList[10];
        nav[1].add(1);
        System.out.println(nav);
    }

    public String serialize(TreeNode root) {

        // 1 2 null null 3 4 null null 5 null null
        List<String> ans = new ArrayList<String>();
        dfs(root, ans);
        return String.join(",", ans);
    }

    private void dfs(TreeNode node, List<String> ans) {
        if (node == null) {
            ans.add("null");
            return;
        }
        ans.add(String.valueOf(node.val));
        dfs(node.left, ans);
        dfs(node.right, ans);
    }


    //
    private String[] seq;
    private int cur;

    public TreeNode deserialize(String data) {
        seq = data.split(",");
        cur = 0;
        return helpDes();
    }

    private TreeNode helpDes() {
        if (seq[cur].equals("null")) {
            cur++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(seq[cur]));
        cur++;
        root.left = helpDes();
        root.right = helpDes();
        return root;
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

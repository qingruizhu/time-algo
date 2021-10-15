package com.time.algo.week02.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 811. 子域名访问计数
 * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 * <p>
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 * <p>
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 * <p>
 * 示例 1:
 * 输入:
 * ["9001 discuss.leetcode.com"]
 * 输出:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * 说明:
 * 例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
 */
public class S1 {

    public static void main(String[] args) {
        String[] test = {"9001 discuss.leetcode.com"};
        List<String> ans = subdomainVisits(test);
        System.out.println(ans);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> ans = new HashMap<String, Integer>();
        for (String str : cpdomains) {
            String[] strArray = str.split(" ");
            int count = Integer.parseInt(strArray[0]);
            String domain = strArray[1];
            String[] domains = domain.split("\\.");
            //
            ans.put(domain, ans.getOrDefault(domain, 0) + count);
            if (domains.length == 2) {
                // leetcode.com
                ans.put(domains[1], ans.getOrDefault(domains[1], 0) + count);
            } else if (domains.length == 3) {
                // discuss.leetcode.com
                ans.put(domains[1] + "." + domains[2], ans.getOrDefault(domains[1] + "." + domains[2], 0) + count);
                ans.put(domains[2], ans.getOrDefault(domains[2], 0) + count);
            }
        }
        return ans.entrySet().stream().map(entry -> {
            return entry.getValue() + " " + entry.getKey();
        }).collect(Collectors.toList());
    }
}

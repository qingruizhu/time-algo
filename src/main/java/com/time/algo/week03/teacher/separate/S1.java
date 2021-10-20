package com.time.algo.week03.teacher.separate;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class S1 {

    public double myPow(double x, int n) {
        // 分治 x^n= (x^2/n)*(x^2/n)
        if (n == 0) {
            return 1.0;
        }
        if (n == -(1 << 31)) {
            return 1.0 / (myPow(x, -(n + 1)) * x);
        }
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }

        double ans = myPow(x, n / 2);
        ans *= ans;
        if (n % 2 != 0) {
            ans *= x;
        }
        return ans;

    }


}

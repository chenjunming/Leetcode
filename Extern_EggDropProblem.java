package cn.cjm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定N个鸡蛋和k层楼，试问至少需要几次才能确定鸡蛋从哪一层楼掉下去恰好摔碎。
 */
public class Extern_EggDropProblem {
    /**
     * 暴力递归
     *
     * @param n 鸡蛋个数
     * @param k 剩余楼层数
     * @return
     */
    public int eggDrop(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {// 从第一层开始尝试扔鸡蛋
            // 摔破（下）和不摔破（上）比较次数
            int cur = 1 + Math.max(eggDrop(n - 1, i - 1), eggDrop(n, k - i));
            if (cur < result) {
                result = cur;
            }
        }
        return result;
    }

    /**
     * 由于 使用暴力递归的方式 时间复杂度过于恐怖，这里可以改成动态规划
     *
     * @param n 鸡蛋的个数
     * @param k 剩余的楼层数
     * @return
     */
    public int eggDropWithDP(int n, int k) {
        // 横坐标为鸡蛋的个数，纵坐标为剩余楼层数
        // 第一步永远是创建动态规划的备忘录，也叫状态转移矩阵
        // 记住：二维数组里的length 是 0-start 的，又因为包含层数为0或鸡蛋为0 的情况，所以定义行和列的时候要+1！！！
        int[][] dp = new int[n + 1][k + 1];
        //处理边界
        // 1. 鸡蛋或者层数为0或1的情况
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 0;
            dp[1][j] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                int min = Integer.MAX_VALUE;
                for (int drop = 1; drop <= j; drop++) {
                    int tmp = 1 + Math.max(dp[i - 1][drop - 1], dp[i][j - drop]);
                    min = Math.min(min,tmp);
                }
                dp[i][j] = min;
            }
        }
        for (int i = 0; i <= n; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][k];
    }

    @Test
    public void test() {
        int i = eggDrop(2, 8);
        System.out.println(eggDropWithDP(2,100));
        System.out.println(i);
    }
}

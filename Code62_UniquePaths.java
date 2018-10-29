package cn.cjm.leetcode;

import org.junit.Test;

/**
 *  一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */
public class Code62_UniquePaths {
    @Test
    public void test(){
        int m = 3,n=2;
        int uniquePaths = uniquePaths(m, n);
        System.out.println(uniquePaths);
        System.out.println(uniquePaths2(m,n));
    }
    // 暴力递归
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n<=0){
            return 0;
        }
        if(m == 1 && n==1){
            return 1;
        }
        int counter = 0;
        // 右
        counter += uniquePaths(m,n-1);
        // 下
        counter += uniquePaths(m-1,n);

        return counter;
    }

    // dp ，val 表示 i ,j 有多少种路径
    // dp[i][j] = dp[i-1][j] +dp[i][j-1]
    public int uniquePaths2(int m, int n){
        if(m <= 0 || n<=0){
            return 0;
        }
        if(m == 1 && n==1){
            return 1;
        }
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1;i<m+1;i++){
            dp[i][1] = 1;
        }
        for(int j=1 ;j<n+1;j++){
            dp[1][j] = 1;
        }
        for(int i = 2;i<m+1;i++){
            for(int j = 2;j<n+1;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}

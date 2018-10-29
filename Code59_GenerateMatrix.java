package cn.cjm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Code59_GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int len = n*n;
        int count = 1;
        int[][] result = new int[n][n];
        int x1 = 0,y1 = 0;
        int x2 = n-1,y2 = n-1;
        generate(result, x1, y1, x2, y2, count);
        return result;
    }

    private void generate(int[][] result, int x1, int y1, int x2, int y2, int count) {
        if(x1 > x2 && y1 >y2){
            return;
        }
        if(x1 == x2){
            result[x1][y1] = count++;
            return;
        }
        // 第一行
        int i = y1;
        while(i <y2){
            result[x1][i++] = count++;
        }
        i = x1;
        // 最后一列
        while(i<x2){
            result[i++][y2] = count++;
        }
        // 最后一行
        i = y2;
        while(i > y1){
            result[x2][i--] = count++;
        }
        // 第一列
        i = x2;
        while(i > x1){
            result[i--][y1] = count++;
        }
        generate(result,++x1,++y1,--x2,--y2,count);
    }
    @Test
    public void test(){
        int n = 5;
        int[][] ints = generateMatrix(n);
        for(int i = 0;i<ints.length;i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}

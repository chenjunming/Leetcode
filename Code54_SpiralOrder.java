package cn.cjm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Code54_SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        // 单行
        if(matrix.length == 1){
            ArrayList<Integer> result = new ArrayList<>();
            for(int j = 0;j<matrix[0].length;j++){
                result.add(matrix[0][j]);
            }
            return result;
        }
        // 单列
        if(matrix[0].length == 1){
            ArrayList<Integer> result = new ArrayList<>();
            for(int i = 0;i<matrix.length;i++){
                result.add(matrix[i][0]);
            }
            return result;
        }
        return process(matrix,0,0,matrix.length-1,matrix[0].length-1);
    }

    private List<Integer> process(int[][] matrix, int leftx, int lefty, int rightx, int righty) {
        if(leftx > matrix.length || lefty > matrix[0].length ||  rightx < 0 || righty < 0||leftx >rightx || lefty > righty){
            return new ArrayList<>();
        }
        if(leftx == rightx && lefty == righty){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(matrix[leftx][lefty]);
            return result;
        }
        // 单行
        if(leftx == rightx){
            ArrayList<Integer> result = new ArrayList<>();
            for(int j = lefty;j<=righty;j++){
                result.add(matrix[leftx][j]);
            }
            return result;
        }
        // 单列
        if(lefty == righty){
            ArrayList<Integer> result = new ArrayList<>();
            for(int i = leftx;i<=rightx;i++){
                result.add(matrix[i][lefty]);
            }
            return result;
        }

        ArrayList<Integer> result = new ArrayList<>();
        // 第一行(不包含最后一个）
        for(int j = lefty;j<righty;j++){
            result.add(matrix[leftx][j]);
        }
        // 最后一列（不包含最后一个
        for(int i = leftx;i<rightx;i++){
            result.add(matrix[i][righty]);
        }
        //最后一行（右到左）
        for(int j = righty;j>lefty;j--){
            result.add(matrix[rightx][j]);
        }
        // 第一列（从下到上）
        for(int i = rightx;i>leftx;i--){
            result.add(matrix[i][lefty]);
        }
        List<Integer> list = process(matrix, leftx + 1, lefty + 1, rightx - 1, righty - 1);
        result.addAll(list);
        return result;
    }
    @Test
    public void test(){
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder(nums);
        System.out.println(Arrays.toString(list.toArray()));
    }

}

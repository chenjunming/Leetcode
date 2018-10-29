package cn.cjm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Code46_Permute {
    // 利用划分子问题的方法，缩小规模
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        if(nums.length == 1){
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        return process(nums,0,nums.length-1);
    }

    private List<List<Integer>> process(int[] nums, int start, int end) {
        if(nums == null || nums.length == 0){
            return null;
        }
        if(start > end){
            return new ArrayList<>();
        }
        if(start == end){
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums[start]);
            result.add(list);
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = start ;i <= end;i++){
            swap(nums,start,i);
            List<List<Integer>> listList = process(nums, start + 1, end);
            for(List<Integer> list:listList){
                list.add(nums[start]);
            }
            result.addAll(listList);
            swap(nums,start,i);
        }

        return result;
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4};
        List<List<Integer>> permute = permute(nums);
        for(int i =0;i<permute.size();i++) {
            System.out.println(Arrays.toString(permute.get(i).toArray()));
        }
    }
}

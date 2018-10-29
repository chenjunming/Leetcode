package cn.cjm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Code78_SubSet {
    @Test
    public void test(){
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for(List<Integer> list:subsets){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        int index = 0;
        int[] pos = new int[nums.length];
        List<List<Integer>> result = process(nums,index,pos);
        return result;
    }

    private List<List<Integer>> process(int[] nums, int index,int[] pos) {
        if(index > nums.length){
            return new ArrayList<>();
        }
        if(index == nums.length){
            // 结算
            ArrayList<List<Integer>> result = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                if(pos[i] == 1){
                    list.add(nums[i]);
                }
            }
            result.add(list);
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        // index 不选或选
        int[] copy1 = Arrays.copyOf(pos, pos.length);
        copy1[index] = 0;
        result.addAll(process(nums,index+1,copy1));
        // 选
        int[] copy2 = Arrays.copyOf(pos,pos.length);
        copy2[index] = 1;
        result.addAll(process(nums,index+1,copy2));
        return result;
    }
}

package cn.cjm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Code16_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int mostNear = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            int start = i +1;
            int end = nums.length - 1;
            while(end >start) {
                int total = nums[i] + nums[start] + nums[end];
                if (mostNear == Integer.MAX_VALUE || Math.abs(mostNear - target) > Math.abs(total - target)) {
                    mostNear = total;
                }
                if(mostNear == target){
                    return mostNear;
                }else if(total > target){// 比想要的数大
                    end--;
                }else{
                    start++;
                }
            }

        }
        return mostNear;
    }
    @Test
    public void test(){
        int[] nums = {1,2,4,8,16,32,64,128};
        int target = 82;
        System.out.println(threeSumClosest(nums,target));
    }
}

package cn.cjm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Code33_SearchRotateSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        return mySearch(nums, target, start, end);
    }

    private int mySearch(int[] nums, int target, int start, int end) {
        if(start < 0 || end <0){
            return -1;
        }
        // 处理边界
        if (end < start) {
            return -1;
        }
        if (end == start) {
            return nums[start] == target ? start : -1;
        }
        int mid = (end + start) / 2;
        if (nums[mid] > nums[end]) {
            // 左边有序，右边无序
            int result = -1;
            if (target <= nums[mid] && target >= nums[start]) {
                result = Arrays.binarySearch(nums, start, mid + 1, target);
                if(result <0){
                    result = -1;
                }
            } else {
                result = mySearch(nums, target, mid + 1, end);
            }
            return result;
        }else{
            // 左边无序，右边有序
            int result = -1;
            if(target <= nums[end] && target >= nums[mid]){
                result = Arrays.binarySearch(nums,mid,end+1,target);
                if(result <0){
                    result = -1;
                }
            }else{
                result = mySearch(nums,target,start,mid-1);
            }
            return result;
        }

    }
    @Test
    public void test(){
        int[] array = {1,3};
        System.out.println(search(array,2));
    }
}

package cn.cjm.leetcode;

import org.junit.Test;


// 两个排序数组的中位数
public class Code04_FindMedianSortedArrays {
    static class ReturnType {
        boolean is1;
        int index;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 1) return nums2[0];
        if(nums2.length == 0 && nums1.length == 1) return nums1[0];

        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int midIndex = (num1Length + num2Length) / 2;// 从0开始
        boolean isOdd = true;
        if(((num1Length + num2Length) & 1) ==0){
            // 偶数
            isOdd = false;
        }
        int i =0,j = 0,count = -1;
        ReturnType firstReturn = new ReturnType();
        ReturnType secondReturn = new ReturnType();
        while(i < num1Length && j < num2Length && midIndex > count){
            if(nums1[i] > nums2[j]){
                j++;
                count++;
                if(midIndex == count){
                    // 结束，记住当前位置
                    firstReturn.index = j-1;
                    firstReturn.is1 = false;
                }else if(!isOdd){
                    // 偶数需要记住前一个
                    secondReturn.index = j-1;
                    secondReturn.is1 = false;
                }
            }else{
                i++;
                count++;
                if(midIndex == count){
                    // 结束，记住当前位置
                    firstReturn.index = i-1;
                    firstReturn.is1 = true;
                } else if(!isOdd){
                    // 偶数需要记住前一个
                    secondReturn.index = i-1;
                    secondReturn.is1 = true;
                }
            }
        }

        // 数组中剩余的数遍历
        if(count != midIndex){
            while( i<num1Length && midIndex >count){
                i++;
                count++;
                if(midIndex == count){
                    // 结束，记住当前位置
                    firstReturn.index = i-1;
                    firstReturn.is1 = true;
                } else if(!isOdd){
                    // 偶数需要记住前一个
                    secondReturn.index = i-1;
                    secondReturn.is1 = true;
                }
            }
            while(j < num2Length && midIndex > count){
                j++;
                count++;
                if(midIndex == count){
                    // 结束，记住当前位置
                    firstReturn.index = j-1;
                    firstReturn.is1 = false;
                } else if(!isOdd){
                    // 偶数需要记住前一个
                    secondReturn.index = j-1;
                    secondReturn.is1 = false;
                }
            }
        }
        double result = 0;
        result += firstReturn.is1?nums1[firstReturn.index]:nums2[firstReturn.index];
        if(!isOdd){
            result += secondReturn.is1?nums1[secondReturn.index]:nums2[secondReturn.index];
            return result/2.0;
        }
        return result;

    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        double mid = 0;  double pre = 0;  int idx1 = 0;  int idx2 = 0; //line 1

        if(nums1.length == 0 && nums2.length == 1) return nums2[0]; //line 2
        if(nums2.length == 0 && nums1.length == 1) return nums1[0]; //line 3

        for(int i = 0; i<(nums1.length + nums2.length + 3)/2; i++){ //line 4
            pre = mid; //line 5
            if(idx1 == nums1.length) mid = nums2[idx2++]; //line 6
            else if(idx2 == nums2.length) mid = nums1[idx1++]; //line 7
            else if(nums1[idx1] <= nums2[idx2]) mid = nums1[idx1++]; //line 8
            else if(nums1[idx1] > nums2[idx2]) mid = nums2[idx2++]; //line 9
        }
        return (nums1.length + nums2.length)%2 == 1? pre : (pre + mid)/2; //line 10
    }
    @Test
    public void test(){
        int[] num1 = {1,3};
        int[] num2 = {};
        System.out.println(findMedianSortedArrays(num1,num2));
        System.out.println(findMedianSortedArrays2(num1,num2));
    }
}

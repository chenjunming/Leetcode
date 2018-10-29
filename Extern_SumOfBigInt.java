package cn.cjm.leetcode;

import org.junit.Test;

/**
 * 大整数求和
 */
public class Extern_SumOfBigInt {

    private String sumOfBigInt(String num1,String num2){
        if(num1 == null || num2 == null || num1.length() ==0|| num2.length() == 0){
            return "";
        }
        int n = num1.length();
        int m = num2.length();
        // 必须保证num1.len > num2.len
        if(n < m){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
            int tmpInt = n;
            n = m;
            m = tmpInt;
        }
        // 记录各位的值
        int[] pos = new int[n+1];
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int i = n-1,j=m-1,p=n;
        while(i >= 0 && j >=0){
            int sum = (array1[i--] - '0') + (array2[j--]-'0');
            sum += pos[p];
            pos[p] = sum % 10;
            pos[p-1] = sum/10;
            p--;
        }
        while(i >= 0){
            int sum = (array1[i--]-'0') + pos[p];
            pos[p] = sum % 10;
            pos[p-1] = sum / 10;
            p--;
        }
        // pos[] 转成字符串
        StringBuilder result = new StringBuilder("");
        p = 1;
        if(pos[0] != 0){
            result.append(pos[0]);
        }
        while(p < pos.length){
            result.append(pos[p++]);
        }
        return result.toString();
    }

    @Test
    public void test(){
        String num1 = "4738463278423";
        String num2 = "3872843782648923649";
        String s = sumOfBigInt(num1, num2);
        System.out.println(s);
    }
}

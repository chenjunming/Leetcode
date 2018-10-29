package cn.cjm.leetcode;

import org.junit.Test;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Code43_Multiply {
    // 模仿手写乘法方式
    public String multiply(String num1, String num2) {
        int m = num1.length(),n = num2.length();
        int[] pos = new int[m+n];// 存放结果
        for(int i = m-1;i >= 0;i--){
            for(int j = n-1;j >= 0;j--){
                int sum = (num1.charAt(i) - '0')*(num2.charAt(j)-'0');
                int pre = i+j,cur = i+j+1;
                sum += pos[cur];
                pos[cur] = sum%10;
                pos[pre] += sum/10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        boolean flag = false;
        for(int i =0;i<pos.length;i++){
            if(pos[i] != 0) {
                stringBuilder.append(pos[i]);
                flag = true;
            }else if(flag){
                stringBuilder.append(pos[i]);
            }else{
                continue;
            }
        }
        if(!flag){
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    @Test
    public void test(){
        String str1 = "9382";
        String str2 = "1893";
        System.out.println(multiply(str1,str2));
    }
}

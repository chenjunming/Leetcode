package cn.cjm.leetcode;

import org.junit.Test;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Code61_RotateRightList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        // k 是非负数
        if(k == 0 || head == null){
            return head;
        }
        // 遍历list
        ListNode p1 = head;
        int len = 0;
        while(p1 != null){
            len++;
            p1 = p1.next;
        }
        if(len == 1){
            return head;
        }
        // 实际等价的右移位数
        int real = k % len;
        if(real ==0){
            return head;
        }
        ListNode p2 = head;
        p1 = head;
        // p1 先走real步，p2 后走，当p1 到null ，p2所在的list后面就是旋转的链表的起点
        while(real != 0){
            p1 = p1.next;
            real--;
        }
        ListNode pre = null;
        while(p1 != null){
            p1 = p1.next;
            pre = p2;
            p2 = p2.next;
        }
        // 拼接链表
        pre.next = null;
        ListNode newHead = p2;
        while(p2.next != null){
            p2 = p2.next;
        }
        p2.next = head;
        return newHead;
    }
    @Test
    public void test(){

    }
}

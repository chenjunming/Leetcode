package cn.cjm.leetcode;

import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Code23_MergeKList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        boolean haveNode = true;
        ListNode result = null,p=null;

        while (haveNode) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }
            // 删除index 位置的list 的头结点
            if (index != -1) {
                if(result == null){
                    result = lists[index];
                    p = result;
                }else{
                    p.next = lists[index];
                    p = p.next;
                }
                ListNode tmp = lists[index];
                lists[index] = lists[index].next;
                tmp.next = null;
            }else{
                break;
            }
        }
        return result;
    }
    // 使用小顶堆的方法
    public ListNode mergeKLists2(ListNode[] lists){
        if(lists == null || lists.length ==0){
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (ListNode list1, ListNode list2) -> list1.val - list2.val);
        for(ListNode list : lists){
            if(list != null) {
                minHeap.offer(list);
            }
        }
        ListNode result = null,p = null;
        while(!minHeap.isEmpty()){
            ListNode poll = minHeap.poll();
            if(result == null){
                result = poll;
                p = result;
            }else{
                p.next = poll;
                p = p.next;
            }
            if(poll.next != null){
                minHeap.offer(poll.next);
                poll.next = null;
            }

        }
        return result;
    }

}

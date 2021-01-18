  //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.*;

  public class RemoveDuplicatesFromSortedList{
      public static void main(String[] args) {
           Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
           int i = 1;
           ListNode head = new ListNode(1);
           ListNode s = new ListNode(1);
           ListNode ss = new ListNode(2);
           head.next = s;
           s.next = ss;
           solution.deleteDuplicates(head);
       }
      //leetcode submit region begin(Prohibit modification and deletion)



class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
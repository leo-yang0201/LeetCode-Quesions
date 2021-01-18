  //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

  
  package com.zimoyang.leetcode.editor.cn;
  public class MergeTwoSortedLists{
      public static void main(String[] args)
      {
           Solution solution = new MergeTwoSortedLists().new Solution();
           ListNode node1 = new ListNode(1);
           node1.next = new ListNode(2);
           node1.next.next = new ListNode(4);
           ListNode node2 = new ListNode(1);
           node2.next = new ListNode(3);
           node2.next.next = new ListNode(4);
           solution.mergeTwoLists(node1,node2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  //实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;

  public class KthNodeFromEndOfListLcci{
      public static void main(String[] args) {

          Solution solution = new KthNodeFromEndOfListLcci().new Solution();
          ListNode head = new ListNode(3);
          head.next = new ListNode(7);
          head.next.next = new ListNode(9);
          head.next.next.next = new ListNode(3);
          head.next.next.next.next = new ListNode(5);
          head.next.next.next.next.next = new ListNode(8);
          head.next.next.next.next.next.next = new ListNode(0);
          solution.kthToLast(head,1);
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
    public int kthToLast(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0;i < k;i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            head = head.next;
        }
        return head.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
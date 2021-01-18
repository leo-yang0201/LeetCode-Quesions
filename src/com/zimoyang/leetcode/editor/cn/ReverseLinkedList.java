  //反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

  
  package com.zimoyang.leetcode.editor.cn;
  public class ReverseLinkedList{
      public static void main(String[] args) {

          Solution solution = new ReverseLinkedList().new Solution();
          ListNode head = new ListNode(5);
          head.next = new ListNode(7);
          head.next.next = new ListNode(9);
          head.next.next.next = new ListNode(2);
          solution.reverseList(head);
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
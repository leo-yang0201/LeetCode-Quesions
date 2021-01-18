  //给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针

  
  package com.zimoyang.leetcode.editor.cn;
  public class RotateList{
      public static void main(String[] args) {

          Solution solution = new RotateList().new Solution();
          ListNode node = new ListNode(1);
          node.next = new ListNode(2);
          node.next.next = new ListNode(3);
          node.next.next.next = new ListNode(4);
          node.next.next.next.next = new ListNode(5);
          solution.rotateRight(node,2);
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int i;
        for (i = 0;fast.next != null;i++) {
            fast = fast.next;
        }
        for (int j = i - k % i;j > 0;j--) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
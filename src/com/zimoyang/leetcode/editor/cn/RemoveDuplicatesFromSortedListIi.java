  //给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表

  
  package com.zimoyang.leetcode.editor.cn;


  import java.util.Stack;

  public class RemoveDuplicatesFromSortedListIi{
      public static void main(String[] args) {
           Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
           ListNode head = new ListNode(1);
           ListNode x1 = new ListNode(1);
          ListNode x2 = new ListNode(1);
          ListNode x3 = new ListNode(2);
          ListNode x4 = new ListNode(3);
          ListNode x5 = new ListNode(4);
          ListNode x6 = new ListNode(5);
          head.next = x1;
          x1.next = x2;
          x2.next = x3;
          x3.next = x4;
          x4.next = x5;
          x5.next = x6;
          solution.deleteDuplicates(head);

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
    public ListNode deleteDuplicates(ListNode head) {
          ListNode pre = new ListNode(-1);
          ListNode dummy = pre;
          pre.next = head;
          ListNode cur = head;
          while (cur != null && cur.next != null) {
              boolean equal = false;
              //cur 和 cur.next相等，cur不停后移
              while (cur.next != null && cur.val == cur.next.val){
                  cur = cur.next;
                  equal = true;
              }
              // 发生了相等的情况
              // pre.next 直接指向cur.next，跳过所有的重复数字
              if (equal) {
                  pre.next = cur.next;
                  equal = false;
              }
              // 没有发生相等情况
              // pre移动到cur的位置
              else {
                  pre = cur;
              }
              // cur后移
              cur = cur.next;
          }
          return dummy.next;
//        Stack<Integer> stack = new Stack();
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode temp = head;
//        if (head == null) return null;
//        if (head.next == null) return head;
//        while (temp.next != null) {
//            if (stack.isEmpty()) stack.push(temp.val);
//            int c = stack.peek();
//            if (temp.next.val != c) {
//            stack.push(temp.next.val);
//            } else {
//                stack.pop();
//            }
//        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  //给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

  
  package com.zimoyang.leetcode.editor.cn;
  public class ReverseNodesInKGroup{
      public static void main(String[] args) {

          Solution solution = new ReverseNodesInKGroup().new Solution();
          ListNode head = new ListNode(1);
          head.next = new ListNode(2);
          head.next.next = new ListNode(3);
          head.next.next.next = new ListNode(4);
          head.next.next.next.next = new ListNode(5);
          solution.reverseKGroup(head,2);
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // 如果prev为空，说明翻转结束了，返回dummy.next
        // 否则prev等于每次执行完reverse操作后的tail值（下一个子序列的prev）
        while (prev != null){
            prev = reverse(prev,k);
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode prev,int k) {
        // 设置新指针last，指向k后面的一个结点
        // 如果last为空，说明剩余结点不到k个，翻转结束返回null
        // 注意 i != k 也是满足条件，因为可能出现剩余结点数正好为k个的情况
        // 需要继续翻转
        ListNode last = prev;
        for (int i = 0; i < k + 1; i++) {
            last = last.next;
            if (i != k && last == null) return null;
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while (curr != last) {
            // 设置指针next记住curr指向的下一个结点
            ListNode next = curr.next;
            // 把curr结点挪到最前面
            curr.next = prev.next;
            prev.next = curr;
            tail.next = next;
            // 交换完毕，令curr指向下一个要交换的结点next
            curr = next;
        }
        // 全部交换完毕后，tail的下一个结点即是next
        // 返回tail作为下一次交换过程的prev
        return tail;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

  }
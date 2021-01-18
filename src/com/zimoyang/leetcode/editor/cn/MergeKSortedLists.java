  //合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.Comparator;
  import java.util.PriorityQueue;

  public class MergeKSortedLists{
      public static void main(String[] args) {

          Solution solution = new MergeKSortedLists().new Solution();
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
    public ListNode mergeKLists(ListNode[] lists) {
        //两两合并
        if (lists.length == 0) {
            return null;
        }

        ListNode res = lists[0];
        for (int i = 1;i < lists.length;i++) {
            if (lists[i] != null) {
                res = mergeTwoSortLinkedList(res,lists[i]);
            }
        }
        return res;

    }
    private ListNode mergeTwoSortLinkedList(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode cur = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
            }

        }
        if (p1 == null) {
            cur.next = p2;
        } else if (p2 == null) {
            cur.next = p1;
        }
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
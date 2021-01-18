//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表


package com.zimoyang.leetcode.editor.cn;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        int m = 2;
        int n = 4;
        Solution solution = new ReverseLinkedListIi().new Solution();
        solution.reverseBetween(root, m, n);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode node = dummy;
            for (int i = 1; i < m; i++) {
                node = node.next;
            }
            ListNode M = node.next;
            ListNode next = null;
            ListNode pre = null;
            for (int i = m; i <= n; i++) {
                next = M.next;
                M.next = pre;
                pre = M;
                M = next;
            }
            node.next.next = next;
            node.next = pre;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
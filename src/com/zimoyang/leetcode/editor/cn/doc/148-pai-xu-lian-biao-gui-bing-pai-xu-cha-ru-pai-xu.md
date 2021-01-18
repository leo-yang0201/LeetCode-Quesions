### 解题思路
此处撰写解题思路

### 代码
1.递归归并排序
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {//递归归并排序
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){//如果是空节点或孤立节点，直接返回
            return head;
        }
        ListNode slow=head,fast=head.next;//用快慢指针法找出链表的中间节点
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;//纪录中间结点即另一个子链表的头结点
        slow.next=null;//断链，将链表从中间分成均匀的两个子链表
        ListNode left=sortList(head);//递归出有序的子链表的头结点
        ListNode right=sortList(temp);
        ListNode dummy=new ListNode(0);//给链表加上哑头结点，便于操作
        ListNode pre=dummy;//pre指针指向哑头结点
        while(left!=null&&right!=null){//将两个有序的子链表合并成一个有序的链表
            if(left.val<=right.val){
                pre.next=left;
                left=left.next;
            }else{
                pre.next=right;
                right=right.next;
            }
            pre=pre.next;
        }
        pre.next=left==null?right:left;//如果子链表中还有剩余的节点，直接将其接到合并后的链表后面
        return dummy.next;
    }
}
```
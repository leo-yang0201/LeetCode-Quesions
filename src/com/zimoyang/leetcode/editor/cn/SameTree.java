  //给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索

  
  package com.zimoyang.leetcode.editor.cn;

  import apple.laf.JRSUIUtils;

  import java.util.LinkedList;
  import java.util.Queue;

  public class SameTree{
      public static void main(String[] args) {

          Solution solution = new SameTree().new Solution();
          TreeNode node1 = new TreeNode(0);
//          node1.right = new TreeNode(3);
//          node1.left = new TreeNode(2);
          TreeNode node2 = new TreeNode(0);
//          node2.left = new TreeNode(2);
//          node2.right = new TreeNode(3);
          System.out.println(solution.isSameTree(node1,node2));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p); q2.offer(q);
        while (!q1.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if (n1.val != n2.val) return false;
            if ((n1.left == null) != (n2.left == null)) return false;
            if ((n1.right == null) != (n2.right == null)) return false;
            if (n1.left != null && n2.left != null) {
                q1.offer(n1.left);
                q2.offer(n2.left);
            }
            if (n2.right != null && n1.right != null) {
                q1.offer(n1.right);
                q2.offer(n2.right);
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
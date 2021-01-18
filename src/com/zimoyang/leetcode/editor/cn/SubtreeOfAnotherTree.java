  //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树

  
  package com.zimoyang.leetcode.editor.cn;
  public class SubtreeOfAnotherTree{
      public static void main(String[] args) {

          Solution solution = new SubtreeOfAnotherTree().new Solution();
          TreeNode s = new TreeNode(3);
          s.left = new TreeNode(4);
          s.right = new TreeNode(5);
          s.left.left = new TreeNode(1);
          s.left.right = new TreeNode(2);
          TreeNode t = new TreeNode(4);
          t.left = new TreeNode(1);
          t.right = new TreeNode(2);
          solution.isSubtree(s,t);
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return subTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    private boolean subTree(TreeNode s,TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return subTree(s.left,t.left) && subTree(s.right,t.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
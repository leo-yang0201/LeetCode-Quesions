  //实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。 示例 1: 给定二叉树 [3,9,20,nu
//ll,null,15,7]     3    / \   9  20     /  \    15   7 返回 true 。示例 2: 给定二叉树 [1,2,
//2,3,3,null,null,4,4]       1      / \     2   2    / \   3   3  / \ 4   4 返回 fal
//se 。 Related Topics 树 深度优先搜索

  
  package com.zimoyang.leetcode.editor.cn;
  public class CheckBalanceLcci{
      public static void main(String[] args) {

          Solution solution = new CheckBalanceLcci().new Solution();
          TreeNode head = new TreeNode(1);
          head.right = new TreeNode(2);
          head.left = new TreeNode(2);
          head.left.left = new TreeNode(3);
          head.left.right = new TreeNode(3);
          head.left.left.left = new TreeNode(4);
          head.left.left.right = new TreeNode(4);
          solution.isBalanced(head);
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
    //定义变量剪枝
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        getDepth(root);
        return isBalance;
    }
    private int getDepth(TreeNode node) {
        //如果已经找到不平衡的树枝，不需要递归，直接返回
        if (!isBalance) {
            return 0;
        }
        if (node == null) return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        //判断左右树是不是平衡，如果不平衡就更新剪枝变量
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return Math.max(left,right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
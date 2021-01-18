  //给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.Collections;
  import java.util.LinkedList;
  import java.util.List;
  import java.util.Queue;

  public class BinaryTreeLevelOrderTraversalIi{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<Integer>();
            int levelOrder = queue.size();
            for (int i = 0;i < levelOrder;i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    subList.add(cur.val);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            if (subList.size() > 0) {
                ans.add(subList);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
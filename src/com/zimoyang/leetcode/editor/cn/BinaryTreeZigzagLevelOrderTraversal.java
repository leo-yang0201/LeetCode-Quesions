  //给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.LinkedList;
  import java.util.List;
  import java.util.Queue;

  public class BinaryTreeZigzagLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
          TreeNode root = new TreeNode(3);
          TreeNode l1 = new TreeNode(9);
          TreeNode r1 = new TreeNode(20);
          TreeNode r1l1 = new TreeNode(15);
          TreeNode r1r1 = new TreeNode(7);
          root.left = l1;
          root.right = r1;
          r1.left = r1l1;
          r1.right = r1r1;
//          solution.zigzagLevelOrder(root);
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
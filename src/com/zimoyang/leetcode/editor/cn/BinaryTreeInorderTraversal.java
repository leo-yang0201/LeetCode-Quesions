  //给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  public class BinaryTreeInorderTraversal{
      public static void main(String[] args) {

          Solution solution = new BinaryTreeInorderTraversal().new Solution();
          TreeNode head = new TreeNode(1);
          head.left = new TreeNode(2);
          head.right = new TreeNode(2);
          head.right.left = new TreeNode(3);
          solution.inorderTraversal(head);
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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(ans,root);
        return ans;
    }

    private void helper(List<Integer> list,TreeNode node) {
        if (node == null) return;
        helper(list,node.left);
        list.add(node.val);
        helper(list,node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
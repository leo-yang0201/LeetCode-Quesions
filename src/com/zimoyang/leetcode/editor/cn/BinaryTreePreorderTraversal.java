  //给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Deque;
  import java.util.LinkedList;
  import java.util.List;

  public class BinaryTreePreorderTraversal{
      public static void main(String[] args) {

          Solution solution = new BinaryTreePreorderTraversal().new Solution();
          TreeNode root = new TreeNode(1);
          TreeNode l1 = null;
          TreeNode r1 = new TreeNode(2);
          TreeNode r1l1 = new TreeNode(3);
          TreeNode r1r1 = null;
          root.left = l1;
          root.right = r1;
          r1.left = r1l1;
          r1.right = r1r1;
          solution.preorderTraversal(root);
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        List<Integer> list = new ArrayList<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
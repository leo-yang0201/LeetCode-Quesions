  //给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  public class BinaryTreePaths{
      public static void main(String[] args) {
           Solution solution = new BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root,"",ans);
        return ans;
    }

    private void dfs(TreeNode root, String s, List<String> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans.add(s + root.val);
            return;
        }
        dfs(root.left,s + root.val + "->",ans);
        dfs(root.right,s + root.val + "->",ans);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
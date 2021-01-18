  //给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.*;

  public class MostFrequentSubtreeSum{
      public static void main(String[] args) {

          Solution solution = new MostFrequentSubtreeSum().new Solution();
          TreeNode head = new TreeNode(5);
          head.left = new TreeNode(2);
          head.right = new TreeNode(-5);
          solution.findFrequentTreeSum(head);
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
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        if (root.left == null && root.right == null) {
            return new int[]{root.val};
        }
        dfs(root);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) == max) {
                list.add(i);
            }
        }
        int ans[] = new int[list.size()];
        for (int i = 0;i < ans.length;i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int sum = left + right + node.val;
        map.put(sum,map.getOrDefault(sum,0) + 1);
        max = Math.max(max,map.get(sum));
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
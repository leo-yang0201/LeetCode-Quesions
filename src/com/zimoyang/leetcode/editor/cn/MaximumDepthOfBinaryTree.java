//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索


package com.zimoyang.leetcode.editor.cn;

import java.util.LinkedList;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.left.left = null;
        root.left.right = null;
        root.right.right = new TreeNode(7);
        solution.maxDepth(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)



    class Solution {
        public int maxDepth(TreeNode root) {
            //迭代，BFS的层次遍历思想，记录二叉树的层数
            //遍历完，层数即为最大深度
            if (root == null) return 0;
            else {
                return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
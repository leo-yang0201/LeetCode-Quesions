//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
//
// 示例 : 
//给定二叉树 
//
// 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树


package com.zimoyang.leetcode.editor.cn;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {

        Solution solution = new DiameterOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private int result = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            dfs(root);
            return result;
        }

        public int dfs(TreeNode root) {
            if (root == null) return 0;
            int leftDepth = dfs(root.left);
            int rightDepth = dfs(root.right);
            if ((leftDepth + rightDepth) > result){
                result = leftDepth +rightDepth;
            }
            return Math.max(leftDepth, rightDepth) + 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
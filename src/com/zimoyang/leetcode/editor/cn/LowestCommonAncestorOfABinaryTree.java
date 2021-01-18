  //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树

  
  package com.zimoyang.leetcode.editor.cn;
  public class LowestCommonAncestorOfABinaryTree{
      public static void main(String[] args) {
           Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
           TreeNode head = new TreeNode(3);
           head.left = new TreeNode(5);
           head.right = new TreeNode(1);
           head.left.left = new TreeNode(6);
           head.left.right = new TreeNode(2);
           head.left.right.left = new TreeNode(7);
           head.left.right.right = new TreeNode(4);
           head.right.left = new TreeNode(0);
           head.right.right = new TreeNode(8);
           solution.lowestCommonAncestor(head,head.right.left,head.right);
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null && right == null) return null;// left和right同时为空，说明root的左右子树中都不包含p,q，返回null
        if (left == null) return right;//left为空，right不为空，p,q都不在root的左子树中，直接返回right
        //可分两种情况
        //1. p,q其中一个在root的右子树中，此时right指向p
        //2. p,q两个节点都在root的右子树中，此时的right指向最近公共祖先节点
        if (right == null) return left;
        //right为空，left不为空，和上面同理
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  //根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

  
  package com.zimoyang.leetcode.editor.cn;

  import java.time.chrono.MinguoDate;
  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.TreeMap;

  public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
           int preorder[] = new int[]{3,9,20,15,7};
           int inorder[] = new int[]{9,3,15,20,7};
           solution.buildTree(preorder,inorder);
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0;i < preorder.length;i++) {
            if (preorder[0] == inorder[i]) {
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(pre_left, in_left);
                root.right = buildTree(pre_right, in_right);
                break;
            }
            
        }
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
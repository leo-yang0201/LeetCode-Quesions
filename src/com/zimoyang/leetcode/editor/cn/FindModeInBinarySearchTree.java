  //给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.HashMap;
  import java.util.LinkedList;
  import java.util.List;
  import java.util.Map;

  public class FindModeInBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new FindModeInBinarySearchTree().new Solution();
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
    Map<Integer,Integer> map;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        this.map = new HashMap<>();
        inorder(root);
        List<Integer> list = new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) list.add(key);
        }
        int[] res = new int[list.size()];
        for (int i = 0;i < res.length;i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inorder(TreeNode node) {
        if (node.left != null) inorder(node.left);
        map.put(node.val,map.getOrDefault(node.val,0)+ 1);
        max = Math.max(max,map.get(node.val));
        if (node.right != null) inorder(node.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
  //给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

  
  package com.zimoyang.leetcode.editor.cn;

  import javax.swing.plaf.synth.SynthEditorPaneUI;
  import java.util.ArrayList;
  import java.util.LinkedList;
  import java.util.List;
  import java.util.Queue;

  public class BinaryTreeLevelOrderTraversal{
      public static void main(String[] args) {

          Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
          TreeNode root = new TreeNode(3);
          TreeNode l1 = new TreeNode(9);
          TreeNode r1 = new TreeNode(20);
          TreeNode r1l1 = new TreeNode(15);
          TreeNode r1r1 = new TreeNode(7);
          root.left = l1;
          root.right = r1;
          r1.left = r1l1;
          r1.right = r1r1;
          List<List<Integer>> result = solution.levelOrder(root);
          System.out.println(result);
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<Integer>();
            int levelOrder = queue.size();
            for (int i = 0;i < levelOrder;i++) {
                TreeNode cur = queue.poll();
                subList.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }

            if (subList.size() > 0) {
                ans.add(subList);
            }
        }

        return ans;
//        List<List<Integer>> ans = new ArrayList<>();
//        if (root == null) return new ArrayList<List<Integer>>();
//        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//        //将根结点放入队列中，然后不断遍历队列
//        queue.add(root);
//        while(queue.size() > 0) {
//            //获取当前队列的长度，这个长度相当于当前这一层的结点数
//            int size = queue.size();
//            ArrayList<Integer> tmp = new ArrayList<Integer>();
//            //将队列中的元素都拿出来(也就是获取这一层的结点），放到临时list中
//            //如果结点的左右子树不为空，也放入队列中
//            for (int i = 0; i < size;i++) {
//                TreeNode t = queue.remove();
//                tmp.add(t.val);
//                if (t.left != null) queue.add(t.left);
//                if (t.right != null) queue.add(t.right);
//            }
//            ans.add(tmp);
//        }
//        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }


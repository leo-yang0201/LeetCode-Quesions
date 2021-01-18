//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索


package com.zimoyang.leetcode.editor.cn;

import com.zimoyang.leetcode.editor.cn.InsertInterval;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    public static void main(String[] args) {

        Solution solution = new PathSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            Queue<Integer> queueSum = new LinkedList<Integer>();
            if (root == null) return false;
            queue.offer(root);
            queueSum.offer(root.val);
            while (!queue.isEmpty()) {
                int levelSum = queue.size();// 当前层的个数
                for (int i = 0; i < levelSum; i++) {
                    TreeNode curNode = queue.poll();
                    int curSum = queueSum.poll();
                    if (curNode != null) {
                        //判断叶子结点是否满足条件
                        if (curNode.left == null && curNode.right == null && curSum == sum) {
                            return true;
                        }
                        //当前结点和累计的和加入队列
                        if (curNode.left != null) {
                            queue.offer(curNode.left);
                            queueSum.offer(curSum + curNode.left.val);
                        }
                        if (curNode.right != null) {
                            queue.offer(curNode.right);
                            queueSum.offer(curSum + curNode.right.val);
                        }
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



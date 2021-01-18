  //给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.HashMap;

  public class UniqueBinarySearchTrees{
      public static void main(String[] args) {
          Solution solution = new UniqueBinarySearchTrees().new Solution();
          solution.numTrees(3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        if (n == 0) return 0;
        HashMap<Integer,Integer> memozation = new HashMap<>();
        return getAns(n,memozation);
    }

    private int getAns(int n, HashMap<Integer, Integer> memozation) {
        if (memozation.containsKey(n)) return memozation.get(n);
        int ans = 0;
        if (n == 0 || n == 1) return 1;
        for (int i = 1;i <= n;i++) {
            int leftTreeNum = getAns(i - 1,memozation);
            int rightTreeNum = getAns(n - i,memozation);
            ans += leftTreeNum * rightTreeNum;
        }
        memozation.put(n,ans);
        return ans;
    }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }
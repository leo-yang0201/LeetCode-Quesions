  //在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划

  
  package com.zimoyang.leetcode.editor.cn;
  public class MaximalSquare{
      public static void main(String[] args) {

          Solution solution = new MaximalSquare().new Solution();
          char[][] matrix = new char[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
          solution.maximalSquare(matrix);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
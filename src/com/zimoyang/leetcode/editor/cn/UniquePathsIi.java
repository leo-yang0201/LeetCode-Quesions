  //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.HashMap;

  public class UniquePathsIi{
      public static void main(String[] args) {

          Solution solution = new UniquePathsIi().new Solution();
          int[][] a = new int[3][4];
          a[0][2] = 1;
          a[2][1] = 1;
          solution.uniquePathsWithObstacles(a);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //起点是障碍，直接返回0
        if (obstacleGrid[0][0] == 1) return 0;
        int[] dp = new int[n];
        int i = 0;
        //初始化第一行和62不一样了
        //这里的话不是全部初始化1了，因为如果有障碍的话，当前列和后边的列就都走不过去了，初始化为0
        for(;i < n;i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[i] = 0;
                break;
            } else {
                dp[i] = 1;
            }
        }
        //障碍后边的列全部初始化为0
        for (;i < n;i++) {
            dp[i] = 0;
        }
        for (i = 1;i < m;i++) {
            //这里改成从0列开始了，因为62题中从1开始是因为第0列永远是1不需要更新
            //这里的话，如果第0列是障碍的话，需要更新为0
            for (int j = 0;j < n;j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                else {
                    //由于从第0列开始了，更新公式有j - 1，所以j = 0的时候不更新
                    if (j != 0) {
                        dp[j] = dp[j] + dp[j - 1];
                    }
                }
            }
        }
        return dp[(n - 1)];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
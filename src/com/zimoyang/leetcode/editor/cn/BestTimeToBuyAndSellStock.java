  //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。 
//
// 注意你不能在买入股票前卖出股票。 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.regex.Matcher;

  public class BestTimeToBuyAndSellStock{
      public static void main(String[] args) {

          Solution solution = new BestTimeToBuyAndSellStock().new Solution();
          int a[] = new int[]{7,1,5,3,6,4};
          System.out.println(solution.maxProfit(a));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2];
        for (int i = 0;i < n;i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                // dp[i][0] = max(dp[-1][0],dp[-1][1]+prices[i])
                // = max(0,-infinity+prices[i]) = 0
                dp[i][1] = -prices[i];
                // dp[i][1] = max(dp[-1][1],dp[-1][0] - prices[i])
                // = max(-infinity,0 - prices[i])
                // = -prices[i]
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

  
  package com.zimoyang.leetcode.editor.cn;
  public class LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();
           String s = solution.longestPalindrome("cbbd");
          System.out.println(s);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        for (int i = 0;i < len;i++) {
            dp[i][i] = true;
        }
        for (int j = 1;j < len;j++) {
            for (int i = 0;i < j;i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
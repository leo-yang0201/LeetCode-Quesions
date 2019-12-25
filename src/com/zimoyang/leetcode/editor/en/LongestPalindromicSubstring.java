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

package com.zimoyang.leetcode.editor.en;
public class LongestPalindromicSubstring{
    public static void main(String[] args) {

        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s = "ababcba";
        solution.longestPalindrome(s);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return "";
            int start = 0, end = 0;
            int maxLen = 0;
            int n = s.length();
            //index是0不能向两边扩散，所以从1开始
            for (int i = 1; i < n; i++){
                int len1 = extendByCenter(s,i,i);
                int len2 = extendByCenter(s,i - 1,i);

                if (len1 > maxLen){
                    start = i - len1 / 2;
                    end = i + len1 / 2;
                    maxLen = len1;
                }

                if (len2 > maxLen){
                    start = i - len2 / 2;
                    end = i - 1 + len2 / 2;
                    maxLen = len2;
                }
            }
            return s.substring(start,end + 1);
        }

        private int extendByCenter(String s, int lo, int hi){
            int maxLen = 1;
            while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
                maxLen = hi - lo + 1;
                lo--;
                hi++;
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
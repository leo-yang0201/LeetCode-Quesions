  //给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串

  
  package com.zimoyang.leetcode.editor.cn;


  public class ValidPalindromeIi{
      public static void main(String[] args) {

          Solution solution = new ValidPalindromeIi().new Solution();
          boolean a = solution.validPalindrome("eeeea");
          System.out.println(a);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        char sc[] = s.toCharArray();
        int left = 0,right = sc.length - 1;
        while (left < right) {
            if (sc[left] != sc[right]) {
                return helper(sc,left + 1,right) || helper(sc,left,right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean helper(char[] sc,int left,int right) {
        while (left < right) {
            if (sc[left] != sc[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  //给你一个回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，且 不是 回文串。 
//
// 请你返回结果字符串。如果无法做到，则返回一个空串。 
//
// 
//
// 示例 1： 
//
// 输入：palindrome = "abccba"
//输出："aaccba"
// 
//
// 示例 2： 
//
// 输入：palindrome = "a"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= palindrome.length <= 1000 
// palindrome 只包含小写英文字母。 
// 
// Related Topics 字符串

  
  package com.zimoyang.leetcode.editor.cn;
  public class BreakAPalindrome{
      public static void main(String[] args) {

          Solution solution = new BreakAPalindrome().new Solution();
          String s = "aaaa";
          String res = solution.breakPalindrome(s);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        char[] a = palindrome.toCharArray();
        boolean flag = false;
        for (int i = 0; i < a.length / 2; i++) {
            if (a[i] != 'a') {
                a[i] = 'a';
                flag = true;
                break;
            }
        }
        if (!flag) a[a.length - 1] = 'b';
        return new String(a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

  
  package com.zimoyang.leetcode.editor.cn;

  import javax.tools.Diagnostic;
  import java.util.ArrayList;
  import java.util.List;

  public class LetterCombinationsOfAPhoneNumber{
      public static void main(String[] args) {
           Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
           solution.letterCombinations("23");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          private String letterMap[] = {
                  " ",
                  "",
                  "abc",
                  "def",
                  "ghi",
                  "jkl",
                  "mno",
                  "pqrs",
                  "tuv",
                  "wxyz"
          };
          private ArrayList<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<String>();
        if (digits.equals("")) {
            return ans;
        }
        backtrack(digits,0,"");
        return ans;
    }

    private void backtrack(String digits, int i, String s) {
        if (i == digits.length()) {
            ans.add(s);
            return;
        }
        Character c = digits.charAt(i);
        String letters = letterMap[c - '0'];
        for (int j = 0;j < letters.length();j++) {
            backtrack(digits,i + 1,s + letters.charAt(j));
        }
        return;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }
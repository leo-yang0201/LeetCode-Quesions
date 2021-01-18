  //给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//示例:
//输入: S = "a1b2"
//输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入: S = "3z4"
//输出: ["3z4", "3Z4"]
//
//输入: S = "12345"
//输出: ["12345"]
// 
//
// 注意： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法
  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  public class LetterCasePermutation{
      public static void main(String[] args) {

          Solution solution = new LetterCasePermutation().new Solution();
          String S = "a1b2";
          solution.letterCasePermutation(S);
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList();
//        list.add(S);
        char[] array = S.toCharArray();
        for (int i = 0; i < array.length; i++){
            if (Character.isLetter(array[i])){
                if (Character.isLowerCase(array[i])){
                    array[i] = Character.toUpperCase(array[i]);
                    String s = String.valueOf(array);
                    list.add(s);
                }
//                if (Character.isUpperCase(array[i])){
//                    array[i] = Character.toLowerCase(array[i]);
//                    String s = String.valueOf(array);
//                    list.add(s);
//                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  //给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串

  
  package com.zimoyang.leetcode.editor.cn;
  public class ReverseWordsInAStringIii{
      public static void main(String[] args) {
           Solution solution = new ReverseWordsInAStringIii().new Solution();
           solution.reverseWords("Let's take LeetCode contest");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        String[] res = new String[array.length];
        for (int i = 0;i < array.length;i++) {
            char[] c = array[i].toCharArray();
            for (int j = 0;j < c.length / 2;j++) {
                char temp;
                temp = c[j];
                c[j] = c[c.length - 1 - j];
                c[c.length - 1 - j] = temp;
            }
            res[i] = String.valueOf(c);
        }
        StringBuilder sb = new StringBuilder();
        if (res != null && res.length > 0) {
            for (int i = 0;i < res.length;i++) {
                if (i < res.length - 1) {
                    sb.append(res[i] + " ");
                } else {
                    sb.append(res[i]);
                }
            }
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
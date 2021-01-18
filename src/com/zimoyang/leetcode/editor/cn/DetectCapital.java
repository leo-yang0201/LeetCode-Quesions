  //给定一个单词，你需要判断单词的大写使用是否正确。 
//
// 我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如"USA"。 
// 单词中所有字母都不是大写，比如"leetcode"。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。 
// 
//
// 否则，我们定义这个单词没有正确使用大写字母。 
//
// 示例 1: 
//
// 
//输入: "USA"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "FlaG"
//输出: False
// 
//
// 注意: 输入是由大写和小写拉丁字母组成的非空单词。 
// Related Topics 字符串

  
  package com.zimoyang.leetcode.editor.cn;
  public class DetectCapital{
      public static void main(String[] args) {

          Solution solution = new DetectCapital().new Solution();
          solution.detectCapitalUse("FaceBook");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        char array[] = word.toCharArray();
        int left = 1;
        int right = array.length - 1;
        while (left <= right) {
            if (Character.isUpperCase(array[0])) {
                if (left == right) {
                    if ((Character.isUpperCase(array[left]) && Character.isLowerCase(array[left - 1]))||(Character.isLowerCase(array[left]) && Character.isUpperCase(array[left - 1]))) {
                        return false;
                    }
                }
                if ((Character.isUpperCase(array[left]) && Character.isLowerCase(array[right]))||(Character.isLowerCase(array[left]) && Character.isUpperCase(array[right]))) {
                    if (left == right && Character.isUpperCase(array[left]) && Character.isLowerCase(left - 1)) {
                        return false;
                    }
                    return false;
                }
                else {
                    left++;
                    right--;
                }
            }
            else {
                if ((Character.isLowerCase(array[left]) && Character.isUpperCase(array[right])) || (Character.isUpperCase(array[left]) && Character.isLowerCase(array[right]))) {
                    return false;
                }
                else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
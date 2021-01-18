  //给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 310 👎 0

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayDeque;

  public class RemoveDuplicateLetters{
      public static void main(String[] args) {

          Solution solution = new RemoveDuplicateLetters().new Solution();
          solution.removeDuplicateLetters("bcabc");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0;i < s.length();i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        ArrayDeque<Character> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        for (int i = 0;i < s.length();i++) {
            char cur = s.charAt(i);
            if (visited[cur - 'a']) {
                continue;
            }
            while (!deque.isEmpty() && cur < deque.peekLast() && lastIndex[deque.peekLast() - 'a'] > i) {
                char top = deque.removeLast();
                visited[top - 'a'] = false;
            }
            deque.addLast(s.charAt(i));
            visited[cur - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.insert(0,deque.removeLast());
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
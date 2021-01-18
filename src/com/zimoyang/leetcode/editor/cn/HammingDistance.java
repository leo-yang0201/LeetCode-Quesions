  //两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算

  
  package com.zimoyang.leetcode.editor.cn;
  public class HammingDistance{
      public static void main(String[] args) {
           Solution solution = new HammingDistance().new Solution();
           solution.hammingDistance(1,4);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        String s1 = get32BitBinString(x);
        String s2 = get32BitBinString(y);
        int count = 0;
        for (int i = 0;i < s1.length();i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private String get32BitBinString(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 32;i++) {
            sb.append(number & 1);
            number = number >>> 1;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
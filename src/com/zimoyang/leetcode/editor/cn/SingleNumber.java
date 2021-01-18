  //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.Arrays;
  import java.util.HashMap;
  import java.util.Map;

  public class SingleNumber{
      public static void main(String[] args) {
           Solution solution = new SingleNumber().new Solution();
           int[] a = new int[]{4,1,2,1,2};
           solution.singleNumber(a);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i,count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1)
                return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
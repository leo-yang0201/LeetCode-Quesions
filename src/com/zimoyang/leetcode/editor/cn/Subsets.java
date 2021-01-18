  //给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.LinkedList;
  import java.util.List;

  public class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
           int[] i = new int[]{1,2,3};
           solution.subsets(i);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int bit_nums = nums.length;
        int ans_nums = 1 << bit_nums;//执行2的n次方
        for (int i = 0; i < ans_nums; i++) {
            List<Integer> tmp = new ArrayList<>();
            int count = 0;//记录当前对应数组哪一位
            int i_copy = i;//用来移位
            while (i_copy != 0) {
                if ((i_copy & 1) == 1) { //判断当前为是否是1
                    tmp.add(nums[count]);
                }
                count++;
                i_copy = i_copy >> 1;
            }
            ans.add(tmp);
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
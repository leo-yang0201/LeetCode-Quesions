  //给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回
// 0。 
//
// 示例: 
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 
//
// 进阶: 
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// Related Topics 数组 双指针 二分查找

  
  package com.zimoyang.leetcode.editor.cn;
  public class MinimumSizeSubarraySum{
      public static void main(String[] args) {
           Solution solution = new MinimumSizeSubarraySum().new Solution();
           solution.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int lo = 0,hi = 0,sum = 0;
        int min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min,hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  //给你一个整数数组 nums 和一个整数 k。 
//
// 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。 
//
// 请返回这个数组中「优美子数组」的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
// 
//
// 示例 3： 
//
// 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// 
// Related Topics 双指针

  
  package com.zimoyang.leetcode.editor.cn;
  public class CountNumberOfNiceSubarrays{
      public static void main(String[] args) {

          Solution solution = new CountNumberOfNiceSubarrays().new Solution();
          int[] a = new int[]{2,2,2,1,2,2,1,2,2,2};
          int k = 2;
          solution.numberOfSubarrays(a,k);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        int left = 0, right = 0;
        int count = 0;
        int res = 0;
        int preEven = 0;
        while (right < nums.length) {
            if (count < k) {
                if (!((nums[right] & 1) == 0)) {
                    count++;
                }
                right++;
            }

            if (count == k) {
                preEven = 0;
                while (count == k) {
                    res++;
                    if (!((nums[left] & 1) == 0)) {
                        count--;
                    }
                    left++;
                    preEven++;
                }
            } else {
                res += preEven;
            }
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
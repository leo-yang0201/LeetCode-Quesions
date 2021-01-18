  //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针

  
  package com.zimoyang.leetcode.editor.cn;

  import java.nio.channels.WritableByteChannel;
  import java.util.Arrays;

  public class ThreeSumClosest{
      public static void main(String[] args) {

          Solution solution = new ThreeSumClosest().new Solution();
          solution.threeSumClosest(new int[]{-1,2,1,-4},1);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start != end) {
                int min = nums[start] + nums[start + 1] + nums[i];
                if (target < min) {
                    if (Math.abs(ans - target) > Math.abs(min - target)) {
                        ans = min;
                        break;
                    }
                }
                int max = nums[end - 1] + nums[end] + nums[i];
                if (target > max) {
                    if (Math.abs(ans - target) > Math.abs(max - target)) {
                        ans = max;
                        break;
                    }
                }
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                    while (start != end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
                else {
                    start++;
                    while (start != end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
                while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }